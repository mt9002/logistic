package com.api.integration;

import com.api.app.dto.DispatchDTO;
import com.api.app.dto.Response;
import com.api.domain.interfaces.incoming.IDispatchService;
import com.api.domain.models.Dispatch;
import com.api.integration.factory.DBFactory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class TestDispatchService {

    @Autowired
    private IDispatchService dispatchService;

    @Autowired
    private DBFactory factories;

    @Test
    public void testCreateDisptach() throws Exception {

        // (Arrange)
        var client = factories.createClient();
        var logistic = factories.createLogistic();

        DispatchDTO dispatchDTO = new DispatchDTO(
                client.getId(),
                logistic.getId());

        // (Act)
        Response response = dispatchService.createDispatch(dispatchDTO);

        // (Assert)
        Assertions.assertAll("Validación de Response",
                () -> Assertions.assertTrue(response.isSuccess()),
                () -> Assertions.assertEquals("Dispatch creado", response.getMessage()),
                () -> Assertions.assertEquals(200, response.getStatus())
        );
    }

    @Test
    public void testGetByidDisptach() throws Exception {

        // (Arrange)
        Dispatch dispatch = factories.createDispatch();
        String guideNumber = dispatch.getGuideNumber();
        String emailFactory = dispatch.getClient().getEmail();

        // (Act)
        Response<Dispatch> response = dispatchService.getByIdDispatch(dispatch.getId());
        Dispatch data = response.getData();

        // (Assert)
        Assertions.assertAll("Validación de Response",
                () -> Assertions.assertTrue(response.isSuccess()),
                () -> Assertions.assertEquals("Dispatch encontrado", response.getMessage()),
                () -> Assertions.assertEquals(200, response.getStatus()),
                () -> Assertions.assertEquals(guideNumber, data.getGuideNumber()),
                () -> Assertions.assertEquals(emailFactory, data.getClient().getEmail())
        );
    }

    @Test
    public void testDeleteDisptach() throws Exception {

        // (Arrange)
        Dispatch dispatch = factories.createDispatch();

        // (Act)
        Response response = dispatchService.deleteDispatch(dispatch.getId());

        // (Assert)
        Assertions.assertAll("Validación de Response",
                () -> Assertions.assertTrue(response.isSuccess()),
                () -> Assertions.assertEquals("Dispatch eliminada", response.getMessage()),
                () -> Assertions.assertEquals(200, response.getStatus())
        );
    }

}
