package org.pruebatecnica.paymentservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.pruebatecnica.paymentservice.client.OrderClient;
import org.pruebatecnica.paymentservice.dto.request.PaymentRequestDto;
import org.pruebatecnica.paymentservice.dto.response.PaymentResponseDto;
import org.pruebatecnica.paymentservice.entity.Payment;
import org.pruebatecnica.paymentservice.entity.enums.PaymentStatus;
import org.pruebatecnica.paymentservice.exception.PaymentNotFoundException;
import org.pruebatecnica.paymentservice.mapper.PaymentMapper;
import org.pruebatecnica.paymentservice.repository.PaymentRepository;
import org.pruebatecnica.paymentservice.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final OrderClient orderClient;

    @Override
    public PaymentResponseDto makePayment(PaymentRequestDto paymentRequestDto) {
        Payment payment = Payment.builder()
                .orderId(paymentRequestDto.getOrderId())
                .paymentStatus(PaymentStatus.PENDING)
                .totalAmount(orderClient.getOrderById(paymentRequestDto.getOrderId()).getTotalAmount())
                .build();

        if (Math.random() < 0.8) {
            payment.setPaymentStatus(PaymentStatus.APPROVED);
        } else {
            payment.setPaymentStatus(PaymentStatus.REJECTED);
        }

        return paymentMapper.toPaymentResponseDto(paymentRepository.save(payment));
    }

    @Override
    public PaymentResponseDto getPaymentById(UUID id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found"));
        return paymentMapper.toPaymentResponseDto(payment);
    }

    @Override
    public List<PaymentResponseDto> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(paymentMapper::toPaymentResponseDto)
                .toList();
    }
}
