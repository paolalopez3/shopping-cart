package org.pruebatecnica.orderservice.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDto {
    private int id;
    private String title;
    private float price;
}
