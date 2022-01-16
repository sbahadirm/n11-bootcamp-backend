package com.bahadirmemis.n11.n11bootcamp.ord.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import com.bahadirmemis.n11.n11bootcamp.ord.enums.EnumDeliveryStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ORD_ORDER")
@Data
public class OrdOrder implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long basBasketId;
    private BigDecimal paidAmount;
    private String deliveryCompany;
    private String parcelTrackingCode;
    private Long addressId;
    private EnumDeliveryStatus deliveryStatus;
    private Date deliveryDate;

}
