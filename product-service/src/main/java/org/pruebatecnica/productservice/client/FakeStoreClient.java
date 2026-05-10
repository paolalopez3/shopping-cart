package org.pruebatecnica.productservice.client;

import lombok.RequiredArgsConstructor;
import org.pruebatecnica.productservice.dto.response.ProductResponseDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FakeStoreClient {
    private final WebClient webClient;

    public List<ProductResponseDto> getAllProducts() {
        return webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ProductResponseDto>>() {})
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
