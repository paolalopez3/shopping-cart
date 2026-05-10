package org.pruebatecnica.productservice.client;

import lombok.RequiredArgsConstructor;
import org.pruebatecnica.productservice.dto.response.ProductResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class FakeStoreClient {
    private final WebClient webClient;

    public ProductResponseDto[] getAllProducts() {
        return webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToMono(ProductResponseDto[].class)
                .block();
    }

    public ProductResponseDto getProductById(int id) {
        return webClient.get()
                .uri("/products/" + id)
                .retrieve()
                .bodyToMono(ProductResponseDto.class)
                .block();
    }
}
