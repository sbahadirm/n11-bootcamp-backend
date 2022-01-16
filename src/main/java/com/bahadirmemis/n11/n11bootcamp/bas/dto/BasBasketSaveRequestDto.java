package com.bahadirmemis.n11.n11bootcamp.bas.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BasBasketSaveRequestDto {

    private Long id;

    private Long usrUserId;
    private BigDecimal totalPrice;
    private BigDecimal shippingCost;
    private BigDecimal additionalDiscount;
    private BigDecimal payableAmount;
}
