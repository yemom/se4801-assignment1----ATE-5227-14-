package com.shopwave.controller;

import com.shopwave.dto.CreateProductRequest;
import com.shopwave.dto.ProductDTO;
import com.shopwave.service.ProductService;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
// Handles HTTP requests for product operations.
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // Returns products as a pageable response.
    @GetMapping
    public ResponseEntity<Page<ProductDTO>> list(Pageable pageable) {
        return ResponseEntity.ok(service.getAllProducts(pageable));
    }

    // Returns one product by id.
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    // Creates a new product from validated request data.
    @PostMapping
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody CreateProductRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(request));
    }

    // Searches products by optional keyword and max price.
    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> search(@RequestParam(required = false) String keyword,
            @RequestParam(required = false) BigDecimal maxPrice) {
        return ResponseEntity.ok(service.searchProducts(keyword, maxPrice));
    }

    // Updates stock by adding the provided delta value.
    @PatchMapping("/{id}/stock")
    public ResponseEntity<ProductDTO> updateStock(@PathVariable Long id, @RequestBody StockUpdateRequest body) {
        return ResponseEntity.ok(service.updateStock(id, body.delta()));
    }

    // Tiny request body for stock updates.
    public record StockUpdateRequest(int delta) {
    }
}
