package com.bahadirmemis.n11.n11bootcamp.prd.dao;

import com.bahadirmemis.n11.n11bootcamp.prd.entity.PrdProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrdProductDao extends JpaRepository<PrdProduct, Long> {

    List<PrdProduct> findAllByCategoryIdOrderById(Long categoryId);

}
