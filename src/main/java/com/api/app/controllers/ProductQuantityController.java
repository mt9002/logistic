package com.api.app.controllers;

import com.api.app.dto.ProductQuantityDTO;
import com.api.domain.interfaces.incoming.IProductQuantityService;
import com.api.app.dto.Response;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/productQuantity")
public class ProductQuantityController {
    
    private final IProductQuantityService iProductQuantityService;
    
    @Autowired
    public ProductQuantityController(IProductQuantityService iProductQuantityService){
        this.iProductQuantityService = iProductQuantityService;
    }
    
    @PostMapping("create")
    public Response createProductQuantity(@Valid @RequestBody ProductQuantityDTO productQuantityDTO){
        var response = iProductQuantityService.createProductQuantity(productQuantityDTO);
        return response;
    }
    
    @GetMapping("/getById")
    public Response getByIdProductQuantity(@RequestParam(value = "id") Long id){
        var response = iProductQuantityService.getByIdProductQuantity(id);
        return response;
    }
    
    @DeleteMapping("/delete")
    public Response deleteProductQuantity(@RequestParam(value = "id") Long id){
        var response = iProductQuantityService.deleteProductQuantity(id);
        return response;
    }
    
}
