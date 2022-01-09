package com.bahadirmemis.n11.n11bootcamp.usr.service.entityservice;

import com.bahadirmemis.n11.n11bootcamp.gen.service.BaseEntityService;
import com.bahadirmemis.n11.n11bootcamp.usr.dao.UsrFavoriteListDao;
import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrFavoriteList;
import org.springframework.stereotype.Service;

@Service
public class UsrFavoriteListEntityService extends BaseEntityService<UsrFavoriteList, UsrFavoriteListDao> {

    public UsrFavoriteListEntityService(UsrFavoriteListDao dao) {
        super(dao);
    }
}
