package com.api.domain.interfaces.outgoing.jpaORM;

import com.api.domain.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductORM extends JpaRepository<Product, Long>{
    
}
