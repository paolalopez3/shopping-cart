package org.pruebatecnica.orderservice.service;

import org.pruebatecnica.orderservice.dto.request.OrderRequestDto;
import org.pruebatecnica.orderservice.dto.response.OrderResponseDto;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    OrderResponseDto createOrder(OrderRequestDto orderRequestDto);
    List<OrderResponseDto> getAllOrders();
    OrderResponseDto getOrderById(UUID id);
    void updateOrder(OrderRequestDto orderRequestDto);
    void deleteOrder(UUID id);
}
