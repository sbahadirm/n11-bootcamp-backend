package com.bahadirmemis.n11.n11bootcamp.usr.service;

import com.bahadirmemis.n11.n11bootcamp.usr.converter.UsrUserFavoriteListMapper;
import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrFavoriteListDto;
import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrFavoriteListSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrFavoriteList;
import com.bahadirmemis.n11.n11bootcamp.usr.service.entityservice.UsrFavoriteListEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsrUserFavoriteListService {

    private final UsrFavoriteListEntityService usrFavoriteListEntityService;

    public List<UsrFavoriteListDto> findAll() {

        List<UsrFavoriteList> favoriteListList = usrFavoriteListEntityService.findAll();

        List<UsrFavoriteListDto> usrFavoriteListDtoList = UsrUserFavoriteListMapper.INSTANCE.convertToUsrFavoriteListDtoList(favoriteListList);

        return usrFavoriteListDtoList;
    }

    public UsrFavoriteListDto findById(Long id) {

        UsrFavoriteList usrFavoriteList = findUsrFavoriteListById(id);

        UsrFavoriteListDto usrFavoriteListDto = UsrUserFavoriteListMapper.INSTANCE.convertToUsrFavoriteListDto(usrFavoriteList);

        return usrFavoriteListDto;
    }

    public List<UsrFavoriteListDto> findAllUsrUserFavoriteListByUsername(Long userId) {

        List<UsrFavoriteList> usrFavoriteListList = usrFavoriteListEntityService.findAllByUsrUserIdOrderById(userId);

        List<UsrFavoriteListDto> usrFavoriteListDtoList = UsrUserFavoriteListMapper.INSTANCE.convertToUsrFavoriteListDtoList(usrFavoriteListList);

        return usrFavoriteListDtoList;
    }

    public UsrFavoriteListDto save(UsrFavoriteListSaveRequestDto usrFavoriteListSaveRequestDto) {

        UsrFavoriteList usrFavoriteList = UsrUserFavoriteListMapper.INSTANCE.convertToUsrFavoriteList(usrFavoriteListSaveRequestDto);

        usrFavoriteList = usrFavoriteListEntityService.save(usrFavoriteList);

        UsrFavoriteListDto usrFavoriteListDto = UsrUserFavoriteListMapper.INSTANCE.convertToUsrFavoriteListDto(usrFavoriteList);

        return usrFavoriteListDto;
    }

    public void delete(Long id) {

        UsrFavoriteList usrFavoriteList = findUsrFavoriteListById(id);

        usrFavoriteListEntityService.delete(usrFavoriteList);
    }

    private UsrFavoriteList findUsrFavoriteListById(Long id) {
        Optional<UsrFavoriteList> favoriteListOptional = usrFavoriteListEntityService.findById(id);

        UsrFavoriteList usrFavoriteList;
        if (favoriteListOptional.isPresent()){
            usrFavoriteList = favoriteListOptional.get();
        } else {
            throw new RuntimeException("Favorite list not found!");
        }
        return usrFavoriteList;
    }
}
