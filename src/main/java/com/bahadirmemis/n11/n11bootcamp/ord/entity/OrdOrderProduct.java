package com.bahadirmemis.n11.n11bootcamp.ord.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORD_ORDER_PRODUCT")
@Data
public class OrdOrderProduct implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long ordOrderId;
    private Long basBasketProductId;
}
