package com.mapstructs_demo.controller;


import com.mapstructs_demo.dto.OrderResponseDto;
import com.mapstructs_demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/orders")
@RestController
@RequiredArgsConstructor
public class OrderController {


    private final OrderService orderService;


    @PostMapping
    ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderResponseDto orderResponseDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderService.createOrder(orderResponseDto));
    }
}
