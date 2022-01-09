package com.bahadirmemis.n11.n11bootcamp.usr.dto;

import lombok.Data;

@Data
public class UsrFavoriteListSaveRequestDto {

    private Long id;
    private Long usrUserId;
    private String name;
}
