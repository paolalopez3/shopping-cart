package org.pruebatecnica.productservice.controller;

import lombok.RequiredArgsConstructor;
import org.pruebatecnica.productservice.dto.response.ProductResponseDto;
import org.pruebatecnica.productservice.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }
}
