package com.bahadirmemis.n11.n11bootcamp.bas.controller;

import com.bahadirmemis.n11.n11bootcamp.bas.dto.BasBasketDto;
import com.bahadirmemis.n11.n11bootcamp.bas.dto.BasBasketProductDetailDto;
import com.bahadirmemis.n11.n11bootcamp.bas.dto.BasBasketSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.bas.entity.BasBasketProduct;
import com.bahadirmemis.n11.n11bootcamp.bas.service.BasBasketService;
import com.bahadirmemis.n11.n11bootcamp.prd.dto.PrdProductSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrUserDto;
import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrUserSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.usr.service.UsrUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/basket")
@CrossOrigin
@RequiredArgsConstructor
public class BasBasketController {

    private final BasBasketService basBasketService;

    @GetMapping("/{id}")
    public ResponseEntity getBasBasketById(@PathVariable Long id){

        BasBasketDto basBasketDto = basBasketService.getBasBasketById(id);

        return ResponseEntity.ok(basBasketDto);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity getBasBasketByUsername(@PathVariable String username){

        BasBasketDto basBasketDto = basBasketService.getBasBasketByUsername(username);

        return ResponseEntity.ok(basBasketDto);
    }

    @GetMapping("/{basketId}/products/")
    public ResponseEntity getAllProductsByBasketId(@PathVariable Long basketId){

        List<BasBasketProductDetailDto> basBasketProductDetailDtoList = basBasketService.getAllProductsByBasketId(basketId);

        return ResponseEntity.ok(basBasketProductDetailDtoList);
    }

    @GetMapping("/users/{username}/products/")
    public ResponseEntity getAllProductsByUsername(@PathVariable String username){

        List<BasBasketProductDetailDto> basBasketProductDetailDtoList = basBasketService.getAllProductsByUsername(username);

        return ResponseEntity.ok(basBasketProductDetailDtoList);
    }


    @PostMapping
    public ResponseEntity createBasket(@RequestBody BasBasketSaveRequestDto basBasketSaveRequestDto){

        BasBasketDto basBasketDto = basBasketService.createBasket(basBasketSaveRequestDto);

        return ResponseEntity.ok(basBasketDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBasket(@PathVariable Long id){
        basBasketService.deleteBasket(id);
    }

    @PostMapping("/users/{username}/products")
    public ResponseEntity addProductToBasketByUsername(@PathVariable String username, PrdProductSaveRequestDto prdProductSaveRequestDto){

        BasBasketProductDetailDto basBasketProductDetailDto = basBasketService.addProductToBasketByUsername(username, prdProductSaveRequestDto);

        return ResponseEntity.ok(basBasketProductDetailDto);
    }

    @DeleteMapping("/products/{id}")
    public void removeProductFromBasket(@PathVariable Long id){
        basBasketService.removeProductFromBasket(id);
    }
}
