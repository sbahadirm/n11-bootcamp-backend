package com.bahadirmemis.n11.n11bootcamp.bas.dao;

import com.bahadirmemis.n11.n11bootcamp.bas.entity.BasBasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasBasketProductDao extends JpaRepository<BasBasketProduct, Long> {

    List<BasBasketProduct> findAllByBasBasketIdOrderById(Long basBasketId);

}
