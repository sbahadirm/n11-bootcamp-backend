package com.bahadirmemis.n11.n11bootcamp.prd.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRD_PRODUCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrdProduct implements BaseEntity {

    @Id
    @SequenceGenerator(name = "PrdProduct", sequenceName = "PRD_PRODUCT_ID_SEQ")
    @GeneratedValue(generator = "PrdProduct")
    private Long id;

    private String name;
    private String shortName;
    private Long categoryId;
    private Long vendorUserId;
    private String imageUrl;
    private BigDecimal price;
    private BigDecimal additionalDiscount;
}
