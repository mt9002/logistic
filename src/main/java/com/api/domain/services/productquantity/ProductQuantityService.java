package com.api.domain.services.productquantity;

import com.api.app.dto.ProductQuantityDTO;
import com.api.domain.interfaces.incoming.IProductQuantityService;
import com.api.domain.interfaces.outgoing.productquantity.IProductQuantityRepository;
import com.api.app.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductQuantityService implements IProductQuantityService{
    
    private final IProductQuantityRepository iProductQuantityRepository;

    @Autowired
    public ProductQuantityService(IProductQuantityRepository iProductQuantityRepository ) {
        this.iProductQuantityRepository =iProductQuantityRepository;
    }
    
    @Override
    public Response getByIdProductQuantity(Long id){ 
        var respponse = iProductQuantityRepository.getByIdProductQuantity(id);
        return respponse;
    }
    
    @Override
    public Response createProductQuantity(ProductQuantityDTO productQuantityDTO){
        var response = iProductQuantityRepository.createProductQuantity(productQuantityDTO);
        return response;
    }
    
    @Override
    public Response deleteProductQuantity(Long id){
        var respponse = iProductQuantityRepository.deleteProductQuantity(id);
        return respponse;
    }
}
