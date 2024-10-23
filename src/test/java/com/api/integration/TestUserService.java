package com.api.integration;

import com.api.app.dto.Response;
import com.api.domain.interfaces.incoming.IUserService;
import com.api.domain.models.auth.Client;
import com.api.integration.factory.DBFactory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class TestUserService {

    @Autowired
    private IUserService UserService;

    @Autowired
    private DBFactory factories;

    @Test
    public void testGetbyId() {

        Client client = factories.createClient();

        Response response = UserService.getById(client.getId());

        Assertions.assertAll("Validación de Response",
                () -> Assertions.assertTrue(response.isSuccess()),
                () -> Assertions.assertEquals("User encontrado", response.getMessage()),
                () -> Assertions.assertEquals(200, response.getStatus())
        );

    }
}
