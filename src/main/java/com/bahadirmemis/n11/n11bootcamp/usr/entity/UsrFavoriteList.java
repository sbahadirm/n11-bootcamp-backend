package com.bahadirmemis.n11.n11bootcamp.usr.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USR_FAVORITE_LIST")
@Data
public class UsrFavoriteList implements BaseEntity {

    @Id
    @SequenceGenerator(name = "UsrFavoriteList", sequenceName = "USR_FAVORITE_LIST_ID_SEQ")
    @GeneratedValue(generator = "UsrFavoriteList")
    private Long id;

    private Long usrUserId;
    private String name;
}
