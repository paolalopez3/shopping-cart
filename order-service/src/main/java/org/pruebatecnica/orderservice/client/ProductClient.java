package org.pruebatecnica.orderservice.client;

import lombok.RequiredArgsConstructor;
import org.pruebatecnica.orderservice.dto.response.ProductResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class ProductClient {
    private final WebClient webClient;

    public ProductResponseDto getProductById(int id) {
        return webClient.get()
                .uri("/products/" + id)
                .retrieve()
                .bodyToMono(ProductResponseDto.class)
                .block();
    }
}
