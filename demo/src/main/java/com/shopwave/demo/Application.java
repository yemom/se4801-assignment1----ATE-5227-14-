// ATE/5227/14
package com.shopwave.demo;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.shopwave")
@EntityScan(basePackages = "com.shopwave.model")
@EnableJpaRepositories(basePackages = "com.shopwave.repository")
// Entry point for the ShopWave Spring Boot application.
public class Application {

	// Starts the application and loads all configured Spring components.
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
