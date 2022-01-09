package com.bahadirmemis.n11.n11bootcamp.usr.converter;

import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrFavoriteListDto;
import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrFavoriteListSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrFavoriteList;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsrUserFavoriteListMapper {

    UsrUserFavoriteListMapper INSTANCE = Mappers.getMapper(UsrUserFavoriteListMapper.class);

    UsrFavoriteListDto convertToUsrFavoriteListDto(UsrFavoriteList usrFavoriteList);

    List<UsrFavoriteListDto> convertToUsrFavoriteListDtoList(List<UsrFavoriteList> usrFavoriteList);

    UsrFavoriteList convertToUsrFavoriteList(UsrFavoriteListSaveRequestDto usrFavoriteListSaveRequestDto);

    UsrFavoriteListSaveRequestDto convertToUsrFavoriteListSaveRequestDto(UsrFavoriteList usrFavoriteList);
}
