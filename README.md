# named-se4801-assignment1--ATE-5227-14-

   Name                 ID
Esrom basazinaw   ATE/5227/14

Project Description

This project is a demo application developed for the SE4801 assignment.
The project demonstrates a basic enterprise application structure and includes source code and automated tests.

The application is built using Java and Maven, following a standard project structure.

se4801-assignment1-<ATE/5227/14>/
├── pom.xml
├── README.md
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── shopwave/
│ │ │ ├── model/ # Domain entities
│ │ │ │ ├── Category.java
│ │ │ │ ├── Product.java
│ │ │ │ ├── Order.java
│ │ │ │ └── OrderItem.java
│ │ │ ├── repository/ # JPA repositories
│ │ │ │ └── ProductRepository.java
│ │ │ ├── service/ # Business logic
│ │ │ │ ├── ProductService.java
│ │ │ │ └── ProductMapper.java
│ │ │ ├── dto/ # DTOs & requests
│ │ │ │ ├── ProductDTO.java
│ │ │ │ └── CreateProductRequest.java
│ │ │ ├── controller/ # REST controllers
│ │ │ │ └── ProductController.java
│ │ │ ├── exception/ # Custom exceptions
│ │ │ │ └── ProductNotFoundException.java
│ │ │ └── advice/ # Global exception handler
│ │ │ └── GlobalExceptionHandler.java
│ │ └── resources/
│ │ ├── application.properties # Config (port, app.name)
│ │ ├── static/ # Static assets (if any)
│ └── test/
│ └── java/
│ └── com/
│ └── shopwave/
│ ├── service/
│ │ └── ProductServiceTest.java
│ ├── controller/
│ │ └── ProductControllerTest.java
│ └── repository/
│ │ └── ProductRepositoryTest.java
| └── demo
| └──ApplicationTest.java


How to build

From the workspace root
navigate to the demo folder
1. cd demo
2. mvn clean package


How to Run

From the workspace root 

1. mvn spring- boot:run

the application with start on 
http://localhost:8080

Open

- http// localhost8080/
- http// localhost8080/ api/ products

How to Run Tests

To run the automated tests:

1. mvn test

this command executes all unit test


Project Location 

The Spring Boot design is inside the rally brochure. 

How to build

From the workspace root 

1. cd rally 
2../ mvnw clean package 

Windows PowerShell indispensable 

1. Set- position rally 
2.. mvnw.cmd clean package 

How to Run 

From the rally brochure 

1../ mvnw spring- bootrun 

Windows PowerShell indispensable 

1.. mvnw.cmd spring- bootrun 

The API'll start on harborage 8080. 

Open 

- http// localhost8080/ 
- http// localhost8080/ api/ products 

How to Run Tests 

From the rally brochure 

1../ mvnw test 

Windows PowerShell indispensable 

1.. mvnw.cmd test 

Quiet mode( lower log affair) 

1../ mvnw- q test 



