package com.bahadirmemis.n11.n11bootcamp.bas.service.entityservice;

import com.bahadirmemis.n11.n11bootcamp.bas.dao.BasBasketProductDao;
import com.bahadirmemis.n11.n11bootcamp.bas.entity.BasBasketProduct;
import com.bahadirmemis.n11.n11bootcamp.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasBasketProductEntityService extends BaseEntityService<BasBasketProduct, BasBasketProductDao> {

    public BasBasketProductEntityService(BasBasketProductDao dao) {
        super(dao);
    }

    public List<BasBasketProduct> findAllByBasBasketIdOrderById(Long basBasketId){
        return getDao().findAllByBasBasketIdOrderById(basBasketId);
    }

    public List<BasBasketProduct> findAllByUsernameOrderById(String username){
        return getDao().findAllByUsernameOrderById(username);
    }

}
