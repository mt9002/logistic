package com.api.domain.interfaces.outgoing.mapper;

import com.api.app.dto.ProductQuantityDTO;
import com.api.domain.models.product.ProductQuantity;

public interface IProductQuantityMapper {
    ProductQuantity createMapper(ProductQuantityDTO logisticDTO);
}
