package com.bahadirmemis.n11.n11bootcamp.gen.service.entityservice;

import com.bahadirmemis.n11.n11bootcamp.gen.dao.GenCounterDao;
import com.bahadirmemis.n11.n11bootcamp.gen.entity.GenCounter;
import com.bahadirmemis.n11.n11bootcamp.gen.enums.EnumGenCounterType;
import com.bahadirmemis.n11.n11bootcamp.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class GenCounterEntityService extends BaseEntityService<GenCounter, GenCounterDao> {

    public GenCounterEntityService(GenCounterDao dao) {
        super(dao);
    }

    public GenCounter findOrCreateGenCounter(EnumGenCounterType counterType){

        GenCounter genCounter = getDao().findByCounterType(counterType);

        if (genCounter == null){
            genCounter = new GenCounter();
            genCounter.setLastNum(0L);
            genCounter.setCounterType(counterType);
        }

        return genCounter;
    }
}
