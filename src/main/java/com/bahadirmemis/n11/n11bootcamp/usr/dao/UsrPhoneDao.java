package com.bahadirmemis.n11.n11bootcamp.usr.dao;

import com.bahadirmemis.n11.n11bootcamp.usr.entity.UsrPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsrPhoneDao extends JpaRepository<UsrPhone, Long> {
}
