package com.bahadirmemis.n11.n11bootcamp.usr.dto;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import com.bahadirmemis.n11.n11bootcamp.usr.enums.EnumUsrUserType;
import lombok.Data;

@Data
public class UsrUserSaveRequestDto implements BaseEntity {

    private Long id;
    private String name;
    private String shortName;
    private String username;
    private String password;
    private String imageUrl;
    private EnumUsrUserType usrUserType;
}
