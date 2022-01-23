package com.bahadirmemis.n11.n11bootcamp.prd.service;

import com.bahadirmemis.n11.n11bootcamp.prd.converter.PrdCategoryMapper;
import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdCategoryForMenuDto;
import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdCategorySaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.prd.entity.PrdCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PrdCategoryDataProvider {

    public static List<PrdCategorySaveRequestDto> convertToPrdCategorySaveRequestDto(List<PrdCategory> prdCategoryList) {
        List<PrdCategorySaveRequestDto> prdCategorySaveRequestDtoList = PrdCategoryMapper.INSTANCE
                .convertToPrdCategorySaveRequestDtoList(prdCategoryList);
        return prdCategorySaveRequestDtoList;
    }

    public static PrdCategory getPrdCategory(){

        PrdCategory prdCategory1 = new PrdCategory();
        prdCategory1.setId(1L);
        prdCategory1.setName("Category-1");
        prdCategory1.setShortName("category-1");
        prdCategory1.setLevel(1L);
        prdCategory1.setSuperCategoryId(null);

        return prdCategory1;
    }

    public static PrdCategorySaveRequestDto getPrdCategorySaveRequestDto(Long id){

        PrdCategorySaveRequestDto prdCategory1 = new PrdCategorySaveRequestDto();
        prdCategory1.setId(id);
        prdCategory1.setName("Category-1");
        prdCategory1.setShortName("category-1");
        prdCategory1.setLevel(1L);
        prdCategory1.setSuperCategoryId(null);

        return prdCategory1;
    }

    public static List<PrdCategorySaveRequestDto> getAllPrdCategorySaveRequestDto(){

        List<PrdCategorySaveRequestDto> prdCategoryList = new ArrayList<>();

        PrdCategorySaveRequestDto prdCategory1 = new PrdCategorySaveRequestDto();
        prdCategory1.setId(1L);
        prdCategory1.setName("Category-1");
        prdCategory1.setShortName("category-1");
        prdCategory1.setLevel(1L);
        prdCategory1.setSuperCategoryId(null);
        prdCategoryList.add(prdCategory1);


        PrdCategorySaveRequestDto prdCategory2 = new PrdCategorySaveRequestDto();
        prdCategory2.setId(2L);
        prdCategory2.setName("Category-2");
        prdCategory2.setShortName("category-2");
        prdCategory2.setLevel(1L);
        prdCategory2.setSuperCategoryId(null);
        prdCategoryList.add(prdCategory2);


        PrdCategorySaveRequestDto prdCategory3 = new PrdCategorySaveRequestDto();
        prdCategory3.setId(3L);
        prdCategory3.setName("Category-3");
        prdCategory3.setShortName("category-3");
        prdCategory3.setLevel(1L);
        prdCategory3.setSuperCategoryId(null);
        prdCategoryList.add(prdCategory3);


        PrdCategorySaveRequestDto prdCategory4 = new PrdCategorySaveRequestDto();
        prdCategory4.setId(4L);
        prdCategory4.setName("Category-4");
        prdCategory4.setShortName("category-4");
        prdCategory4.setLevel(2L);
        prdCategory4.setSuperCategoryId(1L);
        prdCategoryList.add(prdCategory4);


        PrdCategorySaveRequestDto prdCategory5 = new PrdCategorySaveRequestDto();
        prdCategory5.setId(5L);
        prdCategory5.setName("Category-5");
        prdCategory5.setShortName("category-5");
        prdCategory5.setLevel(2L);
        prdCategory5.setSuperCategoryId(3L);
        prdCategoryList.add(prdCategory5);


        PrdCategorySaveRequestDto prdCategory6 = new PrdCategorySaveRequestDto();
        prdCategory6.setId(6L);
        prdCategory6.setName("Category-6");
        prdCategory6.setShortName("category-6");
        prdCategory6.setLevel(2L);
        prdCategory6.setSuperCategoryId(1L);
        prdCategoryList.add(prdCategory6);


        PrdCategorySaveRequestDto prdCategory7 = new PrdCategorySaveRequestDto();
        prdCategory7.setId(7L);
        prdCategory7.setName("Category-7");
        prdCategory7.setShortName("category-7");
        prdCategory7.setLevel(2L);
        prdCategory7.setSuperCategoryId(1L);
        prdCategoryList.add(prdCategory7);


        PrdCategorySaveRequestDto prdCategory8 = new PrdCategorySaveRequestDto();
        prdCategory8.setId(8L);
        prdCategory8.setName("Category-8");
        prdCategory8.setShortName("category-8");
        prdCategory8.setLevel(3L);
        prdCategory8.setSuperCategoryId(6L);
        prdCategoryList.add(prdCategory8);


        PrdCategorySaveRequestDto prdCategory9 = new PrdCategorySaveRequestDto();
        prdCategory9.setId(9L);
        prdCategory9.setName("Category-9");
        prdCategory9.setShortName("category-9");
        prdCategory9.setLevel(3L);
        prdCategory9.setSuperCategoryId(6L);
        prdCategoryList.add(prdCategory9);


        PrdCategorySaveRequestDto prdCategory10 = new PrdCategorySaveRequestDto();
        prdCategory10.setId(10L);
        prdCategory10.setName("Category-10");
        prdCategory10.setShortName("category-10");
        prdCategory10.setLevel(3L);
        prdCategory10.setSuperCategoryId(6L);
        prdCategoryList.add(prdCategory10);

        return prdCategoryList;
    }

    public static List<PrdCategory> getAllPrdCategoryList(){

        List<PrdCategory> prdCategoryList = new ArrayList<>();

        PrdCategory prdCategory1 = new PrdCategory();
        prdCategory1.setId(1L);
        prdCategory1.setName("Category-1");
        prdCategory1.setShortName("category-1");
        prdCategory1.setLevel(1L);
        prdCategory1.setSuperCategoryId(null);
        prdCategoryList.add(prdCategory1);

        PrdCategory prdCategory2 = new PrdCategory();
        prdCategory2.setId(2L);
        prdCategory2.setName("Category-2");
        prdCategory2.setShortName("category-2");
        prdCategory2.setLevel(1L);
        prdCategory2.setSuperCategoryId(null);
        prdCategoryList.add(prdCategory2);


        PrdCategory prdCategory3 = new PrdCategory();
        prdCategory3.setId(3L);
        prdCategory3.setName("Category-3");
        prdCategory3.setShortName("category-3");
        prdCategory3.setLevel(1L);
        prdCategory3.setSuperCategoryId(null);
        prdCategoryList.add(prdCategory3);


        PrdCategory prdCategory4 = new PrdCategory();
        prdCategory4.setId(4L);
        prdCategory4.setName("Category-4");
        prdCategory4.setShortName("category-4");
        prdCategory4.setLevel(2L);
        prdCategory4.setSuperCategoryId(1L);
        prdCategoryList.add(prdCategory4);


        PrdCategory prdCategory5 = new PrdCategory();
        prdCategory5.setId(5L);
        prdCategory5.setName("Category-5");
        prdCategory5.setShortName("category-5");
        prdCategory5.setLevel(2L);
        prdCategory5.setSuperCategoryId(3L);
        prdCategoryList.add(prdCategory5);


        PrdCategory prdCategory6 = new PrdCategory();
        prdCategory6.setId(6L);
        prdCategory6.setName("Category-6");
        prdCategory6.setShortName("category-6");
        prdCategory6.setLevel(2L);
        prdCategory6.setSuperCategoryId(1L);
        prdCategoryList.add(prdCategory6);


        PrdCategory prdCategory7 = new PrdCategory();
        prdCategory7.setId(7L);
        prdCategory7.setName("Category-7");
        prdCategory7.setShortName("category-7");
        prdCategory7.setLevel(2L);
        prdCategory7.setSuperCategoryId(1L);
        prdCategoryList.add(prdCategory7);


        PrdCategory prdCategory8 = new PrdCategory();
        prdCategory8.setId(8L);
        prdCategory8.setName("Category-8");
        prdCategory8.setShortName("category-8");
        prdCategory8.setLevel(3L);
        prdCategory8.setSuperCategoryId(6L);
        prdCategoryList.add(prdCategory8);


        PrdCategory prdCategory9 = new PrdCategory();
        prdCategory9.setId(9L);
        prdCategory9.setName("Category-9");
        prdCategory9.setShortName("category-9");
        prdCategory9.setLevel(3L);
        prdCategory9.setSuperCategoryId(6L);
        prdCategoryList.add(prdCategory9);


        PrdCategory prdCategory10 = new PrdCategory();
        prdCategory10.setId(10L);
        prdCategory10.setName("Category-10");
        prdCategory10.setShortName("category-10");
        prdCategory10.setLevel(3L);
        prdCategory10.setSuperCategoryId(6L);
        prdCategoryList.add(prdCategory10);

        return prdCategoryList;
    }

    public static List<PrdCategory> getAllCategoryList() {

        List<PrdCategory> prdCategoryList = new ArrayList<>();

        Long level = 1L;
        for (long i = 1; i <=10 ; i++){

            if (i % 4 == 0){
                level++;
            }

            Long superCategoryId = null;
            if (level > 1L){
                superCategoryId = (long) new Random().nextInt(3) + 1 + (level.intValue() - 2)*3;
            }

            PrdCategory prdCategory = new PrdCategory();
            prdCategory.setId(i);
            prdCategory.setName("Category-" + i);
            prdCategory.setShortName("category-" + i);
            prdCategory.setLevel(level);
            prdCategory.setSuperCategoryId(superCategoryId);

            prdCategoryList.add(prdCategory);
        }

        return prdCategoryList;
    }

    public static List<PrdCategoryForMenuDto> convertToPrdCategoryForMenuDto(Map<Long, List<PrdCategory>> superCategoryIdAndListMap, List<PrdCategory> mailMenuList) {

        List<PrdCategoryForMenuDto> prdCategoryForMenuDtoList = new ArrayList<>();

        if (mailMenuList != null){
            for (PrdCategory prdCategory : mailMenuList) {

                PrdCategoryForMenuDto prdCategoryForMenuDto = PrdCategoryMapper.INSTANCE.convertToPrdCategoryForMenuDto(prdCategory);

                List<PrdCategory> subCategoryList = getSubCategories(superCategoryIdAndListMap, prdCategory);
                List<PrdCategoryForMenuDto> subPrdCategoryForMenuDtoList = convertToPrdCategoryForMenuDto(superCategoryIdAndListMap, subCategoryList);

                prdCategoryForMenuDto.setSubPrdCategoryForMenuDtoList(subPrdCategoryForMenuDtoList);
                prdCategoryForMenuDtoList.add(prdCategoryForMenuDto);
            }
        }

        return prdCategoryForMenuDtoList;

    }

    private static List<PrdCategory> getSubCategories(Map<Long, List<PrdCategory>> superCategoryIdAndListMap, PrdCategory prdCategory) {

        List<PrdCategory> prdCategoryList = superCategoryIdAndListMap.get(prdCategory.getId());

        if (prdCategoryList != null && !prdCategoryList.isEmpty()){
            for (PrdCategory eachPrdCategory : prdCategoryList) {
                getSubCategories(superCategoryIdAndListMap, eachPrdCategory);
            }
        }

        return prdCategoryList;
    }
}
