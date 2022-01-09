package com.bahadirmemis.n11.n11bootcamp.usr.service;

import com.bahadirmemis.n11.n11bootcamp.usr.converter.UsrUserMapper;
import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrUserDto;
import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrUserSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrUser;
import com.bahadirmemis.n11.n11bootcamp.usr.service.entityservice.UsrUserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsrUserService {

    private final UsrUserEntityService usrUserEntityService;

    public List<UsrUserDto> findAll() {

        List<UsrUser> usrUserList = usrUserEntityService.findAll();

        List<UsrUserDto> usrUserDtoList = UsrUserMapper.INSTANCE.convertToUsrUserDtoList(usrUserList);

        return usrUserDtoList;
    }

    public UsrUserDto findById(Long id) {

        UsrUser usrUser = findUsrUserById(id);

        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDtoList(usrUser);

        return usrUserDto;
    }

    public UsrUserDto findByUsername(String username) {

        UsrUser usrUser = usrUserEntityService.findByUsername(username);

        if (usrUser == null){
            throw new RuntimeException("User not found!");
        }

        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDtoList(usrUser);

        return usrUserDto;
    }

    public UsrUserDto save(UsrUserSaveRequestDto usrUserSaveRequestDto) {

        UsrUser usrUser = UsrUserMapper.INSTANCE.convertToUsrUserSaveRequestDto(usrUserSaveRequestDto);

        usrUser = usrUserEntityService.save(usrUser);

        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDtoList(usrUser);

        return usrUserDto;
    }

    public void delete(Long id) {

        UsrUser usrUser = findUsrUserById(id);

        usrUserEntityService.delete(usrUser);
    }

    private UsrUser findUsrUserById(Long id) {
        Optional<UsrUser> optionalUsrUser = usrUserEntityService.findById(id);

        UsrUser usrUser;
        if (optionalUsrUser.isPresent()){
            usrUser = optionalUsrUser.get();
        } else {
            throw new RuntimeException("User not found!");
        }
        return usrUser;
    }
}
