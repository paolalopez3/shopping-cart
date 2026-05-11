package org.pruebatecnica.orderservice.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailRequestDto {
    private int productId;
    private int quantity;
}
