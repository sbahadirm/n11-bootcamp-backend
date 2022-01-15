package com.bahadirmemis.n11.n11bootcamp.usr.service.entityservice;

import com.bahadirmemis.n11.n11bootcamp.gen.service.BaseEntityService;
import com.bahadirmemis.n11.n11bootcamp.usr.dao.UsrFavoriteProductDao;
import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrFavoriteProductDetailDto;
import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrFavoriteProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsrFavoriteProductEntityService extends BaseEntityService<UsrFavoriteProduct, UsrFavoriteProductDao> {

    public UsrFavoriteProductEntityService(UsrFavoriteProductDao dao) {
        super(dao);
    }

    public List<UsrFavoriteProductDetailDto> findAllUsrFavoriteProductDetailDtoByFavListId(Long favListId){
        return getDao().findAllUsrFavoriteProductDetailDtoByFavListId(favListId);
    }
}
