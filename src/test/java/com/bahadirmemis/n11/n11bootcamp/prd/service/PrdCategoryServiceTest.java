package com.bahadirmemis.n11.n11bootcamp.prd.service;

import com.bahadirmemis.n11.n11bootcamp.prd.converter.PrdCategoryConverter;
import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdCategoryForMenuDto;
import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdCategorySaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.prd.entity.PrdCategory;
import com.bahadirmemis.n11.n11bootcamp.prd.service.entityservice.PrdCategoryEntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PrdCategoryServiceTest {

    @Mock
    private PrdCategoryEntityService prdCategoryEntityService;

    @Mock
    private PrdCategoryConverter prdCategoryConverter;

    @InjectMocks
    private PrdCategoryService prdCategoryService;

    @Test
    void shouldfindAllExist() {

        List<PrdCategory> prdCategoryList = PrdCategoryDataProvider.getAllPrdCategoryList();
        List<PrdCategorySaveRequestDto> prdCategorySaveRequestDtoList = PrdCategoryDataProvider.convertToPrdCategorySaveRequestDto(prdCategoryList);

        when(prdCategoryEntityService.findAll()).thenReturn(prdCategoryList);

        List<PrdCategorySaveRequestDto> saveRequestDtoList = prdCategoryService.findAll();

        assertArrayEquals(prdCategorySaveRequestDtoList.toArray(), saveRequestDtoList.toArray());
    }

    @Test
    void shouldfindAllDoesNotExist() {

        List<PrdCategory> arrayList = new ArrayList<>();
        List<PrdCategorySaveRequestDto> prdCategorySaveRequestDtoList = PrdCategoryDataProvider.convertToPrdCategorySaveRequestDto(arrayList);

        when(prdCategoryEntityService.findAll()).thenReturn(arrayList);

        List<PrdCategorySaveRequestDto> saveRequestDtoList = prdCategoryService.findAll();

        assertArrayEquals(prdCategorySaveRequestDtoList.toArray(), saveRequestDtoList.toArray());
    }

    @Test
    void findAllForMenu() {

        List<PrdCategory> allCategoryList = PrdCategoryDataProvider.getAllPrdCategoryList();
        List<PrdCategoryForMenuDto> prdCategoryForMenuDtoListEx = new PrdCategoryConverter().convertToPrdCategoryForMenuDto(allCategoryList);

        when(prdCategoryEntityService.findAll()).thenReturn(allCategoryList);
        when(prdCategoryConverter.convertToPrdCategoryForMenuDto(anyList())).thenReturn(prdCategoryForMenuDtoListEx);

        List<PrdCategoryForMenuDto> prdCategoryForMenuDtoList = prdCategoryService.findAllForMenu();

        assertArrayEquals(prdCategoryForMenuDtoListEx.toArray(), prdCategoryForMenuDtoList.toArray());
    }

    @Test
    void saveCategory() {

        PrdCategorySaveRequestDto prdCategorySaveRequestDto = PrdCategoryDataProvider.getPrdCategorySaveRequestDto(null);
        PrdCategory prdCategorySaved = PrdCategoryDataProvider.getPrdCategory();

        when(prdCategoryEntityService.save(ArgumentMatchers.any(PrdCategory.class))).thenReturn(prdCategorySaved);

        PrdCategory result = prdCategoryService.saveCategory(prdCategorySaveRequestDto);

        assertEquals(prdCategorySaved, result);
        assertEquals(1L, result.getId());
    }

    @Test
    void findBySuperCategoryId() {

        List<PrdCategory> prdCategoryList = PrdCategoryDataProvider.getAllPrdCategoryList();
        List<PrdCategory> categoryList = prdCategoryList.stream()
                .filter(prdCategory -> prdCategory.getSuperCategoryId() != null && 1L == prdCategory.getSuperCategoryId())
                .collect(Collectors.toList());

        List<PrdCategorySaveRequestDto> categoryDtoList = PrdCategoryDataProvider.getAllPrdCategorySaveRequestDto().stream()
                .filter(prdCategory -> prdCategory.getSuperCategoryId() != null && 1L == prdCategory.getSuperCategoryId())
                .collect(Collectors.toList());

        when(prdCategoryEntityService.findBySuperCategoryId(any())).thenReturn(categoryList);

        List<PrdCategorySaveRequestDto> result = prdCategoryService.findBySuperCategoryId(1L);

        assertEquals(categoryDtoList.size(), result.size());
        assertArrayEquals(categoryDtoList.toArray(), result.toArray());
    }

    @Test
    void getPrdCategoryById() {

        PrdCategory prdCategory = PrdCategoryDataProvider.getPrdCategory();
        PrdCategorySaveRequestDto prdCategorySaveRequestDto = PrdCategoryDataProvider.getPrdCategorySaveRequestDto(1L);

        when(prdCategoryEntityService.getById(any())).thenReturn(prdCategory);

        PrdCategorySaveRequestDto result = prdCategoryService.getPrdCategoryById(1L);

        assertEquals(prdCategorySaveRequestDto, result);
    }

    @Test
    void getPrdCategoryById_shouldIdDoesNotExist() {

        when(prdCategoryEntityService.getById(0L)).thenThrow(new RuntimeException("Category not found!"));

        assertThrows(RuntimeException.class, () -> prdCategoryService.getPrdCategoryById(0L));

    }

    @Test
    void delete() {

        PrdCategory prdCategory = PrdCategoryDataProvider.getPrdCategory();

        when(prdCategoryEntityService.getById(anyLong())).thenReturn(prdCategory);

        prdCategoryService.delete(1L);

        verify(prdCategoryEntityService).getById(anyLong());
        verify(prdCategoryEntityService).delete(prdCategory);

    }

    @Test
    void delete_shouldIdDoesNotExist() {

        when(prdCategoryEntityService.getById(0L)).thenThrow(new RuntimeException("Category not found!"));

        assertThrows(RuntimeException.class, () -> prdCategoryService.delete(0L));
        verify(prdCategoryEntityService).getById(anyLong());

    }
}