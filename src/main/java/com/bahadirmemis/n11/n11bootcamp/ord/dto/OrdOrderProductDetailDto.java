package com.bahadirmemis.n11.n11bootcamp.ord.dto;

import com.bahadirmemis.n11.n11bootcamp.ord.enums.EnumDeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
public class OrdOrderProductDetailDto {

    private Long id;
    private Long ordOrderId;
    private Long prdProductId;
    private Date orderDate;
    private BigDecimal paidAmount;
    private String deliveryCompany;
    private String parcelTrackingCode;
    private Long addressId;
    private EnumDeliveryStatus deliveryStatus;
    private Date deliveryDate;
    private Long orderNo;
    private String name;
    private String shortName;
    private Long categoryId;
    private Long vendorUserId;
    private String imageUrl;
    private BigDecimal price;
    private BigDecimal additionalDiscount;
}
