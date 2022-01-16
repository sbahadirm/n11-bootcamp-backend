package com.bahadirmemis.n11.n11bootcamp.bas.converter;

import com.bahadirmemis.n11.n11bootcamp.bas.dto.BasBasketProductDetailDto;
import com.bahadirmemis.n11.n11bootcamp.bas.entity.BasBasketProduct;
import com.bahadirmemis.n11.n11bootcamp.prd.entity.PrdProduct;
import com.bahadirmemis.n11.n11bootcamp.prd.service.entityservice.PrdProductEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BasBasketProductConverter {

    private final PrdProductEntityService prdProductEntityService;

    public List<BasBasketProductDetailDto> convertToBasBasketProductDetailDtoList(List<BasBasketProduct> basBasketProductList) {

        List<BasBasketProductDetailDto> basBasketProductDetailDtoList = new ArrayList<>();
        for (BasBasketProduct basBasketProduct : basBasketProductList) {
            BasBasketProductDetailDto basBasketProductDetailDto = convertToBasBasketProductDetailDto(basBasketProduct);
            basBasketProductDetailDtoList.add(basBasketProductDetailDto);
        }

        return basBasketProductDetailDtoList;
    }

    public BasBasketProductDetailDto convertToBasBasketProductDetailDto(BasBasketProduct basBasketProduct){

        BasBasketProductDetailDto basBasketProductDetailDto = new BasBasketProductDetailDto();

        if (basBasketProduct != null){

            Long prdProductId = basBasketProduct.getPrdProductId();

            PrdProduct prdProduct = prdProductEntityService.findPrdProductById(prdProductId);

            basBasketProductDetailDto.setId(basBasketProduct.getId());
            basBasketProductDetailDto.setBasBasketId(basBasketProduct.getBasBasketId());
            basBasketProductDetailDto.setPrdProductId(prdProductId);
            basBasketProductDetailDto.setProductPrice(basBasketProduct.getProductPrice());
            basBasketProductDetailDto.setShippingCost(basBasketProduct.getShippingCost());

            basBasketProductDetailDto.setProductName(prdProduct.getName());
            basBasketProductDetailDto.setProductDiscount(basBasketProduct.getProductDiscount());
            basBasketProductDetailDto.setProductCategoryId(prdProduct.getCategoryId());
            basBasketProductDetailDto.setVendorUserId(prdProduct.getVendorUserId());
            basBasketProductDetailDto.setProductImageUrl(prdProduct.getImageUrl());
            basBasketProductDetailDto.setAdditionalDiscount(prdProduct.getAdditionalDiscount());

        }

        return basBasketProductDetailDto;
    }

}
