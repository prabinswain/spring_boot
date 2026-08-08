package com.mapstructs_demo.service;

import com.mapstructs_demo.mapper.OrderMapper;
import com.mapstructs_demo.dto.OrderResponseDto;
import com.mapstructs_demo.entity.OrderEntity;
import com.mapstructs_demo.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrdersRepository ordersRepository;

    @Transactional
    public @Nullable OrderResponseDto createOrder(OrderResponseDto orderResponseDto) {
        OrderEntity order = ordersRepository.save(OrderMapper.toOrderEntity(orderResponseDto));
        return OrderMapper.toOrderDto(order);
    }
}
