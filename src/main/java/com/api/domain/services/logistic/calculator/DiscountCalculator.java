package com.api.domain.services.logistic.calculator;

import com.api.app.dto.LogisticDTO;
import com.api.app.dto.ProductQuantityDTO;
import com.api.domain.services.logistic.mapper.Bill;
import com.api.domain.services.utils.EnumDiscount;

public class DiscountCalculator {

    // >10 unidades, descuento del 5% al precio de envío en logística terrestre.
    public void landDiscount(LogisticDTO dto) {
        Bill calculatorPrice = calculatorPrice(dto);
        double landDiscount = EnumDiscount.LAND_DISCOUNT.getDiscountValue();
        System.err.println("Tienes un descuento del 5%");
        if (calculatorPrice.isShippingDiscount()) {
            double total = calculatorPrice.getTotal();
            double discountPrice = total * (1 - landDiscount);
            dto.setDiscountedPrice((float) discountPrice);
            return;
        }
        dto.setDiscountedPrice(0f);
    }

    // >10 unidades, descuento del 3% al precio de envío en logística maritima.
    public void seaDiscount(LogisticDTO dto) {
        Bill calculatorPrice = calculatorPrice(dto);
        double seaDiscount = EnumDiscount.SEA_DISCOUNT.getDiscountValue();
        System.out.println("Tienes un descuento del 3%");
        if (calculatorPrice.isShippingDiscount()) {
            double total = calculatorPrice.getTotal();
            double discountPrice = total*(1 - seaDiscount);
            dto.setDiscountedPrice((float) discountPrice);
        }
    }

    private Bill calculatorPrice(LogisticDTO dto) {
        int contador = 0;
        double totalShippingPrice = 0;
        for (ProductQuantityDTO productQuantityDTO : dto.getProductQuantities()) {
            int quantity = productQuantityDTO.getQuantity();
            double price = productQuantityDTO.getPrice();
            totalShippingPrice += (quantity * price);
            contador += quantity;
        }
        dto.setShippingPrice(totalShippingPrice);
        if (contador > 10) {
            return new Bill(
                    totalShippingPrice,
                    contador,
                    true
            );
        }
        return new Bill(
                totalShippingPrice,
                contador,
                false
        );
    }
}
