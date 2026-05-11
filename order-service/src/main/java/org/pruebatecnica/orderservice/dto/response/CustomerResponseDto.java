package org.pruebatecnica.orderservice.dto.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponseDto {
    private UUID id;
    private String fullName;
    private String email;
    private String address;
}
