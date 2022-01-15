package com.bahadirmemis.n11.n11bootcamp.sec.controller;

import com.bahadirmemis.n11.n11bootcamp.sec.dto.UserRequestDto;
import com.bahadirmemis.n11.n11bootcamp.sec.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
