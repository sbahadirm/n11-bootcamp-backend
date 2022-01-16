package com.bahadirmemis.n11.n11bootcamp.usr.service.entityservice;

import com.bahadirmemis.n11.n11bootcamp.gen.service.BaseEntityService;
import com.bahadirmemis.n11.n11bootcamp.usr.dao.UsrMailDao;
import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrMail;
import org.springframework.stereotype.Service;

@Service
public class UsrMailEntityService extends BaseEntityService<UsrMail, UsrMailDao> {

    public UsrMailEntityService(UsrMailDao dao) {
        super(dao);
    }
}
