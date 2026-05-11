package org.pruebatecnica.orderservice.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequestDto {
    private String fullName;
    private String email;
    private String address;
}
