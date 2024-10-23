package com.api.domain.interfaces.incoming;

import com.api.app.dto.ProductQuantityDTO;
import com.api.app.dto.Response;

public interface IProductQuantityService{
    Response createProductQuantity(ProductQuantityDTO productQuantityDTO);
    Response getByIdProductQuantity(Long id);
    Response deleteProductQuantity(Long id);
}
