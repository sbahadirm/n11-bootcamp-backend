package com.bahadirmemis.n11.n11bootcamp.usr.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USR_FAVORITE_LIST")
@Data
public class UsrFavoriteList implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long usrUserId;
    private String name;
}
