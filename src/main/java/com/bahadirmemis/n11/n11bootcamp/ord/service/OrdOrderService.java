package com.bahadirmemis.n11.n11bootcamp.ord.service;

import com.bahadirmemis.n11.n11bootcamp.ord.converter.OrdOrderMapper;
import com.bahadirmemis.n11.n11bootcamp.ord.dto.OrdOrderSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.ord.entity.OrdOrder;
import com.bahadirmemis.n11.n11bootcamp.ord.service.entityservice.OrdOrderEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrdOrderService {

    private OrdOrderEntityService ordOrderEntityService;

    public OrdOrder saveOrdOrder(OrdOrderSaveRequestDto ordOrderSaveRequestDto){

        OrdOrder ordOrder = OrdOrderMapper.INSTANCE.convertToOrdOrder(ordOrderSaveRequestDto);

        return ordOrderEntityService.save(ordOrder);
    }

    public OrdOrderSaveRequestDto getOrdOrderById(Long id) {

        OrdOrder ordOrder;

        ordOrder = ordOrderEntityService.getById(id);

        OrdOrderSaveRequestDto ordOrderSaveRequestDto = OrdOrderMapper.INSTANCE
                .convertToOrdOrderSaveRequestDto(ordOrder);

        return ordOrderSaveRequestDto;
    }

    public List<OrdOrderSaveRequestDto> findAll() {
        List<OrdOrder> ordOrderList = ordOrderEntityService.findAll();

        List<OrdOrderSaveRequestDto> ordOrderSaveRequestDtoList = OrdOrderMapper.INSTANCE
                .convertToOrdOrderSaveRequestDtoList(ordOrderList);

        return ordOrderSaveRequestDtoList;
    }

    public void delete(Long id) {

        OrdOrder ordOrder = ordOrderEntityService.getById(id);

        ordOrderEntityService.delete(ordOrder);
    }


}
