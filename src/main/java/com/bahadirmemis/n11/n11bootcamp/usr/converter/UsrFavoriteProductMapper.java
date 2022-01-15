package com.bahadirmemis.n11.n11bootcamp.usr.converter;

import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrFavoriteProductDto;
import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrFavoriteProductSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrFavoriteProduct;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsrFavoriteProductMapper {

    UsrFavoriteProductMapper INSTANCE = Mappers.getMapper(UsrFavoriteProductMapper.class);

    UsrFavoriteProduct convertToUsrFavoriteProduct(UsrFavoriteProductSaveRequestDto usrFavoriteProductSaveRequestDto);

    UsrFavoriteProductDto convertToUsrFavoriteProductDto(UsrFavoriteProduct usrFavoriteProduct);
}
