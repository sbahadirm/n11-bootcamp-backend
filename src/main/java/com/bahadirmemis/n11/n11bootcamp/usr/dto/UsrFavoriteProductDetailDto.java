package com.bahadirmemis.n11.n11bootcamp.usr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class UsrFavoriteProductDetailDto {

    private Long id;
    private Long favoriteListId;
    private String favoriteListName;
    private Long productId;
    private String productName;
    private String productImageUrl;
    private BigDecimal productPrice;
}
