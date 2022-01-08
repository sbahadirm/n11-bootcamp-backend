package com.bahadirmemis.n11.n11bootcamp.prd.service.entityservice;

import com.bahadirmemis.n11.n11bootcamp.gen.service.BaseEntityService;
import com.bahadirmemis.n11.n11bootcamp.prd.dao.PrdProductDao;
import com.bahadirmemis.n11.n11bootcamp.prd.entity.PrdProduct;
import org.springframework.stereotype.Service;

@Service
public class PrdProductEntityService extends BaseEntityService<PrdProduct, PrdProductDao> {

    public PrdProductEntityService(PrdProductDao dao) {
        super(dao);
    }

}
