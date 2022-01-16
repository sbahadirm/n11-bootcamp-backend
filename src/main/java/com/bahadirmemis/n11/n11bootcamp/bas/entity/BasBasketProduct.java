package com.bahadirmemis.n11.n11bootcamp.bas.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "BAS_BASKET_PRODUCT")
@Data
public class BasBasketProduct implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long basBasketId;
    private Long prdProductId;
    private BigDecimal productPrice;
    private BigDecimal shippingCost;
    private BigDecimal productDiscount;
}
