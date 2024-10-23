package com.api.domain.services.productquantity.mapper;

import com.api.app.dto.ProductQuantityDTO;
import com.api.domain.interfaces.outgoing.mapper.IProductQuantityMapper;
import com.api.domain.models.Logistic;
import com.api.domain.models.product.ProductQuantity;
import org.springframework.stereotype.Component;

@Component
public class ProductQuantityMapper implements IProductQuantityMapper{
    
    @Override
    public ProductQuantity createMapper(ProductQuantityDTO productQuantityDTO){
        ProductQuantity productQuantity = new ProductQuantity();
        productQuantity.setId(productQuantityDTO.getProductId());
        productQuantity.setQuantity(productQuantityDTO.getQuantity());
        
        if (productQuantityDTO.getIdLogistic() != null) {
            Logistic logistic = new Logistic();
            logistic.setId(productQuantityDTO.getIdLogistic());
            productQuantity.setLogistic(logistic);
        }
        return productQuantity;
    }
}
