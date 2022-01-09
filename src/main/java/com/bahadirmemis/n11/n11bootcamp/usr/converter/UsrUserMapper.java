package com.bahadirmemis.n11.n11bootcamp.usr.converter;

import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrUserDto;
import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrUserSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsrUserMapper {

    UsrUserMapper INSTANCE = Mappers.getMapper(UsrUserMapper.class);

    UsrUserDto convertToUsrUserDtoList(UsrUser usrUser);

    List<UsrUserDto> convertToUsrUserDtoList(List<UsrUser> usrUserList);

    UsrUser convertToUsrUserSaveRequestDto(UsrUserSaveRequestDto usrUserSaveRequestDto);
}
