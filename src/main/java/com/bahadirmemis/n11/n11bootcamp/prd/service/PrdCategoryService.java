package com.bahadirmemis.n11.n11bootcamp.prd.service;

import com.bahadirmemis.n11.n11bootcamp.prd.converter.PrdCategoryConverter;
import com.bahadirmemis.n11.n11bootcamp.prd.converter.PrdCategoryMapper;
import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdCategoryForMenuDto;
import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdCategorySaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.prd.entity.PrdCategory;
import com.bahadirmemis.n11.n11bootcamp.prd.service.entityservice.PrdCategoryEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PrdCategoryService {

    private PrdCategoryEntityService prdCategoryEntityService;
    private PrdCategoryConverter prdCategoryConverter;

    public PrdCategory saveCategory(PrdCategorySaveRequestDto prdCategorySaveRequestDto){

        PrdCategory prdCategory = PrdCategoryMapper.INSTANCE.convertToPrdCategory(prdCategorySaveRequestDto);

        return prdCategoryEntityService.save(prdCategory);
    }

    public List<PrdCategorySaveRequestDto> findBySuperCategoryId(Long superCategoryId){
        List<PrdCategory> prdCategoryList = prdCategoryEntityService.findBySuperCategoryId(superCategoryId);

        List<PrdCategorySaveRequestDto> prdCategorySaveRequestDtoList = PrdCategoryMapper.INSTANCE
                .convertToPrdCategorySaveRequestDtoList(prdCategoryList);

        return prdCategorySaveRequestDtoList;
    }

    public PrdCategorySaveRequestDto getPrdCategoryById(Long id) {

        Optional<PrdCategory> optionalPrdCategory = prdCategoryEntityService.findById(id);

        if (optionalPrdCategory.isPresent()){
            PrdCategory prdCategory = optionalPrdCategory.get();

            PrdCategorySaveRequestDto prdCategorySaveRequestDto = PrdCategoryMapper.INSTANCE
                    .convertToPrdCategorySaveRequestDto(prdCategory);

            return prdCategorySaveRequestDto;
        } else {
            throw new RuntimeException("Category not found!");
        }
    }

    public List<PrdCategorySaveRequestDto> findAll() {
        List<PrdCategory> prdCategoryList = prdCategoryEntityService.findAll();

        List<PrdCategorySaveRequestDto> prdCategorySaveRequestDtoList = PrdCategoryMapper.INSTANCE
                .convertToPrdCategorySaveRequestDtoList(prdCategoryList);

        return prdCategorySaveRequestDtoList;
    }

    public List<PrdCategoryForMenuDto> findAllForMenu() {

        List<PrdCategory> prdCategoryList = prdCategoryEntityService.findBySuperCategoryId(null);

        List<PrdCategoryForMenuDto> prdCategoryForMenuDtoList = prdCategoryConverter.convertToPrdCategoryForMenuDtoList(prdCategoryList);

        return prdCategoryForMenuDtoList;
    }
}