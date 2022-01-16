package com.bahadirmemis.n11.n11bootcamp.bas.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BasBasketProductDetailDto {

    private Long id;

    private Long basBasketId;
    private Long prdProductId;
    private BigDecimal productPrice;
    private BigDecimal shippingCost;
    private BigDecimal productDiscount;

    private String productName;
    private Long productCategoryId;
    private Long vendorUserId;
    private String productImageUrl;
    private BigDecimal additionalDiscount;
}
