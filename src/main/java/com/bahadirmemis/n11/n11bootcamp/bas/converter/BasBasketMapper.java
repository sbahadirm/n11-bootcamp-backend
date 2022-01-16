package com.bahadirmemis.n11.n11bootcamp.bas.converter;

import com.bahadirmemis.n11.n11bootcamp.bas.dto.BasBasketDto;
import com.bahadirmemis.n11.n11bootcamp.bas.dto.BasBasketProductDetailDto;
import com.bahadirmemis.n11.n11bootcamp.bas.dto.BasBasketSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.bas.entity.BasBasket;
import com.bahadirmemis.n11.n11bootcamp.bas.entity.BasBasketProduct;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BasBasketMapper {

    BasBasketMapper INSTANCE = Mappers.getMapper(BasBasketMapper.class);

    BasBasketDto convertToBasBasketDto(BasBasket basBasket);

    BasBasket convertToBasBasket(BasBasketSaveRequestDto basBasketSaveRequestDto);

    BasBasketProductDetailDto convertToBasBasketProductDetailDto(BasBasketProduct basBasketProduct);
}
