package com.bahadirmemis.n11.n11bootcamp.ord.dao;

import com.bahadirmemis.n11.n11bootcamp.ord.entity.OrdOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdOrderDao extends JpaRepository<OrdOrder, Long> {

}
