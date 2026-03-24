// ATE/5227/14
package com.shopwave.service;

import com.shopwave.dto.CreateProductRequest;
import com.shopwave.dto.ProductDTO;
import com.shopwave.exception.ProductNotFoundException;
import com.shopwave.model.Product;
import com.shopwave.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
// Contains the main business logic for products.
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // Creates and stores a new product.
    public ProductDTO createProduct(CreateProductRequest request) {
        Product product = ProductMapper.fromCreateRequest(request);
        return ProductMapper.toDto(repository.save(product));
    }

    // Reads all products using pagination.
    @Transactional(readOnly = true)
    public Page<ProductDTO> getAllProducts(Pageable pageable) {
        return repository.findAll(pageable).map(ProductMapper::toDto);
    }

    // Reads one product or throws when the id does not exist.
    @Transactional(readOnly = true)
    public ProductDTO getProductById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return ProductMapper.toDto(product);
    }

    // Filters by keyword first, then optional max price.
    @Transactional(readOnly = true)
    public List<ProductDTO> searchProducts(String keyword, BigDecimal maxPrice) {
        String safeKeyword = keyword == null ? "" : keyword;
        return repository.findByNameContainingIgnoreCase(safeKeyword).stream()
                .filter(product -> maxPrice == null || product.getPrice().compareTo(maxPrice) <= 0)
                .map(ProductMapper::toDto)
                .toList();
    }

    // Updates product stock and prevents negative stock.
    public ProductDTO updateStock(Long id, int delta) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        int newStock = product.getStock() + delta;
        if (newStock < 0) {
            throw new IllegalArgumentException("Stock cannot go negative");
        }
        product.setStock(newStock);
        return ProductMapper.toDto(repository.save(product));
    }
}