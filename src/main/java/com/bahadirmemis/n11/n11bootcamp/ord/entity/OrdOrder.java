package com.bahadirmemis.n11.n11bootcamp.ord.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import com.bahadirmemis.n11.n11bootcamp.ord.enums.EnumDeliveryStatus;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ORD_ORDER")
@Data
public class OrdOrder implements BaseEntity {

    @Id
    @SequenceGenerator(name = "OrdOrder", sequenceName = "ORD_ORDER_ID_SEQ")
    @GeneratedValue(generator = "OrdOrder")
    private Long id;

    private Long basBasketId;
    private Date orderDate;
    private BigDecimal paidAmount;
    private String deliveryCompany;
    private String parcelTrackingCode;
    private Long addressId;

    @Enumerated(EnumType.STRING)
    private EnumDeliveryStatus deliveryStatus;
    private Date deliveryDate;
    private Long orderNo;
}
