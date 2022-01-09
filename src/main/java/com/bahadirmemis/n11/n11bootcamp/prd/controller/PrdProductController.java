package com.bahadirmemis.n11.n11bootcamp.prd.controller;

import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdProductDto;
import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdProductSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.prd.service.PrdProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
@CrossOrigin
public class PrdProductController {

    private PrdProductService prdProductService;

    @PostMapping
    public ResponseEntity save(@RequestBody PrdProductSaveRequestDto prdProductSaveRequestDto){

        PrdProductDto prdProductDto = prdProductService.save(prdProductSaveRequestDto);

        return ResponseEntity.ok(prdProductDto);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<PrdProductDto> prdProductDtoList = prdProductService.findAll();

        return ResponseEntity.ok(prdProductDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        PrdProductDto prdProductDto = prdProductService.findById(id);

        return ResponseEntity.ok(prdProductDto);
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity findAllByCategoryId(@PathVariable Long categoryId){
        List<PrdProductDto> prdProductDtoList = prdProductService.findAllByCategoryId(categoryId);

        return ResponseEntity.ok(prdProductDtoList);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        prdProductService.delete(id);
    }
}
