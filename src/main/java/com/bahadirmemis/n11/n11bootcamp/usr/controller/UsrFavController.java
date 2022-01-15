package com.bahadirmemis.n11.n11bootcamp.usr.controller;

import com.bahadirmemis.n11.n11bootcamp.usr.dto.*;
import com.bahadirmemis.n11.n11bootcamp.usr.service.UsrUserFavoriteListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/favs")
@RequiredArgsConstructor
public class UsrFavController {

    private final UsrUserFavoriteListService usrUserFavoriteListService;

    @GetMapping
    public ResponseEntity getAll(){

        List<UsrFavoriteListDto> usrFavoriteListDtoList = usrUserFavoriteListService.findAll();

        return ResponseEntity.ok(usrFavoriteListDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){

        UsrFavoriteListDto usrFavoriteListDto = usrUserFavoriteListService.findById(id);

        return ResponseEntity.ok(usrFavoriteListDto);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getByUserId(@PathVariable Long id){

        List<UsrFavoriteListDto> usrFavoriteListDtoList = usrUserFavoriteListService.findAllUsrUserFavoriteListByUserId(id);

        return ResponseEntity.ok(usrFavoriteListDtoList);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody UsrFavoriteListSaveRequestDto usrFavoriteListSaveRequestDto){

        UsrFavoriteListDto usrFavoriteListDto = usrUserFavoriteListService.save(usrFavoriteListSaveRequestDto);

        return ResponseEntity.ok(usrFavoriteListDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        usrUserFavoriteListService.delete(id);
    }

    @GetMapping("/users/username/{username}")
    public ResponseEntity findAllByUsername(@PathVariable String username){

        List<UsrFavoriteListDto> usrFavoriteListDtoList = usrUserFavoriteListService.findAllUsrUserFavoriteListDtoByUsername(username);

        return ResponseEntity.ok(usrFavoriteListDtoList);
    }

    @GetMapping("/{favListId}/products")
    public ResponseEntity getAllProductsByFavListId(@PathVariable Long favListId){

        List<UsrFavoriteProductDetailDto> usrFavoriteProductDetailDtoList =
                usrUserFavoriteListService.getAllProductsByFavListId(favListId);

        return ResponseEntity.ok(usrFavoriteProductDetailDtoList);
    }

    @PostMapping("/{favListId}/products")
    public ResponseEntity addProductToList(@RequestBody UsrFavoriteProductSaveRequestDto usrFavoriteProductSaveRequestDto){

        UsrFavoriteProductDto usrFavoriteProductDto = usrUserFavoriteListService.addProductToList(usrFavoriteProductSaveRequestDto);

        return ResponseEntity.ok(usrFavoriteProductDto);
    }

    @DeleteMapping("/products/{id}")
    public void removeProductToList(@PathVariable Long id){
        usrUserFavoriteListService.removeProductToList(id);
    }

}
