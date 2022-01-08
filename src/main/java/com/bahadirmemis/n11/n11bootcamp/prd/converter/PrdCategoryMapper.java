package com.bahadirmemis.n11.n11bootcamp.prd.converter;

import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdCategoryForMenuDto;
import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdCategorySaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.prd.entity.PrdCategory;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PrdCategoryMapper {

    PrdCategoryMapper INSTANCE = Mappers.getMapper(PrdCategoryMapper.class);

    PrdCategorySaveRequestDto convertToPrdCategorySaveRequestDto(PrdCategory prdCategory);

    PrdCategory convertToPrdCategory(PrdCategorySaveRequestDto prdCategorySaveRequestDto);

    List<PrdCategorySaveRequestDto> convertToPrdCategorySaveRequestDtoList(List<PrdCategory> prdCategoryList);

    List<PrdCategory> convertToPrdCategoryList(List<PrdCategorySaveRequestDto> prdCategorySaveRequestDtoList);

    PrdCategoryForMenuDto convertToPrdCategoryForMenuDto(PrdCategory prdCategory);

    PrdCategory convertToPrdCategory(PrdCategoryForMenuDto prdCategoryForMenuDto);

    List<PrdCategory> convertToPrdCategoryListByPrdCategoryForMenuDto(List<PrdCategoryForMenuDto> prdCategoryForMenuDtoList);

    List<PrdCategoryForMenuDto> convertToPrdCategoryForMenuDtoListByPrdCategoryList(List<PrdCategory> prdCategoryForMenuDtoList);

}
