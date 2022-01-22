package com.bahadirmemis.n11.n11bootcamp.gen.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.enums.EnumGenCounterType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "GEN_COUNTER")
public class GenCounter implements BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    private Long lastNum;

    @Enumerated(EnumType.STRING)
    private EnumGenCounterType counterType;

}
