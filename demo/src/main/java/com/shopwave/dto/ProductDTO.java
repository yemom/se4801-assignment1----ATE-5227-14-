package com.shopwave.dto;

import java.math.BigDecimal;

// Lightweight response shape returned by product endpoints.
public record ProductDTO(Long id, String name, BigDecimal price, String description) {
}
