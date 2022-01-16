package com.bahadirmemis.n11.n11bootcamp.usr.service;

import com.bahadirmemis.n11.n11bootcamp.usr.converter.UsrFavoriteProductMapper;
import com.bahadirmemis.n11.n11bootcamp.usr.converter.UsrUserFavoriteListMapper;
import com.bahadirmemis.n11.n11bootcamp.usr.dto.*;
import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrFavoriteList;
import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrFavoriteProduct;
import com.bahadirmemis.n11.n11bootcamp.usr.service.entityservice.UsrFavoriteListEntityService;
import com.bahadirmemis.n11.n11bootcamp.usr.service.entityservice.UsrFavoriteProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsrUserFavoriteListService {

    private final UsrFavoriteListEntityService usrFavoriteListEntityService;

    private final UsrFavoriteProductEntityService usrFavoriteProductEntityService;

    public List<UsrFavoriteListDto> findAll() {

        List<UsrFavoriteList> favoriteListList = usrFavoriteListEntityService.findAll();

        List<UsrFavoriteListDto> usrFavoriteListDtoList = UsrUserFavoriteListMapper.INSTANCE.convertToUsrFavoriteListDtoList(favoriteListList);

        return usrFavoriteListDtoList;
    }

    public UsrFavoriteListDto findById(Long id) {

        UsrFavoriteList usrFavoriteList = usrFavoriteListEntityService.getById(id);

        UsrFavoriteListDto usrFavoriteListDto = UsrUserFavoriteListMapper.INSTANCE.convertToUsrFavoriteListDto(usrFavoriteList);

        return usrFavoriteListDto;
    }

    public List<UsrFavoriteListDto> findAllUsrUserFavoriteListByUserId(Long userId) {

        List<UsrFavoriteList> usrFavoriteListList = usrFavoriteListEntityService.findAllByUsrUserIdOrderById(userId);

        List<UsrFavoriteListDto> usrFavoriteListDtoList = UsrUserFavoriteListMapper.INSTANCE.convertToUsrFavoriteListDtoList(usrFavoriteListList);

        return usrFavoriteListDtoList;
    }

    public List<UsrFavoriteListDto> findAllUsrUserFavoriteListDtoByUsername(String username) {
        List<UsrFavoriteList> usrFavoriteListList = usrFavoriteListEntityService.findAllUsrFavoriteListByUsername(username);

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

        UsrFavoriteList usrFavoriteList = usrFavoriteListEntityService.getById(id);

        usrFavoriteListEntityService.delete(usrFavoriteList);
    }

    public void removeProductToList(Long id) {

        UsrFavoriteProduct usrFavoriteProduct = usrFavoriteProductEntityService.getById(id);

        usrFavoriteProductEntityService.delete(usrFavoriteProduct);
    }

    public UsrFavoriteProductDto addProductToList(UsrFavoriteProductSaveRequestDto usrFavoriteProductSaveRequestDto) {

        UsrFavoriteProduct usrFavoriteProduct = UsrFavoriteProductMapper.INSTANCE.convertToUsrFavoriteProduct
                (usrFavoriteProductSaveRequestDto);

        usrFavoriteProduct = usrFavoriteProductEntityService.save(usrFavoriteProduct);

        UsrFavoriteProductDto usrFavoriteProductDto = UsrFavoriteProductMapper.INSTANCE.convertToUsrFavoriteProductDto(usrFavoriteProduct);

        return usrFavoriteProductDto;
    }

    public List<UsrFavoriteProductDetailDto> getAllProductsByFavListId(Long favListId) {
        List<UsrFavoriteProductDetailDto> usrFavoriteProductDetailDtoList = usrFavoriteProductEntityService
                .findAllUsrFavoriteProductDetailDtoByFavListId(favListId);

        return usrFavoriteProductDetailDtoList;
    }
}
