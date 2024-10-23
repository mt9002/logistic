package com.api.unit;

import com.api.app.controllers.LogisticController;
import com.api.app.dto.LogisticDTO;
import com.api.app.dto.Response;
import com.api.config.NoSecurityConfig;
import com.api.domain.interfaces.outgoing.auth.IJWT;
import com.api.domain.services.logistic.LogisticService;
import com.api.unit.fixtures.LogisticFixture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(LogisticController.class)
@AutoConfigureMockMvc(addFilters = false)
@Import(NoSecurityConfig.class)
public class TestLogisticController {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    LogisticService logisticService;

    @MockBean
    IJWT jwtService;

    @Autowired
    ObjectMapper mapper;
    
    @BeforeAll
    public static void setup() {
        LogisticFixture.beforeAll();
    }

    @Test
    public void testGetByIdLogistic(TestInfo testInfo, TestReporter testReporter) throws Exception {
 
        Long idLogistic = LogisticFixture.logisticDTO.getId();
        var data = LogisticFixture.logisticDTO;
 
        Response response = new Response("logistic encontrado", 200, true, data);

        Mockito.when(logisticService.getByIdLogistic(idLogistic)).thenReturn(response);
        
        mockMvc.perform(MockMvcRequestBuilders.get("/logistic/getById")
                .param("id", String.valueOf(idLogistic))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("logistic encontrado"))
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.typeDelivery").value("LAND"));
    }

    @Test
    public void testDeleteLogistic() throws Exception {

        Long idLogistic = LogisticFixture.logisticDTO.getId();

            Response<?> response = new Response<>(
            "logistic eliminada",
            HttpStatus.OK.value(),
            true,
            null
    );

        Mockito.when(logisticService.deleteLogistic(idLogistic)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.delete("/logistic/delete")
                .param("id", String.valueOf(idLogistic))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("logistic eliminada"))
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data").isEmpty());
    }
    
    @Test
    public void testCreateLogistic() throws Exception {
        LogisticDTO data = LogisticFixture.logisticDTO;
        Response response = new Response("logistic creada", 200, true, null);
        
        Mockito.when(logisticService.createLogistic(
                        Mockito.any(LogisticDTO.class))).thenReturn(response);
        
        mockMvc.perform(MockMvcRequestBuilders.post("/logistic/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsBytes(data)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("logistic creada"))
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.success").value(true));
    }   
}
