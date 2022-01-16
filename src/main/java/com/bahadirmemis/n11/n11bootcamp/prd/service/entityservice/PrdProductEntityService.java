package com.bahadirmemis.n11.n11bootcamp.prd.service.entityservice;

import com.bahadirmemis.n11.n11bootcamp.gen.service.BaseEntityService;
import com.bahadirmemis.n11.n11bootcamp.prd.dao.PrdProductDao;
import com.bahadirmemis.n11.n11bootcamp.prd.entity.PrdProduct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrdProductEntityService extends BaseEntityService<PrdProduct, PrdProductDao> {

    public PrdProductEntityService(PrdProductDao dao) {
        super(dao);
    }

    public List<PrdProduct> findAllByCategoryIdOrderById(Long categoryId){
        return getDao().findAllByCategoryIdOrderById(categoryId);
    }

    public PrdProduct findPrdProductById(Long id) {
        PrdProduct prdProduct;

        Optional<PrdProduct> optionalPrdProduct = findById(id);
        if (optionalPrdProduct.isPresent()){
            prdProduct = optionalPrdProduct.get();

        } else {
            throw new RuntimeException("Product not found!");
        }
        return prdProduct;
    }
}
