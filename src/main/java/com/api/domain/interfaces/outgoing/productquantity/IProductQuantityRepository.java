package com.api.domain.interfaces.outgoing.productquantity;

import com.api.app.dto.ProductQuantityDTO;
import com.api.app.dto.Response;

public interface IProductQuantityRepository {
    Response getByIdProductQuantity(Long id);
    Response createProductQuantity(ProductQuantityDTO productQuantityDTO);
    Response deleteProductQuantity(Long id);
}
