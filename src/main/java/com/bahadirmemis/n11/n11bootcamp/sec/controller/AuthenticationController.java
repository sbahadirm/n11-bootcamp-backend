package com.bahadirmemis.n11.n11bootcamp.sec.controller;

import com.bahadirmemis.n11.n11bootcamp.sec.dto.UserRequestDto;
import com.bahadirmemis.n11.n11bootcamp.sec.service.AuthenticationService;
import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrUserDto;
import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrUserSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public String login(@RequestBody UserRequestDto userRequestDto){

        return authenticationService.login(userRequestDto);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UsrUserSaveRequestDto usrUserSaveRequestDto){

        UsrUserDto usrUserDto = authenticationService.registerUser(usrUserSaveRequestDto);

        return ResponseEntity.ok(usrUserDto);
    }


}
