package com.bahadirmemis.n11.n11bootcamp.prd.controller;

import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdCategoryForMenuDto;
import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdCategorySaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.prd.entity.PrdCategory;
import com.bahadirmemis.n11.n11bootcamp.prd.service.PrdService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
@CrossOrigin
public class PrdCategoryController {

    private PrdService prdService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody PrdCategorySaveRequestDto prdCategorySaveRequestDto){

        PrdCategory prdCategory = prdService.saveCategory(prdCategorySaveRequestDto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(prdCategory.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getPrdCategoryById(@PathVariable Long id){

        PrdCategorySaveRequestDto prdCategory = prdService.getPrdCategoryById(id);

        return ResponseEntity.ok(prdCategory);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<PrdCategorySaveRequestDto> prdCategoryList = prdService.findAll();

        return ResponseEntity.ok(prdCategoryList);
    }

    @GetMapping("/super/{superCategoryId}")
    public ResponseEntity findBySuperCategoryId(@PathVariable Long superCategoryId){
        List<PrdCategorySaveRequestDto> prdCategorySaveRequestDtoList = prdService.findBySuperCategoryId(superCategoryId);

        return ResponseEntity.ok(prdCategorySaveRequestDtoList);
    }

    @GetMapping("/menu")
    public ResponseEntity findAllForMenu(){
        List<PrdCategoryForMenuDto> prdCategoryList = prdService.findAllForMenu();

        return ResponseEntity.ok(prdCategoryList);
    }
}
