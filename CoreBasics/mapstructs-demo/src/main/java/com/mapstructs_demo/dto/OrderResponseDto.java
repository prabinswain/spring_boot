package com.mapstructs_demo.dto;


import com.mapstructs_demo.entity.ShippingAddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {

    private String orderId;
    private String customerId;
    private LocalDateTime orderDate;
    private String orderStatus;
    private BigDecimal subtotal;
    private BigDecimal taxAmount;
    private BigDecimal shippingFee;
    private BigDecimal discountAmount;
    private BigDecimal totalAmount;
    private String paymentMethod;
    private String paymentStatus;
    private String shippingStreet;
    private String shippingCity;
    private String shippingState;
    private String shippingZip;
    private String shippingCountry;
    private String shippingMethod;
    private String trackingNumber;
    private LocalDateTime updatedAt;
    private ShippingAddressDto shippingAddress;
}
