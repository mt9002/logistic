package com.api.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductQuantityDTO {
    private Long productId;
    private int quantity;
    private Long idLogistic;
    private Float price;
}
