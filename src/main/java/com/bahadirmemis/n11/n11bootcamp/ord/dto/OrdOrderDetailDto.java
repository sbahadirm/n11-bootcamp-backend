package com.bahadirmemis.n11.n11bootcamp.ord.dto;

import com.bahadirmemis.n11.n11bootcamp.ord.enums.EnumDeliveryStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrdOrderDetailDto {

    private Long id;
    private Date orderDate;
    private BigDecimal paidAmount;
    private String deliveryCompany;
    private String parcelTrackingCode;
    private Long addressId;
    private EnumDeliveryStatus deliveryStatus;
    private Date deliveryDate;
    private Long orderNo;
    private List<OrdOrderProductDetailDto> prdProductDtoList;
}
