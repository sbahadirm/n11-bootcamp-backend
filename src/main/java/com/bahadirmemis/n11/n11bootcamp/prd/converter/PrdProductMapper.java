package com.bahadirmemis.n11.n11bootcamp.prd.converter;

import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdProductDto;
import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdProductSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.prd.entity.PrdProduct;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PrdProductMapper {

    PrdProductMapper INSTANCE = Mappers.getMapper(PrdProductMapper.class);

    PrdProduct convertToPrdProduct(PrdProductSaveRequestDto prdProductSaveRequestDto);

    PrdProductDto convertToPrdProductDto(PrdProduct prdProduct);

    List<PrdProductDto> convertToPrdProductDtoList(List<PrdProduct> prdProductList);
}
