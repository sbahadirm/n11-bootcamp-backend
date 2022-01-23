package com.bahadirmemis.n11.n11bootcamp.prd.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PrdCategorySaveRequestDto {

    private Long id;

    @NotNull
    @Size(min = 2)
    private String name;

    @NotNull
    @Size(min = 2)
    private String shortName;

    @NotNull
    private Long level;

    private Long superCategoryId;
}
