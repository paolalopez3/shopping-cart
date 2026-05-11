package org.pruebatecnica.orderservice.mapper;

import org.pruebatecnica.orderservice.dto.CustomerDto;
import org.pruebatecnica.orderservice.dto.OrderDetailDto;
import org.pruebatecnica.orderservice.dto.OrderDto;
import org.pruebatecnica.orderservice.entity.Customer;
import org.pruebatecnica.orderservice.entity.Order;
import org.pruebatecnica.orderservice.entity.OrderDetail;
import org.pruebatecnica.orderservice.entity.enums.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDto toOrderDto(Order order) {
        return OrderDto.builder()
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

    public Order toOrder(OrderDto orderDto) {
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

    public OrderDetailDto toOrderDetailDto(OrderDetail orderDetail) {
        return OrderDetailDto.builder()
                .id(orderDetail.getId())
                .productId(orderDetail.getProductId())
                .productTitle(orderDetail.getProductTitle())
                .productPrice(orderDetail.getProductPrice())
                .quantity(orderDetail.getQuantity())
                .build();
    }

    public OrderDetail toOrderDetail(OrderDetailDto orderDetailDto) {
        return OrderDetail.builder()
                .id(orderDetailDto.getId())
                .productId(orderDetailDto.getProductId())
                .productTitle(orderDetailDto.getProductTitle())
                .productPrice(orderDetailDto.getProductPrice())
                .quantity(orderDetailDto.getQuantity())
                .build();
    }

    public CustomerDto toCustomerDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .fullName(customer.getFullName())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .build();
    }

    public Customer toCustomer(CustomerDto customerDto) {
        return Customer.builder()
                .id(customerDto.getId())
                .fullName(customerDto.getFullName())
                .email(customerDto.getEmail())
                .address(customerDto.getAddress())
                .build();
    }
}
