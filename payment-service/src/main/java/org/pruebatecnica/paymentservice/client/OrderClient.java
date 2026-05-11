package org.pruebatecnica.paymentservice.client;

import lombok.RequiredArgsConstructor;
import org.pruebatecnica.paymentservice.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderClient {
    private final WebClient webClient;

    public OrderResponseDto getOrderById(UUID id) {
        return webClient.get()
                .uri("/api/orders/" + id)
                .retrieve()
                .bodyToMono(OrderResponseDto.class)
                .block();
    }
}
