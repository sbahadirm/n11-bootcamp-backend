package com.bahadirmemis.n11.n11bootcamp.usr.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import com.bahadirmemis.n11.n11bootcamp.gen.enums.EnumStatus;
import com.bahadirmemis.n11.n11bootcamp.gen.enums.EnumYesNo;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USR_PHONE")
@Data
public class UsrPhone implements BaseEntity {

    @Id
    private Long id;

    private Long userUserId;
    private String number;
    private EnumYesNo isDefault;
    private EnumStatus status;

}
