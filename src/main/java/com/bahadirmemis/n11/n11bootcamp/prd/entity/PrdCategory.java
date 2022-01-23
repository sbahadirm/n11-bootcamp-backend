package com.bahadirmemis.n11.n11bootcamp.prd.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PRD_CATEGORY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrdCategory implements BaseEntity {

    @Id
    @SequenceGenerator(name = "PrdCategory", sequenceName = "PRD_CATEGORY_ID_SEQ")
    @GeneratedValue(generator = "PrdCategory")
    private Long id;

    private String name;
    private String shortName;
    private Long level;
    private Long superCategoryId;
}
