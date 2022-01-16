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
import com.bahadirmemis.n11.n11bootcamp.sec.jwt.security.JwtUserDetails;
import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasBasketService {

    private final BasBasketEntityService basBasketEntityService;
    private final BasBasketProductEntityService basBasketProductEntityService;
    private final BasBasketProductConverter basBasketProductConverter;

    public BasBasketDto getBasBasketById(Long id) {

        BasBasket basBasket = findBasBasketById(id);

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

    public BasBasketProductDetailDto getAllProductsByUsername(String username) {
        return null;
    }

    public BasBasketDto createBasket(BasBasketSaveRequestDto basBasketSaveRequestDto) {
        return null;
    }

    public void deleteBasket(Long id) {

    }

    public BasBasketProductDetailDto addProductToBasketByUsername(String username, PrdProductSaveRequestDto prdProductSaveRequestDto) {
        return null;
    }

    public void removeProductFromBasket(Long id) {

    }

    private BasBasket findBasBasketById(Long id) {
        Optional<BasBasket> optionalBasBasket = basBasketEntityService.findById(id);

        BasBasket basBasket;
        if (optionalBasBasket.isPresent()){
            basBasket = optionalBasBasket.get();
        } else {
            throw new RuntimeException("Basket not found!");
        }
        return basBasket;
    }
}
