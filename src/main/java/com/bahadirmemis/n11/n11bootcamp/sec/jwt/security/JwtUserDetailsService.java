package com.bahadirmemis.n11.n11bootcamp.sec.jwt.security;

import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrUser;
import com.bahadirmemis.n11.n11bootcamp.usr.service.entityservice.UsrUserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsrUserEntityService userEntityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsrUser user = userEntityService.findByUsername(username);

        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {

        Optional<UsrUser> userOptional = userEntityService.findById(id);

        if (userOptional.isPresent()){
            UsrUser usrUser = userOptional.get();
            return JwtUserDetails.create(usrUser);
        } else {
            throw new RuntimeException("User nor found!");
        }
    }
}
