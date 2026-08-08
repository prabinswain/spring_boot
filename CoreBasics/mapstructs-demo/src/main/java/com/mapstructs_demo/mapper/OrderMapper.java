package com.mapstructs_demo;

import com.mapstructs_demo.dto.OrderResponseDto;
import com.mapstructs_demo.entity.OrderEntity;

public class OrderMapper {

    private OrderMapper() {
        // Prevent instantiation
    }

    public static OrderResponseDto toResponseDto(OrderEntity orderEntity) {

        if (orderEntity == null) {
            return null;
        }

        OrderResponseDto response = new OrderResponseDto();

        response.setOrderId(orderEntity.getOrderId());
        response.setCustomerId(orderEntity.getCustomerId());
        response.setOrderDate(orderEntity.getOrderDate());
        response.setOrderStatus(orderEntity.getOrderStatus());
        response.setSubtotal(orderEntity.getSubtotal());
        response.setTaxAmount(orderEntity.getTaxAmount());
        response.setShippingFee(orderEntity.getShippingFee());
        response.setDiscountAmount(orderEntity.getDiscountAmount());
        response.setTotalAmount(orderEntity.getTotalAmount());
        response.setPaymentMethod(orderEntity.getPaymentMethod());
        response.setPaymentStatus(orderEntity.getPaymentStatus());
        response.setShippingStreet(orderEntity.getShippingStreet());
        response.setShippingCity(orderEntity.getShippingCity());
        response.setShippingState(orderEntity.getShippingState());
        response.setShippingZip(orderEntity.getShippingZip());
        response.setShippingCountry(orderEntity.getShippingCountry());
        response.setShippingMethod(orderEntity.getShippingMethod());
        response.setTrackingNumber(orderEntity.getTrackingNumber());
        response.setUpdatedAt(orderEntity.getUpdatedAt());

        return response;
    }

    public static OrderEntity toOrderEntity(OrderResponseDto responseDto) {

        if (responseDto == null) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOrderId(responseDto.getOrderId());
        orderEntity.setCustomerId(responseDto.getCustomerId());
        orderEntity.setOrderDate(responseDto.getOrderDate());
        orderEntity.setOrderStatus(responseDto.getOrderStatus());
        orderEntity.setSubtotal(responseDto.getSubtotal());
        orderEntity.setTaxAmount(responseDto.getTaxAmount());
        orderEntity.setShippingFee(responseDto.getShippingFee());
        orderEntity.setDiscountAmount(responseDto.getDiscountAmount());
        orderEntity.setTotalAmount(responseDto.getTotalAmount());
        orderEntity.setPaymentMethod(responseDto.getPaymentMethod());
        orderEntity.setPaymentStatus(responseDto.getPaymentStatus());
        orderEntity.setShippingStreet(responseDto.getShippingStreet());
        orderEntity.setShippingCity(responseDto.getShippingCity());
        orderEntity.setShippingState(responseDto.getShippingState());
        orderEntity.setShippingZip(responseDto.getShippingZip());
        orderEntity.setShippingCountry(responseDto.getShippingCountry());
        orderEntity.setShippingMethod(responseDto.getShippingMethod());
        orderEntity.setTrackingNumber(responseDto.getTrackingNumber());
        orderEntity.setUpdatedAt(responseDto.getUpdatedAt());

        return orderEntity;
    }
}
