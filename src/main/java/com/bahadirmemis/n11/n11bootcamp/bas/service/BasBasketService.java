package com.bahadirmemis.n11.n11bootcamp.bas.service;

import com.bahadirmemis.n11.n11bootcamp.bas.converter.BasBasketMapper;
import com.bahadirmemis.n11.n11bootcamp.bas.converter.BasBasketProductConverter;
import com.bahadirmemis.n11.n11bootcamp.bas.dto.BasBasketDto;
import com.bahadirmemis.n11.n11bootcamp.bas.dto.BasBasketProductDetailDto;
import com.bahadirmemis.n11.n11bootcamp.bas.dto.BasBasketSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.bas.entity.BasBasket;
import com.bahadirmemis.n11.n11bootcamp.bas.entity.BasBasketProduct;
import com.bahadirmemis.n11.n11bootcamp.bas.service.entityservice.BasBasketEntityService;
import com.bahadirmemis.n11.n11bootcamp.bas.service.entityservice.BasBasketProductEntityService;
import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdProductSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasBasketService {

    private final BasBasketEntityService basBasketEntityService;
    private final BasBasketProductEntityService basBasketProductEntityService;
    private final BasBasketProductConverter basBasketProductConverter;

    public BasBasketDto getBasBasketById(Long id) {

        BasBasket basBasket = basBasketEntityService.findBasBasketById(id);

        BasBasketDto basBasketDto = BasBasketMapper.INSTANCE.convertToBasBasketDto(basBasket);

        return basBasketDto;
    }

    public BasBasketDto getBasBasketByUsername(String username) {

        BasBasket basBasket = basBasketEntityService.findBasBasketByUsername(username);

        BasBasketDto basBasketDto = BasBasketMapper.INSTANCE.convertToBasBasketDto(basBasket);

        return basBasketDto;
    }

    public List<BasBasketProductDetailDto> getAllProductsByBasketId(Long basketId) {
        List<BasBasketProduct> basBasketProductList = basBasketProductEntityService.findAllByBasBasketIdOrderById(basketId);

        List<BasBasketProductDetailDto> list = basBasketProductConverter.convertToBasBasketProductDetailDtoList(basBasketProductList);

        return list;
    }

    public List<BasBasketProductDetailDto> getAllProductsByUsername(String username) {
        List<BasBasketProduct> basBasketProductList = basBasketProductEntityService.findAllByUsernameOrderById(username);

        List<BasBasketProductDetailDto> list = basBasketProductConverter.convertToBasBasketProductDetailDtoList(basBasketProductList);

        return list;
    }

    public BasBasketDto createBasket(BasBasketSaveRequestDto basBasketSaveRequestDto) {

        BasBasket basBasket = BasBasketMapper.INSTANCE.convertToBasBasket(basBasketSaveRequestDto);

        basBasket = basBasketEntityService.save(basBasket);

        BasBasketDto basBasketDto = BasBasketMapper.INSTANCE.convertToBasBasketDto(basBasket);

        return basBasketDto;
    }

    public void deleteBasket(Long id) {
        BasBasket basBasket = basBasketEntityService.findBasBasketById(id);

        basBasketEntityService.delete(basBasket);
    }

    public BasBasketProductDetailDto addProductToBasketByUsername(String username, PrdProductSaveRequestDto prdProductSaveRequestDto) {

        BasBasket basBasket = basBasketEntityService.findBasBasketByUsername(username);

        BasBasketProduct basBasketProduct = new BasBasketProduct();
        basBasketProduct.setBasBasketId(basBasket.getId());
        basBasketProduct.setPrdProductId(prdProductSaveRequestDto.getId());
        basBasketProduct.setProductPrice(prdProductSaveRequestDto.getPrice());
        basBasketProduct.setProductDiscount(prdProductSaveRequestDto.getAdditionalDiscount());
        basBasketProduct.setShippingCost(BigDecimal.ZERO);

        basBasketProduct = basBasketProductEntityService.save(basBasketProduct);

        BasBasketProductDetailDto basBasketProductDetailDto = BasBasketMapper.INSTANCE.convertToBasBasketProductDetailDto(basBasketProduct);

        return basBasketProductDetailDto;
    }

    public void removeProductFromBasket(Long id) {

        BasBasketProduct basBasketProduct = basBasketProductEntityService.findByBasBasketProductById(id);

        basBasketProductEntityService.delete(basBasketProduct);
    }


}
