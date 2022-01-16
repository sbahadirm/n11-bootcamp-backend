package com.bahadirmemis.n11.n11bootcamp.prd.service;

import com.bahadirmemis.n11.n11bootcamp.prd.converter.PrdProductMapper;
import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdProductDto;
import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdProductSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.prd.entity.PrdProduct;
import com.bahadirmemis.n11.n11bootcamp.prd.service.entityservice.PrdProductEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PrdProductService {

    private PrdProductEntityService prdProductEntityService;


    public PrdProductDto save(PrdProductSaveRequestDto prdProductSaveRequestDto) {

        PrdProductMapper mapper = PrdProductMapper.INSTANCE;
        PrdProduct prdProduct = mapper.convertToPrdProduct(prdProductSaveRequestDto);

        prdProduct = prdProductEntityService.save(prdProduct);

        PrdProductDto prdProductDto = mapper.convertToPrdProductDto(prdProduct);

        return prdProductDto;
    }

    public List<PrdProductDto> findAll() {
        List<PrdProduct> prdProductList = prdProductEntityService.findAll();

        List<PrdProductDto> prdProductDtoList = PrdProductMapper.INSTANCE.convertToPrdProductDtoList(prdProductList);

        return prdProductDtoList;
    }

    public PrdProductDto findById(Long id) {

        PrdProduct prdProduct = prdProductEntityService.getById(id);

        PrdProductDto prdProductDto = PrdProductMapper.INSTANCE.convertToPrdProductDto(prdProduct);

        return prdProductDto;
    }

    public List<PrdProductDto> findAllByCategoryId(Long categoryId) {

        List<PrdProduct> prdProductList = prdProductEntityService.findAllByCategoryIdOrderById(categoryId);

        List<PrdProductDto> prdProductDtoList = PrdProductMapper.INSTANCE.convertToPrdProductDtoList(prdProductList);

        return prdProductDtoList;
    }

    public void delete(Long id) {
        PrdProduct prdProduct = prdProductEntityService.getById(id);

        prdProductEntityService.delete(prdProduct);
    }

}
