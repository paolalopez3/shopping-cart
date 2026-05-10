package org.pruebatecnica.productservice.service;

import lombok.RequiredArgsConstructor;
import org.pruebatecnica.productservice.client.FakeStoreClient;
import org.pruebatecnica.productservice.dto.response.ProductResponseDto;
import org.pruebatecnica.productservice.exception.ProductNotFoundException;
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
        try {
            ProductResponseDto product = fakeStoreClient.getProductById(id);
            if (product == null) {
                throw new ProductNotFoundException("Product not found");
            }
            return product;
        } catch (Exception e) {
            throw new ProductNotFoundException("Product not found");
        }
    }
}
