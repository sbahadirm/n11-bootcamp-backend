package com.bahadirmemis.n11.n11bootcamp.bas.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "BAS_BASKET_PRODUCT")
@Data
public class BasBasketProduct implements BaseEntity {

    @Id
    @SequenceGenerator(name = "BasBasketProduct", sequenceName = "BAS_BASKET_PRODUCT_ID_SEQ")
    @GeneratedValue(generator = "BasBasketProduct")
    private Long id;

    private Long basBasketId;
    private Long prdProductId;
    private BigDecimal productPrice;
    private BigDecimal shippingCost;
    private BigDecimal productDiscount;
}
