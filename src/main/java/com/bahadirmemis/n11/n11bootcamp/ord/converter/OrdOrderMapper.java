package com.bahadirmemis.n11.n11bootcamp.ord.converter;

import com.bahadirmemis.n11.n11bootcamp.ord.dto.OrdOrderSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.ord.entity.OrdOrder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrdOrderMapper {

    OrdOrderMapper INSTANCE = Mappers.getMapper(OrdOrderMapper.class);

    OrdOrderSaveRequestDto convertToOrdOrderSaveRequestDto(OrdOrder ordOrder);

    OrdOrder convertToOrdOrder(OrdOrderSaveRequestDto ordOrderSaveRequestDto);

    List<OrdOrderSaveRequestDto> convertToOrdOrderSaveRequestDtoList(List<OrdOrder> ordOrderList);

    List<OrdOrder> convertToOrdOrderList(List<OrdOrderSaveRequestDto> ordOrderSaveRequestDtoList);

}
