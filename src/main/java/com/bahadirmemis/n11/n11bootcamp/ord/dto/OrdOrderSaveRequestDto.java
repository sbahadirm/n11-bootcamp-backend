package com.bahadirmemis.n11.n11bootcamp.ord.dto;

import com.bahadirmemis.n11.n11bootcamp.ord.enums.EnumDeliveryStatus;
import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrdOrderSaveRequestDto {

    private Long id;

    @NotNull
    private String username;
    private BigDecimal paidAmount;
    private String deliveryCompany;

    @Size(min = 6)
    private String parcelTrackingCode;

    private Long addressId;
    private EnumDeliveryStatus deliveryStatus;

    @Future
    private Date deliveryDate;
    private List<Long> basBasketProductIdList;
}
