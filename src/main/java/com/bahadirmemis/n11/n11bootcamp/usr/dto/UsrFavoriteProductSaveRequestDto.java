package com.bahadirmemis.n11.n11bootcamp.usr.dto;

import lombok.Data;

@Data
public class UsrFavoriteProductSaveRequestDto {

    private Long id;

    private Long usrFavoriteListId;
    private Long prdProductId;
}
