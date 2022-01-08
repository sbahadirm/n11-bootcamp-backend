package com.bahadirmemis.n11.n11bootcamp.prd.service.entityservice;

import com.bahadirmemis.n11.n11bootcamp.gen.service.BaseEntityService;
import com.bahadirmemis.n11.n11bootcamp.prd.dao.PrdCategoryDao;
import com.bahadirmemis.n11.n11bootcamp.prd.entity.PrdCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrdCategoryEntityService extends BaseEntityService<PrdCategory, PrdCategoryDao> {

    public PrdCategoryEntityService(PrdCategoryDao dao) {
        super(dao);
    }

    public List<PrdCategory> findBySuperCategoryId(Long superCategoryId){

        List<PrdCategory> prdCategoryList = getDao().findAllBySuperCategoryIdOrderById(superCategoryId);

        return prdCategoryList;
    }

}
