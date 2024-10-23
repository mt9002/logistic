package com.api.domain.interfaces.outgoing.jpaORM;

import com.api.domain.models.product.ProductQuantity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductQuantityORM extends JpaRepository<ProductQuantity, Long>{
    @Query(
            "SELECT pq FROM Logistic l " +
            "JOIN l.productQuantities pq " +
            "JOIN pq.product p " +
            "WHERE l.id = :logisticId")
    List<ProductQuantity> findProductQuantitiesId(@Param("logisticId") Long logisticId);
    
    @Query(value =
            "SELECT * FROM product_quantity pq WHERE pq.id = :pqId", nativeQuery = true)
    List<ProductQuantity> findProductQuantitiesId2(@Param("pqId") Long pqId);
} 

 