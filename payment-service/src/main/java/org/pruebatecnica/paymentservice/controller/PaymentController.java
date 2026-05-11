package org.pruebatecnica.paymentservice.controller;

import lombok.RequiredArgsConstructor;
import org.pruebatecnica.paymentservice.dto.request.PaymentRequestDto;
import org.pruebatecnica.paymentservice.dto.response.PaymentResponseDto;
import org.pruebatecnica.paymentservice.repository.PaymentRepository;
import org.pruebatecnica.paymentservice.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponseDto> processPayment(@RequestBody PaymentRequestDto request) {
        PaymentResponseDto payment = paymentService.makePayment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDto> getPaymentById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.getPaymentById(id));
    }
}
