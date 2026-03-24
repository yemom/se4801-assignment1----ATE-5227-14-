
package com.shopwave.service;

import com.shopwave.dto.CreateProductRequest;
import com.shopwave.dto.ProductDTO;
import com.shopwave.exception.ProductNotFoundException;
import com.shopwave.model.Product;
import com.shopwave.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// Verifies service logic around create and not-found cases.
class ProductServiceTest {

    private final ProductRepository repository = mock(ProductRepository.class);
    private final ProductService service = new ProductService(repository);

    @Test
    void createProductHappyPath() {
        CreateProductRequest request = new CreateProductRequest();
        request.setName("Laptop");
        request.setDescription("Gaming laptop");
        request.setPrice(BigDecimal.valueOf(1200));
        request.setStock(10);

        Product saved = new Product();
        saved.setId(1L);
        saved.setName("Laptop");
        saved.setDescription("Gaming laptop");
        saved.setPrice(BigDecimal.valueOf(1200));
        saved.setStock(10);

        when(repository.save(any(Product.class))).thenReturn(saved);

        ProductDTO dto = service.createProduct(request);
        assertEquals("Laptop", dto.name());
        assertEquals(BigDecimal.valueOf(1200), dto.price());
    }

    @Test
    void getProductByIdNotFoundThrows() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(ProductNotFoundException.class, () -> service.getProductById(99L));
    }
}

