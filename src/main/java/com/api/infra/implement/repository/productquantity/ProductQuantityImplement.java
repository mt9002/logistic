package com.api.infra.implement.repository.productquantity;

import com.api.app.dto.ProductQuantityDTO;
import com.api.domain.interfaces.outgoing.jpaORM.IProductQuantityORM;
import com.api.domain.interfaces.outgoing.productquantity.IProductQuantityRepository;
import com.api.app.dto.Response;
import com.api.domain.interfaces.outgoing.mapper.IProductQuantityMapper;
import com.api.domain.models.product.ProductQuantity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
public class ProductQuantityImplement implements IProductQuantityRepository{
    
    private final IProductQuantityORM iProductQuantityORM;
    private final IProductQuantityMapper iProductQuantityMapper; 
    
    @Autowired
    public ProductQuantityImplement(IProductQuantityORM iProductQuantityORM, IProductQuantityMapper iProductQuantityMapper) {
        this.iProductQuantityORM = iProductQuantityORM;
        this.iProductQuantityMapper = iProductQuantityMapper;
    }
    
    @Override
    public Response createProductQuantity(ProductQuantityDTO productQuantityDTO){
        
        try {
            ProductQuantity pqEntity = iProductQuantityMapper.createMapper(productQuantityDTO);
            iProductQuantityORM.save(pqEntity);
            return new Response(
                "productQuantity encontrado",
                HttpStatus.OK.value(),
                true,
                null
            );    
        } catch (RuntimeException e) {
            return new Response(
                "productQuantity no encontrado, "+ e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                false,
                null);
        }
    }
    
    @Override
    public Response getByIdProductQuantity(Long id){
        
        try {
            
            var productQuantity = iProductQuantityORM.findById(id);
            System.out.println(id);
            if (productQuantity.isEmpty()) {
                throw new RuntimeException("ID inválido o no econtrado");
            }
            return new Response(
                "productQuantity encontrado",
                HttpStatus.OK.value(),
                true,
                productQuantity);    
        } catch (RuntimeException e) {
            return new Response(
                "productQuantity no encontrado, "+ e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                false,
                null);
        }
    }
    
    
    @Override
    public Response deleteProductQuantity(Long id){
        
        try {
            var productQuantity = iProductQuantityORM.findById(id);
            if (productQuantity.isEmpty()) {
                throw new RuntimeException("ID inválido o no econtrado");
            }
            iProductQuantityORM.deleteById(id);
            return new Response(
                "productQuantity encontrado y eliminado",
                HttpStatus.OK.value(),
                true,
                productQuantity);    
        } catch (RuntimeException e) {
            return new Response(
                "productQuantity no encontrado, "+ e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                false,
                null);
        }
    }
}
