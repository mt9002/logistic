package com.api.domain.models.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    private String typeProduct;
    private String weight;
    private String description;
    private Float price;

    public Product(String typeProduct, String weight, String description, Float price) {
        this.typeProduct = typeProduct;
        this.weight = weight;
        this.description = description;
        this.price = price;
    }

    public Product() {
    }
    
//    @Temporal(TemporalType.DATE)
//    private Date date;
//    
//    @Temporal(TemporalType.DATE)
//    private Date updateDate;    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    } 
}
