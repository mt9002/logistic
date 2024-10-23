package com.api.domain.services.logistic.mapper;

import com.api.domain.interfaces.outgoing.mapper.ILogisticMapper;
import com.api.domain.models.Logistic;
import com.api.app.dto.LogisticDTO;
import com.api.app.dto.ProductQuantityDTO;
import com.api.domain.models.deposit.DeliveryDeposit;
import com.api.domain.models.product.Product;
import com.api.domain.models.product.ProductQuantity;
import com.api.domain.utils.enums.TypeLogistic;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class LogisticMapper implements ILogisticMapper {

    @Override
    public Logistic createMapper(LogisticDTO logisticDTO) {
        Logistic logistic = new Logistic();
        
        logistic.setTypeDelivery(TypeLogistic.valueOf(logisticDTO.getTypeDelivery()));
        logistic.setShippingPrice(logisticDTO.getShippingPrice());
        logistic.setDiscountedPrice(logisticDTO.getDiscountedPrice());
        logistic.setFechaEntregaDay(4);
        
        DeliveryDeposit deliveryDeposit = new DeliveryDeposit();
        
        deliveryDeposit.setId(logisticDTO.getDeliveryDepositId());
        logistic.setDeliveryDeposit(deliveryDeposit);
        
        if (logisticDTO.getProductQuantities()!= null && !logisticDTO.getProductQuantities().isEmpty()) {
            
            Set<ProductQuantity> productQuantities = new HashSet<>();
            for (ProductQuantityDTO pqDTO : logisticDTO.getProductQuantities()) {
                System.out.println(pqDTO.getQuantity());
                ProductQuantity productQuantity = new ProductQuantity();
                Product product = new Product();
                
                product.setId(pqDTO.getProductId());
                productQuantity.setProduct(product);
                productQuantity.setQuantity(pqDTO.getQuantity());
               
                productQuantity.setLogistic(logistic);
                
                productQuantities.add(productQuantity);
            }
            logistic.setProductQuantities(productQuantities);
        }
        return logistic;
    }

    @Override
    public Logistic updateMapper(LogisticDTO logisticDTO, Logistic updatedLogistic) {

        if (logisticDTO.getTypeDelivery() != null) {
            String typeLogistic = logisticDTO.getTypeDelivery();
            updatedLogistic.setTypeDelivery(TypeLogistic.valueOf(typeLogistic));
        }

        if (logisticDTO.getShippingPrice() != null) {
            updatedLogistic.setShippingPrice(logisticDTO.getShippingPrice());
        }
        if (logisticDTO.getDiscountedPrice() != null) {
            updatedLogistic.setDiscountedPrice(logisticDTO.getDiscountedPrice());
        }

        return updatedLogistic;
    }

    public String entityToDto() {

        return "";
    }
}

//        ProductQuantity productQuantity = new ProductQuantity(); 
//        Product product = new Product();
//        
//        product.setId(logisticDTO.getPoductId());
//        product.setTipoProducto(logisticDTO.getTipoProducto());
//        
//        productQuantity.setProduct(product);
//        productQuantity.setQuantity(logisticDTO.getQuantity());
