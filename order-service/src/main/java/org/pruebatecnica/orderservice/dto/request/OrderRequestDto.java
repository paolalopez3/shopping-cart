package org.pruebatecnica.orderservice.dto.request;

import lombok.*;
import org.pruebatecnica.orderservice.dto.response.CustomerResponseDto;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDto {
    private CustomerRequestDto customer;
    private List<OrderDetailRequestDto> orderDetailDtos;
    private String status;
}
