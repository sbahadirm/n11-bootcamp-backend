package com.bahadirmemis.n11.n11bootcamp.usr.entity;

import com.bahadirmemis.n11.n11bootcamp.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USR_FAVORITE_PRODUCT")
@Data
public class UsrFavoriteProduct implements BaseEntity {

    @Id
    @SequenceGenerator(name = "UsrFavoriteProduct", sequenceName = "USR_FAVORITE_PRODUCT_ID_SEQ")
    @GeneratedValue(generator = "UsrFavoriteProduct")
    private Long id;

    private Long usrFavoriteListId;
    private Long prdProductId;
}
