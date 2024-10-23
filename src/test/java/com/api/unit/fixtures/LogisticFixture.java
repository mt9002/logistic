package com.api.unit.fixtures;

import com.api.app.dto.LogisticDTO;
import com.api.app.dto.ProductQuantityDTO;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.stereotype.Component;

@Component
public class LogisticFixture {

    public static LogisticDTO logisticDTO;

    @BeforeAll
    public static void beforeAll() {
        List<ProductQuantityDTO> productQuantities = Arrays.asList(
                ProductQuantityDTO.builder()
                        .productId(1L)
                        .price(1000f)
                        .quantity(25).build(),
                ProductQuantityDTO.builder()
                        .productId(2L)
                        .price(20000f)
                        .quantity(33).build()
        );
        logisticDTO = new LogisticDTO(
                "LAND",
                productQuantities,
                1000D,
                900F,
                1L
        );
        logisticDTO.setId(1L);

    }
}
