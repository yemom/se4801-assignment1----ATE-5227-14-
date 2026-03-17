package com.shopwave.repository;

import com.shopwave.model.Product;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

// Data access layer for Product entities.
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Finds products by category id.
    List<Product> findByCategoryId(Long categoryId);

    // Finds products that are less than or equal to a price.
    List<Product> findByPriceLessThanEqual(BigDecimal maxPrice);

    // Finds products with names containing the provided keyword.
    List<Product> findByNameContainingIgnoreCase(String keyword);

    // Returns the highest priced product if any exists.
    Optional<Product> findTopByOrderByPriceDesc();
}
