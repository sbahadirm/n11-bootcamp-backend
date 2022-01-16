package com.bahadirmemis.n11.n11bootcamp.ord.service;

import com.bahadirmemis.n11.n11bootcamp.bas.entity.BasBasket;
import com.bahadirmemis.n11.n11bootcamp.bas.service.entityservice.BasBasketEntityService;
import com.bahadirmemis.n11.n11bootcamp.ord.converter.OrdOrderMapper;
import com.bahadirmemis.n11.n11bootcamp.ord.dto.OrdOrderSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.ord.entity.OrdOrder;
import com.bahadirmemis.n11.n11bootcamp.ord.service.entityservice.OrdOrderEntityService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdOrderService {

    private final OrdOrderEntityService ordOrderEntityService;
    private final BasBasketEntityService basBasketEntityService;

    public OrdOrder saveOrdOrder(OrdOrderSaveRequestDto ordOrderSaveRequestDto){

        OrdOrder ordOrder = OrdOrderMapper.INSTANCE.convertToOrdOrder(ordOrderSaveRequestDto);

        String username = ordOrderSaveRequestDto.getUsername();
        BasBasket basBasket = basBasketEntityService.findBasBasketByUsername(username);

        ordOrder.setBasBasketId(basBasket.getId());

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
