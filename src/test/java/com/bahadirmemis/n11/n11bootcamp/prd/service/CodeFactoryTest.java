package com.bahadirmemis.n11.n11bootcamp.prd.service;

import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdCategorySaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.prd.entity.PrdCategory;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * This class is created to facilitate the generation of objects
 * with some dummy values and to automatically create them.
 */
public class CodeFactoryTest {

    public static void main(String[] args) {

        List<PrdCategory> allCategoryList = PrdCategoryDataProvider.getAllPrdCategoryList();

        getDinamicDtoCode(allCategoryList);
    }

    private static void getDinamicDtoCode(List<PrdCategory> allCategoryList) {
        System.out.println("List<PrdCategory> prdCategoryList = new ArrayList<>();\n");
        for (PrdCategory eachPrdCategory : allCategoryList) {

            PrdCategorySaveRequestDto prdCategory = new PrdCategorySaveRequestDto();
            prdCategory.setId(eachPrdCategory.getId());
            prdCategory.setName(eachPrdCategory.getName());
            prdCategory.setShortName(eachPrdCategory.getShortName());
            prdCategory.setLevel(eachPrdCategory.getLevel());
            prdCategory.setSuperCategoryId(eachPrdCategory.getSuperCategoryId());

            System.out.println("PrdCategorySaveRequestDto prdCategory" + eachPrdCategory.getId() +" = new PrdCategorySaveRequestDto();");
            System.out.println("prdCategory" + eachPrdCategory.getId() + ".setId(" + eachPrdCategory.getId() +"L);");
            System.out.println("prdCategory" + eachPrdCategory.getId() + ".setName(\"" + eachPrdCategory.getName() + "\");");
            System.out.println("prdCategory" + eachPrdCategory.getId() + ".setShortName(\"" + eachPrdCategory.getShortName() + "\");");
            System.out.println("prdCategory" + eachPrdCategory.getId() + ".setLevel(" + eachPrdCategory.getLevel() + "L);");
            System.out.println("prdCategory" + eachPrdCategory.getId() + ".setSuperCategoryId(" + eachPrdCategory.getSuperCategoryId() + "L);");
            System.out.println("prdCategoryList.add(prdCategory" + eachPrdCategory.getId() + ");");
            System.out.println("\n");
        }
    }

    private static void getDinamicCode(List<PrdCategory> allCategoryList) {
        System.out.println("List<PrdCategory> prdCategoryList = new ArrayList<>();\n");
        for (PrdCategory eachPrdCategory : allCategoryList) {

            PrdCategory prdCategory = new PrdCategory();
            prdCategory.setId(eachPrdCategory.getId());
            prdCategory.setName(eachPrdCategory.getName());
            prdCategory.setShortName(eachPrdCategory.getShortName());
            prdCategory.setLevel(eachPrdCategory.getLevel());
            prdCategory.setSuperCategoryId(eachPrdCategory.getSuperCategoryId());

            System.out.println("PrdCategory prdCategory" + eachPrdCategory.getId() +" = new PrdCategory();");
            System.out.println("prdCategory" + eachPrdCategory.getId() + ".setId(" + eachPrdCategory.getId() +"L);");
            System.out.println("prdCategory" + eachPrdCategory.getId() + ".setName(\"" + eachPrdCategory.getName() + "\");");
            System.out.println("prdCategory" + eachPrdCategory.getId() + ".setShortName(\"" + eachPrdCategory.getShortName() + "\");");
            System.out.println("prdCategory" + eachPrdCategory.getId() + ".setLevel(" + eachPrdCategory.getLevel() + "L);");
            System.out.println("prdCategory" + eachPrdCategory.getId() + ".setSuperCategoryId(" + eachPrdCategory.getSuperCategoryId() + "L);");
            System.out.println("prdCategoryList.add(prdCategory" + eachPrdCategory.getId() + ");");
            System.out.println("\n");
        }
    }

    private static void testRandom() {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i<100; i++){

            int i1 = new Random().nextInt(4) + 4;
            int i2 = new Random().nextInt(3) + 1;

//            int random = new Random().nextInt(3-1) + 1 + (2 - 2)*3;

            set.add(i1);
        }

        Integer min = set.stream().min(Integer::compareTo).get();
        Integer max = set.stream().max(Integer::compareTo).get();

        System.out.println("min: " + min + " ----- max: " + max);
    }
}
