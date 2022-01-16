package com.bahadirmemis.n11.n11bootcamp.usr.controller;

import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrUserDto;
import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrUserSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.usr.service.UsrUserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
@RequiredArgsConstructor
public class UsrUserController {

    private final UsrUserService usrUserService;

    @GetMapping
    public ResponseEntity getAll(){

        List<UsrUserDto> usrUserDtoList = usrUserService.findAll();

        return ResponseEntity.ok(usrUserDtoList);
    }

    @GetMapping("/vendors")
    public ResponseEntity getAllVendors(){

        List<UsrUserDto> usrUserDtoList = usrUserService.getAllVendors();

        return ResponseEntity.ok(usrUserDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){

        UsrUserDto usrUserDto = usrUserService.findById(id);

        return ResponseEntity.ok(usrUserDto);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity getByUsername(@PathVariable String username){

        UsrUserDto usrUserDto = usrUserService.findByUsername(username);

        return ResponseEntity.ok(usrUserDto);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody UsrUserSaveRequestDto usrUserSaveRequestDto){

        UsrUserDto usrUserDto = usrUserService.save(usrUserSaveRequestDto);

        return ResponseEntity.ok(usrUserDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        usrUserService.delete(id);
    }
}
