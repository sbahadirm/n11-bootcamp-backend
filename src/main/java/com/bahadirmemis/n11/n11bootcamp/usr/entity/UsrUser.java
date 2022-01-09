package com.bahadirmemis.n11.n11bootcamp.usr.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import com.bahadirmemis.n11.n11bootcamp.usr.enums.EnumUsrUserType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USR_USER")
@Data
public class UsrUser implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String shortName;
    private String username;
    private String password;
    private String imageUrl;
    private EnumUsrUserType usrUserType;
}
