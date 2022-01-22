package com.bahadirmemis.n11.n11bootcamp.bas.dao;

import com.bahadirmemis.n11.n11bootcamp.bas.entity.BasBasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasBasketProductDao extends JpaRepository<BasBasketProduct, Long> {

    List<BasBasketProduct> findAllByBasBasketIdOrderById(Long basBasketId);

    @Query(
            " select basBasketProduct from BasBasketProduct basBasketProduct " +
                    " left join BasBasket basBasket on basBasketProduct.basBasketId = basBasket.id " +
                    " left join UsrUser usrUser on basBasket.usrUserId = usrUser.id" +
                    " where usrUser.username = :username " +
                    " and basBasket.basketStatus = 'ACTIVE' " +
                    " order by basBasketProduct.id "
    )
    List<BasBasketProduct> findAllByUsernameOrderById(@Param("username") String username);

}
