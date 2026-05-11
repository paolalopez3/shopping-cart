package org.pruebatecnica.paymentservice.service;

import org.pruebatecnica.paymentservice.dto.request.PaymentRequestDto;
import org.pruebatecnica.paymentservice.dto.response.PaymentResponseDto;

import java.util.List;
import java.util.UUID;

public interface PaymentService {
    PaymentResponseDto makePayment(PaymentRequestDto paymentRequestDto);
    PaymentResponseDto getPaymentById(UUID id);
    List<PaymentResponseDto> getAllPayments();
}
