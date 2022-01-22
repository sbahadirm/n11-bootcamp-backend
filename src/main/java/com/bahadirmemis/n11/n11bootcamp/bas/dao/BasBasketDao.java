package com.bahadirmemis.n11.n11bootcamp.bas.dao;

import com.bahadirmemis.n11.n11bootcamp.bas.entity.BasBasket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BasBasketDao extends JpaRepository<BasBasket, Long> {

    @Query(
            " select basBasket from BasBasket basBasket " +
                    " left join UsrUser usrUser on basBasket.usrUserId = usrUser.id " +
                    " where usrUser.username = :username " +
                    " and basBasket.basketStatus = 'ACTIVE' "
    )
    BasBasket findBasBasketByUsername(@Param("username") String username);
}
