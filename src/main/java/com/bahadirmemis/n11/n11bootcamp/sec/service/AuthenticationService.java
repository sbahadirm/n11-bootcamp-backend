package com.bahadirmemis.n11.n11bootcamp.sec.service;

import com.bahadirmemis.n11.n11bootcamp.sec.dto.UserRequestDto;
import com.bahadirmemis.n11.n11bootcamp.sec.jwt.security.EnumJwtConstant;
import com.bahadirmemis.n11.n11bootcamp.sec.jwt.security.JwtTokenGenerator;
import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrUser;
import com.bahadirmemis.n11.n11bootcamp.usr.service.entityservice.UsrUserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UsrUserEntityService userEntityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

    public String login(UserRequestDto userRequestDto){

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
                (userRequestDto.getUsername(), userRequestDto.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenGenerator.generateJwtToken(authentication);

        return EnumJwtConstant.BEARER.getConstant() + token;
    }

//    public UsrUser register(String username, String password){
//
//        password = passwordEncoder.encode(password);
//
//        UsrUser user = new UsrUser();
//        user.setUsername(username);
//        user.setPassword(password);
//
//        return userEntityService.save(user);
//    }

    public void validateUserRequest(String username) {

        UsrUser user = userEntityService.findByUsername(username);

        if (user != null){
            throw new RuntimeException("Username already in use");
        }
    }
}
