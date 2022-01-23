package com.bahadirmemis.n11.n11bootcamp.usr.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import com.bahadirmemis.n11.n11bootcamp.usr.enums.EnumUsrUserType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USR_USER")
@Data
public class UsrUser implements BaseEntity {

    @Id
    @SequenceGenerator(name = "UsrUser", sequenceName = "USR_USER_ID_SEQ")
    @GeneratedValue(generator = "UsrUser")
    private Long id;
    private String name;
    private String shortName;
    private String username;
    private String password;
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private EnumUsrUserType usrUserType;
}
