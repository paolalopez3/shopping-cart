package org.pruebatecnica.productservice.service;

import lombok.RequiredArgsConstructor;
import org.pruebatecnica.productservice.client.FakeStoreClient;
import org.pruebatecnica.productservice.dto.response.ProductResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final FakeStoreClient fakeStoreClient;

    public List<ProductResponseDto> getAllProducts() {
        return fakeStoreClient.getAllProducts();
    }

    public ProductResponseDto getProductById(int id) {
        return fakeStoreClient.getProductById(id);
    }
}
