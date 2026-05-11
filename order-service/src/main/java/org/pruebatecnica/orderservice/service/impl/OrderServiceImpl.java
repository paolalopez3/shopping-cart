package org.pruebatecnica.orderservice.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.pruebatecnica.orderservice.client.ProductClient;
import org.pruebatecnica.orderservice.dto.request.OrderRequestDto;
import org.pruebatecnica.orderservice.dto.response.OrderResponseDto;
import org.pruebatecnica.orderservice.dto.response.ProductResponseDto;
import org.pruebatecnica.orderservice.entity.Order;
import org.pruebatecnica.orderservice.entity.OrderDetail;
import org.pruebatecnica.orderservice.exception.OrderNotFoundException;
import org.pruebatecnica.orderservice.mapper.OrderMapper;
import org.pruebatecnica.orderservice.repository.OrderRepository;
import org.pruebatecnica.orderservice.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductClient productClient;

    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        Order order = orderMapper.toOrder(orderRequestDto);
        double total = 0;
        for (OrderDetail detail : order.getOrderDetails()) {
            ProductResponseDto product =
                    productClient.getProductById(
                            detail.getProductId()
                    );
            detail.setProductTitle(product.getTitle());
            detail.setProductPrice(product.getPrice());
            double subtotal =
                    product.getPrice() * detail.getQuantity();
            total += subtotal;
            detail.setOrder(order);
        }

        order.setTotalAmount(total);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toOrderResponseDto(savedOrder);
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toOrderResponseDto)
                .toList();
    }

    @Override
    public OrderResponseDto getOrderById(UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new OrderNotFoundException(
                                "Order not found")

        );
        return orderMapper.toOrderResponseDto(order);
    }

    @Override
    public OrderResponseDto updateOrder(UUID id, OrderRequestDto orderRequestDto) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() ->
                        new OrderNotFoundException("Order not found")
                );
        existingOrder.setCustomer(
                orderMapper.toCustomer(orderRequestDto.getCustomer())
        );
        existingOrder.getOrderDetails().clear();
        double total = 0;
        for (OrderDetail detail :
                orderRequestDto.getOrderDetailDtos()
                        .stream()
                        .map(orderMapper::toOrderDetail)
                        .toList()) {
            ProductResponseDto product =
                    productClient.getProductById(detail.getProductId());
            detail.setProductTitle(product.getTitle());
            detail.setProductPrice(product.getPrice());
            double subtotal = product.getPrice() * detail.getQuantity();
            total += subtotal;
            detail.setOrder(existingOrder);
            existingOrder.getOrderDetails().add(detail);
        }
        existingOrder.setTotalAmount(total);

        Order updatedOrder = orderRepository.save(existingOrder);
        return orderMapper.toOrderResponseDto(updatedOrder);
    }

    @Override
    public void deleteOrder(UUID id) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() ->
                        new OrderNotFoundException(
                                "Order not found"
                        )
                );
        orderRepository.delete(existingOrder);
    }
}
