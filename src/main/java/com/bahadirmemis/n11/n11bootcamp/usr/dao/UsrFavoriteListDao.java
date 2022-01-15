package com.bahadirmemis.n11.n11bootcamp.usr.dao;

import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrFavoriteList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsrFavoriteListDao extends JpaRepository<UsrFavoriteList, Long> {

    List<UsrFavoriteList> findAllByUsrUserIdOrderById(Long userId);

    @Query(
            "select usrFavoriteList from UsrFavoriteList usrFavoriteList " +
                    " left join UsrUser usrUser on usrFavoriteList.usrUserId = usrUser.id " +
                    " where usrUser.username = :username "
    )
    List<UsrFavoriteList> findAllUsrFavoriteListByUsername(@Param("username") String username);
}
