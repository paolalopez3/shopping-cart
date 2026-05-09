package org.pruebatecnica.productservice.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private int id;
    private String title;
    private float price;
    private String description;
    private String category;
    private String image;
}
