package org.pruebatecnica.paymentservice.dto.response;

import lombok.*;
import org.pruebatecnica.paymentservice.entity.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponseDto {
    private UUID id;
    private UUID orderId;
    private double totalAmount;
    private PaymentStatus paymentStatus;
    private LocalDateTime paidAt;
    private LocalDateTime updatedAt;
}
