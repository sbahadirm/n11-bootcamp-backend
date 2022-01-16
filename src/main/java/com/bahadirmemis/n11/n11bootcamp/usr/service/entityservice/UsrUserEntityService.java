package com.bahadirmemis.n11.n11bootcamp.usr.service.entityservice;

import com.bahadirmemis.n11.n11bootcamp.gen.service.BaseEntityService;
import com.bahadirmemis.n11.n11bootcamp.usr.dao.UsrUserDao;
import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrUser;
import com.bahadirmemis.n11.n11bootcamp.usr.enums.EnumUsrUserType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsrUserEntityService extends BaseEntityService<UsrUser, UsrUserDao> {

    public UsrUserEntityService(UsrUserDao dao) {
        super(dao);
    }

    public UsrUser findByUsername(String username){
        return getDao().findByUsername(username);
    }

    public List<UsrUser> findAllByUsrUserTypeOrderById(EnumUsrUserType usrUserType){
        return getDao().findAllByUsrUserTypeOrderById(usrUserType);
    }
}
