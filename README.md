# Product Service

## Overview
The Product Service manages the product catalog, including CRUD operations and availability checks.

## Responsibilities
- Create, update, delete products
- Fetch product details
- Manage product inventory status (basic checks)

## Technology Stack
- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL

## Running Locally
1. Clone the repository:
```bash
git clone https://github.com/aries89/productservice.git
2.	Build and run:
mvn spring-boot:run
Endpoints
•	GET /api/products - Fetch all products
•	GET /api/products/{id} - Fetch product by ID
•	POST /api/products - Create product 
•	PUT /api/products/{id} - Update product 
•	DELETE /api/products/{id} - Delete product 
Future Enhancements
•	Role based access
•	Event-driven updates to inventory and order services
