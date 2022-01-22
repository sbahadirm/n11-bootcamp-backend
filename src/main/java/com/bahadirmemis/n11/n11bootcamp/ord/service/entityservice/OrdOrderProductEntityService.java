package com.bahadirmemis.n11.n11bootcamp.ord.service.entityservice;

import com.bahadirmemis.n11.n11bootcamp.gen.service.BaseEntityService;
import com.bahadirmemis.n11.n11bootcamp.ord.dao.OrdOrderProductDao;
import com.bahadirmemis.n11.n11bootcamp.ord.entity.OrdOrderProduct;
import org.springframework.stereotype.Service;

@Service
public class OrdOrderProductEntityService extends BaseEntityService<OrdOrderProduct, OrdOrderProductDao> {

    public OrdOrderProductEntityService(OrdOrderProductDao dao) {
        super(dao);
    }


}
