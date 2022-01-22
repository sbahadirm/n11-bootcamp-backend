package com.bahadirmemis.n11.n11bootcamp.gen.dao;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.GenCounter;
import com.bahadirmemis.n11.n11bootcamp.gen.enums.EnumGenCounterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenCounterDao extends JpaRepository<GenCounter, Long> {

    GenCounter findByCounterType(EnumGenCounterType counterType);
}
