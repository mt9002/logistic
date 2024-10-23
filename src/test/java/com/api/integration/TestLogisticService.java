package com.api.integration;


import com.api.app.dto.LogisticDTO;
import com.api.app.dto.ProductQuantityDTO;
import com.api.app.dto.Response;
import com.api.domain.interfaces.incoming.IDeliveryDepositService;
import com.api.domain.interfaces.incoming.ILogisticService;
import com.api.domain.models.Logistic;
import com.api.domain.models.Vehicle;
import com.api.domain.models.deposit.DeliveryDeposit;
import com.api.domain.models.product.Product;
import com.api.integration.factory.DBFactory;
import jakarta.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class TestLogisticService {
    
    @Autowired
    private ILogisticService LogisticService;
    @Autowired
    private IDeliveryDepositService iDeliveryDepositService;
    
    @Autowired
    private DBFactory factories;
    
    
    @Test 
    public void testCreateLogistic() throws Exception {
        Product product = factories.createProduct();
        Vehicle vehicle = factories.createVehicle();
        DeliveryDeposit deliveryDeposit = factories.createDeliveryDeposit(vehicle.getId());

        List<ProductQuantityDTO> productQuantities = Arrays.asList(
                ProductQuantityDTO.builder()
                        .productId(product.getId())
                        .price(product.getPrice())
                        .quantity(25).build()
        );
        
        LogisticDTO logisticDTO = new LogisticDTO(
                "LAND",
                productQuantities,
                1000D,
                900F,
                deliveryDeposit.getId()  
        );
        
        Response response = LogisticService.createLogistic(logisticDTO);
 
        Assertions.assertAll("Validación de Response",
                () -> Assertions.assertTrue(response.isSuccess()),
                () -> Assertions.assertEquals("Logistic creado", response.getMessage()),
                () -> Assertions.assertEquals(200, response.getStatus())
        );
    }

    @Test
    public void testGetByidDisptach() throws Exception {

        // (Arrange)
        Logistic logistic = factories.createLogistic();
        Float discountedPrice = logistic.getDiscountedPrice();
        Double shippingPrice = logistic.getShippingPrice();

        // (Act)
        Response<Logistic> response = LogisticService.getByIdLogistic(logistic.getId());
        Logistic data = response.getData();
        
        // (Assert)
        Assertions.assertAll("Validación de Response",
                () -> Assertions.assertTrue(response.isSuccess()),
                () -> Assertions.assertEquals("Logistic encontrado", response.getMessage()),
                () -> Assertions.assertEquals(200, response.getStatus()),
                () -> Assertions.assertEquals(shippingPrice, data.getShippingPrice()),
                () -> Assertions.assertEquals(discountedPrice, data.getDiscountedPrice())
        );
    }

    @Test
    public void testDeleteDisptach() throws Exception {

        // (Arrange)
        Logistic logistic = factories.createLogistic();

        // (Act)
        Response<Logistic> response = LogisticService.deleteLogistic(logistic.getId());
        
        // (Assert)
        Assertions.assertAll("Validación de Response",
                () -> Assertions.assertTrue(response.isSuccess()),
                () -> Assertions.assertEquals("Logistic eliminada", response.getMessage()),
                () -> Assertions.assertEquals(200, response.getStatus())         
        );
    }
}
