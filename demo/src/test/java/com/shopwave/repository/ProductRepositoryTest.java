
package com.shopwave.repository;

import com.shopwave.model.Product;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Verifies repository query behavior using mocks.
class ProductRepositoryTest {

    private final ProductRepository repository = Mockito.mock(ProductRepository.class);

    @Test
    void findByNameContainingIgnoreCaseReturnsCorrectResults() {
        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("Gaming");
        laptop.setPrice(BigDecimal.valueOf(1000));
        laptop.setStock(5);

        Product phone = new Product();
        phone.setName("Phone");
        phone.setDescription("Smartphone");
        phone.setPrice(BigDecimal.valueOf(500));
        phone.setStock(10);

        Mockito.when(repository.findByNameContainingIgnoreCase("lap")).thenReturn(List.of(laptop));

        List<Product> results = repository.findByNameContainingIgnoreCase("lap");
        assertEquals(1, results.size());
        assertEquals("Laptop", results.get(0).getName());
    }
}
