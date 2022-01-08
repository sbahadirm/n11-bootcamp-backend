package com.bahadirmemis.n11.n11bootcamp.prd.converter;

import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdCategoryForMenuDto;
import com.bahadirmemis.n11.n11bootcamp.prd.entity.PrdCategory;
import com.bahadirmemis.n11.n11bootcamp.prd.service.entityservice.PrdCategoryEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PrdCategoryConverter {

    private PrdCategoryEntityService prdCategoryEntityService;

    public PrdCategoryForMenuDto convertToPrdCategoryForMenuDto(PrdCategory prdCategory){

        PrdCategoryMapper prdCategoryMapper = PrdCategoryMapper.INSTANCE;
        PrdCategoryForMenuDto prdCategoryForMenuDto = prdCategoryMapper.convertToPrdCategoryForMenuDto(prdCategory);

        List<PrdCategory> subPrdCategoryList = prdCategoryEntityService.findBySuperCategoryId(prdCategory.getId());
        List<PrdCategoryForMenuDto> subPrdCategoryForMenuDtoList = convertToPrdCategoryForMenuDtoList(subPrdCategoryList);

        prdCategoryForMenuDto.setSubPrdCategoryForMenuDtoList(subPrdCategoryForMenuDtoList);

        return prdCategoryForMenuDto;

    }

    public List<PrdCategoryForMenuDto> convertToPrdCategoryForMenuDtoList(List<PrdCategory> prdCategoryList){

        List<PrdCategoryForMenuDto> prdCategoryForMenuDtoList = new ArrayList<>();
        for (PrdCategory prdCategory : prdCategoryList) {
            PrdCategoryForMenuDto prdCategoryForMenuDto = convertToPrdCategoryForMenuDto(prdCategory);
            prdCategoryForMenuDtoList.add(prdCategoryForMenuDto);
        }

        return prdCategoryForMenuDtoList;
    }

}
