package org.pruebatecnica.orderservice.mapper;

import org.pruebatecnica.orderservice.dto.request.CustomerRequestDto;
import org.pruebatecnica.orderservice.dto.request.OrderDetailRequestDto;
import org.pruebatecnica.orderservice.dto.request.OrderRequestDto;
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
    public OrderResponseDto toOrderResponseDto(Order order) {
        return OrderResponseDto.builder()
                .id(order.getId())
                .customer(toCustomerResponseDto(order.getCustomer()))
                .orderDetailDtos(order.getOrderDetails().stream()
                        .map(this::toOrderDetailResponseDto)
                        .toList())
                .totalAmount(order.getTotalAmount())
                .status(order.getStatus().toString())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();
    }

    public Order toOrder(OrderRequestDto orderRequestDto) {
        return Order.builder()
                .customer(toCustomer(orderRequestDto.getCustomer()))
                .orderDetails(orderRequestDto.getOrderDetailDtos().stream()
                        .map(this::toOrderDetail)
                        .toList())
                .totalAmount(0.0)
                .status(OrderStatus.valueOf(orderRequestDto.getStatus()))
                .build();
    }

    public OrderDetailResponseDto toOrderDetailResponseDto(OrderDetail orderDetail) {
        return OrderDetailResponseDto.builder()
                .id(orderDetail.getId())
                .productId(orderDetail.getProductId())
                .productTitle(orderDetail.getProductTitle())
                .productPrice(orderDetail.getProductPrice())
                .quantity(orderDetail.getQuantity())
                .build();
    }

    public OrderDetail toOrderDetail(OrderDetailRequestDto orderDetailDto) {
        return OrderDetail.builder()
                .productId(orderDetailDto.getProductId())
                .quantity(orderDetailDto.getQuantity())
                .build();
    }

    public CustomerResponseDto toCustomerResponseDto(Customer customer) {
        return CustomerResponseDto.builder()
                .id(customer.getId())
                .fullName(customer.getFullName())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .build();
    }

    public Customer toCustomer(CustomerRequestDto customerDto) {
        return Customer.builder()
                .fullName(customerDto.getFullName())
                .email(customerDto.getEmail())
                .address(customerDto.getAddress())
                .build();
    }
}
