package com.bahadirmemis.n11.n11bootcamp.bas.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import com.bahadirmemis.n11.n11bootcamp.gen.enums.EnumStatus;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "BAS_BASKET")
@Data
public class BasBasket implements BaseEntity, Cloneable {

    @Id
    @GeneratedValue
    private Long id;

    private Long usrUserId;
    private BigDecimal totalPrice;
    private BigDecimal shippingCost;
    private BigDecimal additionalDiscount;
    private BigDecimal payableAmount;

    @Enumerated(EnumType.STRING)
    private EnumStatus basketStatus;

    @Override
    public BasBasket clone() throws CloneNotSupportedException {
        return (BasBasket) super.clone();
    }
}
