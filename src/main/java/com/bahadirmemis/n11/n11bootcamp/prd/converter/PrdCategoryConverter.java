package com.bahadirmemis.n11.n11bootcamp.prd.converter;

import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdCategoryForMenuDto;
import com.bahadirmemis.n11.n11bootcamp.prd.entity.PrdCategory;
import com.bahadirmemis.n11.n11bootcamp.prd.service.entityservice.PrdCategoryEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PrdCategoryConverter {

    private PrdCategoryEntityService prdCategoryEntityService;

    public List<PrdCategoryForMenuDto> convertToPrdCategoryForMenuDto(Map<Long, List<PrdCategory>> superCategoryIdAndListMap, List<PrdCategory> mailMenuList) {

        List<PrdCategoryForMenuDto> prdCategoryForMenuDtoList = new ArrayList<>();

        if (mailMenuList != null){
            for (PrdCategory prdCategory : mailMenuList) {

                PrdCategoryForMenuDto prdCategoryForMenuDto = PrdCategoryMapper.INSTANCE.convertToPrdCategoryForMenuDto(prdCategory);

                List<PrdCategory> subCategoryList = getSubCategories(superCategoryIdAndListMap, prdCategory);
                List<PrdCategoryForMenuDto> subPrdCategoryForMenuDtoList = convertToPrdCategoryForMenuDto(superCategoryIdAndListMap, subCategoryList);

                prdCategoryForMenuDto.setSubPrdCategoryForMenuDtoList(subPrdCategoryForMenuDtoList);
                prdCategoryForMenuDtoList.add(prdCategoryForMenuDto);
            }
        }

        return prdCategoryForMenuDtoList;

    }

    private List<PrdCategory> getSubCategories(Map<Long, List<PrdCategory>> superCategoryIdAndListMap, PrdCategory prdCategory) {

        List<PrdCategory> prdCategoryList = superCategoryIdAndListMap.get(prdCategory.getId());

        if (prdCategoryList != null && !prdCategoryList.isEmpty()){
            for (PrdCategory eachPrdCategory : prdCategoryList) {
                getSubCategories(superCategoryIdAndListMap, eachPrdCategory);
            }
        }

        return prdCategoryList;
    }
}
