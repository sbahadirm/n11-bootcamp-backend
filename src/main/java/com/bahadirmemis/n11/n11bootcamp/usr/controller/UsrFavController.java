package com.bahadirmemis.n11.n11bootcamp.usr.controller;

import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrFavoriteListDto;
import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrFavoriteListSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrUserDto;
import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrUserSaveRequestDto;
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

        List<UsrFavoriteListDto> usrFavoriteListDtoList = usrUserFavoriteListService.findAllUsrUserFavoriteListByUsername(id);

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
}
