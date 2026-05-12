# 🚀 Employee Access System

A Spring Boot-based backend system for managing employee access requests, built with PostgreSQL and Docker support.

This project demonstrates a clean layered architecture, RESTful API design, and containerized deployment using Docker.

---

## 📌 Overview

Employee Access System is a backend application designed to manage employees and their access requests within an organization.

It is built using Spring Boot and follows best practices such as layered architecture and separation of concerns.

The application is fully containerized using Docker and PostgreSQL for easy setup and deployment.

---

## 🧰 Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Web
- Spring Validation
- PostgreSQL
- Docker & Docker Compose
- Maven
- SpringDoc OpenAPI (Swagger UI)

---

## 🏗 Architecture

The project follows a standard layered architecture:

Controller → Service → Repository → Database

### Layer Responsibilities:
- Controller → Handles HTTP requests and responses
- Service → Contains business logic
- Repository → Handles database operations using JPA
- Database → PostgreSQL as persistent storage

---

## 🐳 Running with Docker

Make sure Docker and Docker Compose are installed.

### Clone repository
```bash
git clone https://github.com/Zenal69/employee-access-system.git
cd employee-access-system

Run application
docker compose up --build

Stop application
docker compose down

⚙️ Services
Service	URL / Port
Spring Boot App	http://localhost:8090

PostgreSQL	localhost:5432
Swagger UI	http://localhost:8090/swagger-ui/index.html

⚙️ Environment Variables
SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/employee_access_system
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres

💻 Running Locally (Without Docker)
Create database
CREATE DATABASE employee_access_system;

application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/employee_access_system
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

Run app
mvn spring-boot:run

📡 API Endpoints
Employee
GET /api/employees → Get all employees
POST /api/employees → Create employee
Access Request
GET /api/access-requests → Get all access requests
POST /api/access-requests → Create access request

📖 Swagger UI
http://localhost:8090/swagger-ui/index.html

📌 Project Highlights
Dockerized Spring Boot application
Clean layered architecture
PostgreSQL integration with JPA
RESTful API design
Swagger documentation
Environment-based configuration
Ready for microservices migration

Future Improvements
JWT Authentication & Authorization
Role-Based Access Control (RBAC)
Microservices architecture split
CI/CD pipeline with GitHub Actions
Cloud deployment (AWS / Render / Railway)


Author
by Zaenal