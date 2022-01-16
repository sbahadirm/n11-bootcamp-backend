package com.bahadirmemis.n11.n11bootcamp.bas.service.entityservice;

import com.bahadirmemis.n11.n11bootcamp.bas.dao.BasBasketDao;
import com.bahadirmemis.n11.n11bootcamp.bas.entity.BasBasket;
import com.bahadirmemis.n11.n11bootcamp.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BasBasketEntityService extends BaseEntityService<BasBasket, BasBasketDao> {

    public BasBasketEntityService(BasBasketDao dao) {
        super(dao);
    }

    public BasBasket findBasBasketByUsername(String username){
        return getDao().findBasBasketByUsername(username);
    }

}
