package org.pruebatecnica.paymentservice.mapper;

import org.pruebatecnica.paymentservice.dto.request.PaymentRequestDto;
import org.pruebatecnica.paymentservice.dto.response.PaymentResponseDto;
import org.pruebatecnica.paymentservice.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    public Payment toPayment(PaymentRequestDto paymentRequestDto) {
        return Payment.builder()
                .orderId(paymentRequestDto.getOrderId())
                .build();
    }

    public PaymentResponseDto toPaymentResponseDto(Payment payment) {
        return PaymentResponseDto.builder()
                .id(payment.getId())
                .orderId(payment.getOrderId())
                .totalAmount(payment.getTotalAmount())
                .paymentStatus(payment.getPaymentStatus())
                .paidAt(payment.getPaidAt())
                .updatedAt(payment.getUpdatedAt())
                .build();
    }
}
