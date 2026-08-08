package com.mapstructs_demo.mapper;

import com.mapstructs_demo.dto.OrderResponseDto;
import com.mapstructs_demo.dto.ShippingAddressDto;
import com.mapstructs_demo.entity.OrderEntity;
import com.mapstructs_demo.entity.ShippingAddressEntity;

public class OrderMapper {

    // --- Entity to DTO Mappings ---

    public static OrderResponseDto toOrderDto(OrderEntity entity) {
        if (entity == null) {
            return null;
        }

        OrderResponseDto dto = new OrderResponseDto();
        dto.setOrderId(entity.getOrderId());
        dto.setCustomerId(entity.getCustomerId());
        dto.setOrderDate(entity.getOrderDate());
        dto.setOrderStatus(entity.getOrderStatus());
        dto.setSubtotal(entity.getSubtotal());
        dto.setTaxAmount(entity.getTaxAmount());
        dto.setShippingFee(entity.getShippingFee());
        dto.setDiscountAmount(entity.getDiscountAmount());
        dto.setTotalAmount(entity.getTotalAmount());
        dto.setPaymentMethod(entity.getPaymentMethod());
        dto.setPaymentStatus(entity.getPaymentStatus());
        dto.setShippingMethod(entity.getShippingMethod());
        dto.setTrackingNumber(entity.getTrackingNumber());
        dto.setUpdatedAt(entity.getUpdatedAt());

        // Handle nested child entity mapping safely
        if (entity.getShippingAddress() != null) {
            dto.setShippingAddress(toDto(entity.getShippingAddress()));
        }

        return dto;
    }

    public static ShippingAddressDto toDto(ShippingAddressEntity entity) {
        if (entity == null) {
            return null;
        }

        ShippingAddressDto dto = new ShippingAddressDto();
        dto.setAddressId(entity.getAddressId());
        dto.setStreet(entity.getStreet());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setZipCode(entity.getZipCode());
        dto.setCountry(entity.getCountry());

        return dto;
    }

    // --- DTO to Entity Mappings ---

    public static OrderEntity toOrderEntity(OrderResponseDto dto) {
        if (dto == null) {
            return null;
        }

        OrderEntity entity = new OrderEntity();
        entity.setOrderId(dto.getOrderId());
        entity.setCustomerId(dto.getCustomerId());
        entity.setOrderDate(dto.getOrderDate());
        entity.setOrderStatus(dto.getOrderStatus());
        entity.setSubtotal(dto.getSubtotal());
        entity.setTaxAmount(dto.getTaxAmount());
        entity.setShippingFee(dto.getShippingFee());
        entity.setDiscountAmount(dto.getDiscountAmount());
        entity.setTotalAmount(dto.getTotalAmount());
        entity.setPaymentMethod(dto.getPaymentMethod());
        entity.setPaymentStatus(dto.getPaymentStatus());
        entity.setShippingMethod(dto.getShippingMethod());
        entity.setTrackingNumber(dto.getTrackingNumber());
        entity.setUpdatedAt(dto.getUpdatedAt());

        // Handle nested child DTO mapping safely
        if (dto.getShippingAddress() != null) {
            ShippingAddressEntity addressEntity = toEntity(dto.getShippingAddress());
            entity.setShippingAddress(addressEntity);
            // Establish the bidirectional sync reference required by JPA
            addressEntity.setOrder(entity);
        }

        return entity;
    }



    public static ShippingAddressEntity toEntity(ShippingAddressDto dto) {
        if (dto == null) {
            return null;
        }

        ShippingAddressEntity entity = new ShippingAddressEntity();
        entity.setAddressId(dto.getAddressId());
        entity.setStreet(dto.getStreet());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setZipCode(dto.getZipCode());
        entity.setCountry(dto.getCountry());

        return entity;
    }
}
