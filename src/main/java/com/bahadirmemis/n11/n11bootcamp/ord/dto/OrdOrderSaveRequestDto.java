package com.bahadirmemis.n11.n11bootcamp.ord.dto;

import com.bahadirmemis.n11.n11bootcamp.ord.enums.EnumDeliveryStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrdOrderSaveRequestDto {

    private Long id;
    private Long basBasketId;
    private BigDecimal paidAmount;
    private String deliveryCompany;
    private String parcelTrackingCode;
    private Long addressId;
    private EnumDeliveryStatus deliveryStatus;
    private Date deliveryDate;
}
