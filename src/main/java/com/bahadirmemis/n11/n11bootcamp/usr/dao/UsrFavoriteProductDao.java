package com.bahadirmemis.n11.n11bootcamp.usr.dao;

import com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrFavoriteProductDetailDto;
import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrFavoriteProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsrFavoriteProductDao extends JpaRepository<UsrFavoriteProduct, Long> {

    @Query(
            "select " +
                    " new com.bahadirmemis.n11.n11bootcamp.usr.dto.UsrFavoriteProductDetailDto(" +
                    " usrFavoriteProduct.id, " +
                    " usrFavoriteProduct.usrFavoriteListId, " +
                    " usrFavoriteList.name, " +
                    " usrFavoriteProduct.prdProductId, " +
                    " prdProduct.name, " +
                    " prdProduct.imageUrl, " +
                    " prdProduct.price " +
                    " ) " +
                    " from UsrFavoriteProduct usrFavoriteProduct " +
                    " left join UsrFavoriteList usrFavoriteList " +
                        " on usrFavoriteProduct.usrFavoriteListId = usrFavoriteList.id " +
                    " left join PrdProduct prdProduct " +
                        " on usrFavoriteProduct.prdProductId = prdProduct.id " +
                    " where usrFavoriteProduct.usrFavoriteListId = :favListId "
    )
    List<UsrFavoriteProductDetailDto> findAllUsrFavoriteProductDetailDtoByFavListId(@Param("favListId") Long favListId);
}
