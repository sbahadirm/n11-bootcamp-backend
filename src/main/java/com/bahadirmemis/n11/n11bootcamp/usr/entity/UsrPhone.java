package com.bahadirmemis.n11.n11bootcamp.usr.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import com.bahadirmemis.n11.n11bootcamp.gen.enums.EnumStatus;
import com.bahadirmemis.n11.n11bootcamp.gen.enums.EnumYesNo;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USR_PHONE")
@Data
public class UsrPhone implements BaseEntity {

    @Id
    @SequenceGenerator(name = "UsrPhone", sequenceName = "USR_PHONE_ID_SEQ")
    @GeneratedValue(generator = "UsrPhone")
    private Long id;

    private Long userUserId;
    private String number;

    @Enumerated(EnumType.STRING)
    private EnumYesNo isDefault;

    @Enumerated(EnumType.STRING)
    private EnumStatus status;

}
