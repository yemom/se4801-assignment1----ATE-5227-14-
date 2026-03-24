// ATE/5227/14
package com.shopwave.service;

import com.shopwave.dto.CreateProductRequest;
import com.shopwave.dto.ProductDTO;
import com.shopwave.model.Product;

// Converts data between API request/response objects and entity objects.
public final class ProductMapper {

    private ProductMapper() {
    }

    // Converts Product entity to ProductDTO.
    public static ProductDTO toDto(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getDescription());
    }

    // Builds a Product entity from create request payload.
    public static Product fromCreateRequest(CreateProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        return product;
    }
}
