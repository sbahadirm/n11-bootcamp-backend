package com.bahadirmemis.n11.n11bootcamp.ord.service.entityservice;

import com.bahadirmemis.n11.n11bootcamp.gen.service.BaseEntityService;
import com.bahadirmemis.n11.n11bootcamp.ord.dao.OrdOrderProductDao;
import com.bahadirmemis.n11.n11bootcamp.ord.dto.OrdOrderProductDetailDto;
import com.bahadirmemis.n11.n11bootcamp.ord.entity.OrdOrderProduct;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdOrderProductEntityService extends BaseEntityService<OrdOrderProduct, OrdOrderProductDao> {

    public OrdOrderProductEntityService(OrdOrderProductDao dao) {
        super(dao);
    }

    public List<OrdOrderProductDetailDto> findAllOrdOrderProductDetailDtoListByUsername(String username){
        return getDao().findAllOrdOrderProductDetailDtoListByUsername(username);
    }
}
