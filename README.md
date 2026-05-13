# 🚀 Employee Access System

A containerized microservices-based backend system for managing employees and access requests using Spring Boot, PostgreSQL, Docker, and REST API communication.

---

# 📌 Overview

Employee Access System is a backend application designed to manage employees and their application access requests within an organization.

This project demonstrates:

- Microservices architecture
- REST API communication between services
- Docker containerization
- Layered architecture implementation
- Java Stream usage
- Native SQL Query implementation
- Spring IoC & Dependency Injection

The system is split into two independent services:

- **employee-service**
- **access-service**

Both services communicate through REST APIs and are orchestrated using Docker Compose.

---

# 🧰 Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Web
- Spring Validation
- PostgreSQL
- Docker & Docker Compose
- Maven
- SpringDoc OpenAPI (Swagger UI)
- REST Template
- Lombok

---

# 🏗 Microservices Architecture

```text
Client
   ↓
access-service (8091)
   ↓ REST API Communication
employee-service (8090)
   ↓
PostgreSQL

📦 Services
Service	Port	    Description
employee-service	8090	Manage employee data
access-service	    8091	Manage access requests
PostgreSQL	        5432	Database
🧠 Architecture Pattern

Each service follows a layered architecture:

Controller → Service → Repository → Database
Layer Responsibilities
Controller → Handle HTTP requests and responses
Service → Business logic implementation
Repository → Database access using Spring Data JPA
Database → PostgreSQL persistent storage

🔥 Features
Employee Service
Create employee
Get employee list
Get employee by ID
Access Service
Create access request
Approve access request
Reject access request
Get pending requests
Request summary using Java Stream
Native SQL Query summary
REST communication with employee-service

🐳 Running with Docker
Make sure Docker and Docker Compose are installed.

Clone Repository
git clone https://github.com/Zenal69/employee-access-system.git
cd employee-access-system

Build Services
cd employee-service
mvn clean package

cd ../access-service
mvn clean package
Run Docker Compose
docker compose up --build
Stop Application
docker compose down

⚙️ Docker Environment Variables
SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/employee_access_system
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres

💻 Running Locally (Without Docker)
Create Database
CREATE DATABASE employee_access_system;
Configure application.properties
employee-service
server.port=8090

spring.datasource.url=jdbc:postgresql://localhost:5432/employee_access_system
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
access-service
server.port=8091

spring.datasource.url=jdbc:postgresql://localhost:5432/employee_access_system
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

📡 API Endpoints
Employee Service
Method	Endpoint	    Description
GET	/employees	        Get all employees
GET	/employees/{id}	    Get employee by ID
POST	/employees	    Create employee

Access Service
Method	Endpoint	            Description
GET	/requests	                Get all requests
POST	/requests	            Create request
PUT	/requests/{id}/approve	    Approve request
PUT	/requests/{id}/reject	    Reject request
GET	/requests/pending	        Get pending requests
GET	/requests/summary/status	Request summary
GET	/requests/employee/{id}	    Get employee via REST communication

📖 Swagger UI
Employee Service
http://localhost:8090/swagger-ui/index.html
Access Service
http://localhost:8091/swagger-ui/index.html

🧪 Technical Highlights
Spring IoC & Dependency Injection
Java Stream API usage
Native SQL Query implementation
RESTful API design
Dockerized microservices architecture
Inter-service communication
Layered architecture
PostgreSQL integration
Swagger API documentation

🚀 Future Improvements
JWT Authentication & Authorization
API Gateway
Service Discovery
Separate database per service
Kafka/RabbitMQ event-driven communication
CI/CD with GitHub Actions
Cloud deployment (AWS / Railway / Render)

👨‍💻 Author
Developed by Zaenal