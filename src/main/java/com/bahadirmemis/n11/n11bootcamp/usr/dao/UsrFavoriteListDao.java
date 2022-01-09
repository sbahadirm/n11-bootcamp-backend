package com.bahadirmemis.n11.n11bootcamp.usr.dao;

import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrFavoriteList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsrFavoriteListDao extends JpaRepository<UsrFavoriteList, Long> {

    List<UsrFavoriteList> findAllByUsrUserIdOrderById(Long userId);
}
