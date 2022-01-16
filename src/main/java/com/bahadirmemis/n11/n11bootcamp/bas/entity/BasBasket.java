package com.bahadirmemis.n11.n11bootcamp.bas.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "BAS_BASKET")
@Data
public class BasBasket implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long usrUserId;
    private BigDecimal totalPrice;
    private BigDecimal shippingCost;
    private BigDecimal additionalDiscount;
    private BigDecimal payableAmount;
}
