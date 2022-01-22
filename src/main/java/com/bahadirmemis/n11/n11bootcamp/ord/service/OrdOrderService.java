package com.bahadirmemis.n11.n11bootcamp.ord.service;

import com.bahadirmemis.n11.n11bootcamp.bas.entity.BasBasket;
import com.bahadirmemis.n11.n11bootcamp.bas.service.entityservice.BasBasketEntityService;
import com.bahadirmemis.n11.n11bootcamp.gen.entity.GenCounter;
import com.bahadirmemis.n11.n11bootcamp.gen.enums.EnumGenCounterType;
import com.bahadirmemis.n11.n11bootcamp.gen.enums.EnumStatus;
import com.bahadirmemis.n11.n11bootcamp.gen.service.entityservice.GenCounterEntityService;
import com.bahadirmemis.n11.n11bootcamp.ord.converter.OrdOrderMapper;
import com.bahadirmemis.n11.n11bootcamp.ord.dto.OrdOrderDetailDto;
import com.bahadirmemis.n11.n11bootcamp.ord.dto.OrdOrderProductDetailDto;
import com.bahadirmemis.n11.n11bootcamp.ord.dto.OrdOrderSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.ord.entity.OrdOrder;
import com.bahadirmemis.n11.n11bootcamp.ord.entity.OrdOrderProduct;
import com.bahadirmemis.n11.n11bootcamp.ord.service.entityservice.OrdOrderEntityService;
import com.bahadirmemis.n11.n11bootcamp.ord.service.entityservice.OrdOrderProductEntityService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdOrderService {

    private final OrdOrderEntityService ordOrderEntityService;
    private final BasBasketEntityService basBasketEntityService;
    private final OrdOrderProductEntityService ordOrderProductEntityService;
    private final GenCounterEntityService genCounterEntityService;

    public OrdOrder saveOrdOrder(OrdOrderSaveRequestDto ordOrderSaveRequestDto){

        String username = ordOrderSaveRequestDto.getUsername();
        BasBasket basBasket = basBasketEntityService.findBasBasketByUsername(username);
        Long basBasketId = basBasket.getId();

        OrdOrder ordOrder = saveOrder(ordOrderSaveRequestDto, basBasketId);

        saveOrderProducts(ordOrderSaveRequestDto, ordOrder.getId());

        basBasket = saveBasketAsPassive(basBasket);

        saveNewActiveBasket(basBasket);

        return ordOrder;
    }

    private BasBasket saveNewActiveBasket(BasBasket basBasket) {

        BasBasket basBasketNew;

        try {
            basBasketNew = basBasket.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("An error occured while creating a new Basket");
        }

        basBasketNew.setId(null);
        basBasketNew.setBasketStatus(EnumStatus.ACTIVE);
        return basBasketEntityService.save(basBasketNew);
    }

    private BasBasket saveBasketAsPassive(BasBasket basBasket) {
        basBasket.setBasketStatus(EnumStatus.PASSIVE);
        return basBasketEntityService.save(basBasket);
    }

    private OrdOrder saveOrder(OrdOrderSaveRequestDto ordOrderSaveRequestDto, Long basBasketId) {

        OrdOrder ordOrder = OrdOrderMapper.INSTANCE.convertToOrdOrder(ordOrderSaveRequestDto);

        Long nextOrderNo = findNextOrderNo();

        ordOrder.setBasBasketId(basBasketId);
        ordOrder.setOrderDate(new Date());
        ordOrder.setOrderNo(nextOrderNo);
        ordOrder = ordOrderEntityService.save(ordOrder);

        return ordOrder;
    }

    private List<OrdOrderProduct> saveOrderProducts(OrdOrderSaveRequestDto ordOrderSaveRequestDto, Long ordOrderId) {

        List<OrdOrderProduct> ordOrderProductList = new ArrayList<>();
        List<Long> basBasketProductIdList = ordOrderSaveRequestDto.getBasBasketProductIdList();

        for (Long basBasketProdcutId : basBasketProductIdList) {

            OrdOrderProduct ordOrderProduct = saveOrdOrderProduct(ordOrderId, basBasketProdcutId);

            ordOrderProductList.add(ordOrderProduct);
        }

        return ordOrderProductList;
    }

    private OrdOrderProduct saveOrdOrderProduct(Long ordOrderId, Long basBasketProdcutId) {

        OrdOrderProduct ordOrderProduct = new OrdOrderProduct();
        ordOrderProduct.setOrdOrderId(ordOrderId);
        ordOrderProduct.setBasBasketProductId(basBasketProdcutId);

        ordOrderProduct = ordOrderProductEntityService.save(ordOrderProduct);

        return ordOrderProduct;
    }

    private synchronized Long findNextOrderNo() {

        GenCounter genCounter = genCounterEntityService.findOrCreateGenCounter(EnumGenCounterType.ORDER_NUM);

        Long lastNum = genCounter.getLastNum();

        Long newLastNum = lastNum + 1L;

        genCounter.setLastNum(newLastNum);

        genCounter = genCounterEntityService.save(genCounter);

        return newLastNum;
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


    public List<OrdOrderDetailDto> getOrdOrderByUsername(String username) {

        List<OrdOrderProductDetailDto> ordOrderProductDetailDtoList = ordOrderProductEntityService
                .findAllOrdOrderProductDetailDtoListByUsername(username);

        Map<Long, List<OrdOrderProductDetailDto>> orderIdAndProductMap = ordOrderProductDetailDtoList
                .stream().collect(Collectors.groupingBy(OrdOrderProductDetailDto::getOrdOrderId));

        List<OrdOrderDetailDto> ordOrderDetailDtoList = new ArrayList<>();

        for (Long orderId : orderIdAndProductMap.keySet()) {

            List<OrdOrderProductDetailDto> productDetailDtoList = orderIdAndProductMap.get(orderId);

            OrdOrderProductDetailDto ordOrderProductDetailDto = productDetailDtoList.get(0);

            OrdOrderDetailDto ordOrderDetailDto = new OrdOrderDetailDto();
            ordOrderDetailDto.setId(ordOrderProductDetailDto.getId());
            ordOrderDetailDto.setDeliveryDate(ordOrderProductDetailDto.getDeliveryDate());
            ordOrderDetailDto.setAddressId(ordOrderProductDetailDto.getAddressId());
            ordOrderDetailDto.setDeliveryCompany(ordOrderProductDetailDto.getDeliveryCompany());
            ordOrderDetailDto.setDeliveryStatus(ordOrderProductDetailDto.getDeliveryStatus());
            ordOrderDetailDto.setPaidAmount(ordOrderProductDetailDto.getPaidAmount());
            ordOrderDetailDto.setParcelTrackingCode(ordOrderProductDetailDto.getParcelTrackingCode());
            ordOrderDetailDto.setOrderNo(ordOrderProductDetailDto.getOrderNo());
            ordOrderDetailDto.setOrderDate(ordOrderProductDetailDto.getOrderDate());
            ordOrderDetailDto.setPrdProductDtoList(productDetailDtoList);

            ordOrderDetailDtoList.add(ordOrderDetailDto);
        }

        ordOrderDetailDtoList = ordOrderDetailDtoList.stream().sorted(Comparator.comparing(OrdOrderDetailDto::getId).reversed()).collect(Collectors.toList());

        return ordOrderDetailDtoList;
    }
}
