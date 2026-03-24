
package com.shopwave.controller;

import com.shopwave.dto.ProductDTO;
import com.shopwave.exception.ProductNotFoundException;
import com.shopwave.service.ProductService;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Verifies controller behavior for happy and error paths.
class ProductControllerTest {

    private final ProductService service = Mockito.mock(ProductService.class);
    private final ProductController controller = new ProductController(service);

        @Test
        void getProductsReturnsPage() throws Exception {
                ProductDTO dto = new ProductDTO(1L, "Phone", BigDecimal.valueOf(500), "Smartphone");
        PageRequest pageable = PageRequest.of(0, 10);
        Mockito.when(service.getAllProducts(pageable))
                .thenReturn(new PageImpl<>(java.util.List.of(dto), pageable, 1));

        ResponseEntity<?> response = controller.list(pageable);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        PageImpl<?> page = (PageImpl<?>) response.getBody();
        ProductDTO result = (ProductDTO) page.getContent().get(0);
        assertEquals("Phone", result.name());
        }

        @Test
    void getProductNotFoundThrows() {
                Mockito.when(service.getProductById(999L))
                                .thenThrow(new ProductNotFoundException(999L));

        assertThrows(ProductNotFoundException.class, () -> controller.get(999L));
        }
}
