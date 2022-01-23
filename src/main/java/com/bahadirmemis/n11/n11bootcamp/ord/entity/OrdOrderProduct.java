package com.bahadirmemis.n11.n11bootcamp.ord.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ORD_ORDER_PRODUCT")
@Data
public class OrdOrderProduct implements BaseEntity {

    @Id
    @SequenceGenerator(name = "OrdOrderProduct", sequenceName = "ORD_ORDER_PRODUCT_ID_SEQ")
    @GeneratedValue(generator = "OrdOrderProduct")
    private Long id;

    private Long ordOrderId;
    private Long basBasketProductId;
}
