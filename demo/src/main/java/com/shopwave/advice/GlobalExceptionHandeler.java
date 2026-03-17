package com.shopwave.advice;

import com.shopwave.exception.ProductNotFoundException;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
// Converts common exceptions into friendly API error responses.
public class GlobalExceptionHandeler {

	// Handles missing product errors.
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleNotFound(ProductNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(Map.of("error", "Not Found", "message", exception.getMessage()));
	}

	// Handles invalid request state errors.
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Map<String, String>> handleBadRequest(IllegalArgumentException exception) {
		return ResponseEntity.badRequest().body(Map.of("error", "Bad Request", "message", exception.getMessage()));
	}
}
