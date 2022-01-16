package com.bahadirmemis.n11.n11bootcamp.ord.service.entityservice;

import com.bahadirmemis.n11.n11bootcamp.gen.service.BaseEntityService;
import com.bahadirmemis.n11.n11bootcamp.ord.dao.OrdOrderDao;
import com.bahadirmemis.n11.n11bootcamp.ord.entity.OrdOrder;
import org.springframework.stereotype.Service;

@Service
public class OrdOrderEntityService extends BaseEntityService<OrdOrder, OrdOrderDao> {

    public OrdOrderEntityService(OrdOrderDao dao) {
        super(dao);
    }


}
