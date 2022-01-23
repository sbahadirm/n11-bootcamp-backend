package com.bahadirmemis.n11.n11bootcamp.usr.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import com.bahadirmemis.n11.n11bootcamp.gen.enums.EnumStatus;
import com.bahadirmemis.n11.n11bootcamp.gen.enums.EnumYesNo;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USR_MAIL")
@Data
public class UsrMail implements BaseEntity {

    @Id
    @SequenceGenerator(name = "UsrMail", sequenceName = "USR_MAIL_ID_SEQ")
    @GeneratedValue(generator = "UsrMail")
    private Long id;

    private Long userUserId;
    private String mailAddress;

    @Enumerated(EnumType.STRING)
    private EnumYesNo isDefault;

    @Enumerated(EnumType.STRING)
    private EnumStatus status;

}
