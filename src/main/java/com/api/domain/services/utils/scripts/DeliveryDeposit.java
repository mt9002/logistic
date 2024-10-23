package com.api.api.domain.services.utils.scripts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeliveryDeposit {
    private static final String CSV_FILE_PATH = "C:/Users/mauri/Pictures/JAVA/api/src/main/java/com/api/api/domain/services/utils/scripts/delivery_deposit.csv";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/logistic_dev";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Mao719";

    public static void main(String[] args) {
        String insertQuery = "INSERT INTO delivery_deposit (delivery_deposit_type, name) VALUES (?, ?)";

        try (
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH));
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)
        ) {

            String line;

            // Salta la primera línea si tiene encabezado
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.replace("\"", "").split(",");

                preparedStatement.setString(1, data[0]);
                preparedStatement.setString(2, data[1]);
              

                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
            System.out.println("Datos insertados correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
        // La conexión, el lector de archivos y el preparedStatement se cierran automáticamente aquí
    }
}
