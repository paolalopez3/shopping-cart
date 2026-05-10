package org.pruebatecnica.orderservice.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDto {
    private UUID id;
    private int productId;
    private String productTitle;
    private float productPrice;
    private int quantity;
}