package com.shopwave.exception;

// Thrown when a requested product id does not exist.
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Product not found with id: " + id);
    }
}
