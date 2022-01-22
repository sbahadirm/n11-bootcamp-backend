package com.bahadirmemis.n11.n11bootcamp.prd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PrdProductSaveRequestDto {

    private Long id;
    private String name;
    private String shortName;
    private Long categoryId;
    private Long vendorUserId;
    private String imageUrl;
    private BigDecimal price;
    private BigDecimal additionalDiscount;
}
