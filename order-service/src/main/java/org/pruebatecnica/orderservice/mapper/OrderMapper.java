package org.pruebatecnica.orderservice.mapper;

import org.pruebatecnica.orderservice.dto.response.CustomerResponseDto;
import org.pruebatecnica.orderservice.dto.response.OrderDetailResponseDto;
import org.pruebatecnica.orderservice.dto.response.OrderResponseDto;
import org.pruebatecnica.orderservice.entity.Customer;
import org.pruebatecnica.orderservice.entity.Order;
import org.pruebatecnica.orderservice.entity.OrderDetail;
import org.pruebatecnica.orderservice.entity.enums.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderResponseDto toOrderDto(Order order) {
        return OrderResponseDto.builder()
                .id(order.getId())
                .customer(toCustomerDto(order.getCustomer()))
                .orderDetailDtos(order.getOrderDetails().stream()
                        .map(this::toOrderDetailDto)
                        .toList())
                .totalAmount(order.getTotalAmount())
                .status(order.getStatus().toString())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();
    }

    public Order toOrder(OrderResponseDto orderDto) {
        return Order.builder()
                .id(orderDto.getId())
                .customer(toCustomer(orderDto.getCustomer()))
                .orderDetails(orderDto.getOrderDetailDtos().stream()
                        .map(this::toOrderDetail)
                        .toList())
                .totalAmount(orderDto.getTotalAmount())
                .status(OrderStatus.valueOf(orderDto.getStatus()))
                .createdAt(orderDto.getCreatedAt())
                .updatedAt(orderDto.getUpdatedAt())
                .build();
    }

    public OrderDetailResponseDto toOrderDetailDto(OrderDetail orderDetail) {
        return OrderDetailResponseDto.builder()
                .id(orderDetail.getId())
                .productId(orderDetail.getProductId())
                .productTitle(orderDetail.getProductTitle())
                .productPrice(orderDetail.getProductPrice())
                .quantity(orderDetail.getQuantity())
                .build();
    }

    public OrderDetail toOrderDetail(OrderDetailResponseDto orderDetailDto) {
        return OrderDetail.builder()
                .id(orderDetailDto.getId())
                .productId(orderDetailDto.getProductId())
                .productTitle(orderDetailDto.getProductTitle())
                .productPrice(orderDetailDto.getProductPrice())
                .quantity(orderDetailDto.getQuantity())
                .build();
    }

    public CustomerResponseDto toCustomerDto(Customer customer) {
        return CustomerResponseDto.builder()
                .id(customer.getId())
                .fullName(customer.getFullName())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .build();
    }

    public Customer toCustomer(CustomerResponseDto customerDto) {
        return Customer.builder()
                .id(customerDto.getId())
                .fullName(customerDto.getFullName())
                .email(customerDto.getEmail())
                .address(customerDto.getAddress())
                .build();
    }
}
