package com.bahadirmemis.n11.n11bootcamp.usr.service.entityservice;

import com.bahadirmemis.n11.n11bootcamp.gen.service.BaseEntityService;
import com.bahadirmemis.n11.n11bootcamp.usr.dao.UsrPhoneDao;
import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrPhone;
import org.springframework.stereotype.Service;

@Service
public class UsrPhoneEntityService extends BaseEntityService<UsrPhone, UsrPhoneDao> {

    public UsrPhoneEntityService(UsrPhoneDao dao) {
        super(dao);
    }
}
