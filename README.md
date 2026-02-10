# Employee Payroll Service — Spring Boot REST API

## Project Overview

Employee Payroll Service is a Spring Boot REST API application that provides CRUD operations for managing employee payroll records.
The project follows a clean layered architecture (Controller → Service → Repository → Model) and demonstrates production-style REST practices including validation, structured exception handling, and proper HTTP status responses.

This project is designed for backend learning, interview preparation, and foundational enterprise application structure.

---

## Architecture Pattern

Layered Architecture:

```
Controller → Service → Repository → Database
```

Responsibilities:

* Controller — handles HTTP requests/responses
* Service — business logic
* Repository — database interaction
* Model — entity mapping
* Exception — centralized error handling

---

## Tech Stack

| Technology         | Version |
| ------------------ | ------- |
| Java               | 21      |
| Spring Boot        | 3.x     |
| Spring Web         | 3.x     |
| Spring Data JPA    | 3.x     |
| PostgreSQL         | 14+     |
| Hibernate          | 6.x     |
| Lombok             | Latest  |
| Jakarta Validation | 3.x     |
| Maven              | 3.x     |

---

## Key Dependencies

```
spring-boot-starter-web
spring-boot-starter-data-jpa
spring-boot-starter-validation
postgresql
lombok
spring-boot-devtools (optional)
```

---

## Complete Project Structure

```
com.example.employeepayroll
│
├── controller
│   └── EmployeeController.java
│
├── service
│   └── EmployeeService.java
│
├── repository
│   └── EmployeeRepository.java
│
├── model
│   └── Employee.java
│
├── exception
│   ├── ResourceNotFoundException.java
│   └── GlobalExceptionHandler.java
│
└── EmployeePayrollApplication.java
```

---

## Application Configuration

File:

```
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/employeedb
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080
```

---

## Database Setup

Create database:

```sql
CREATE DATABASE employeedb;
```

Hibernate auto-creates tables because:

```
spring.jpa.hibernate.ddl-auto=update
```

---

## Database Schema

### employees table

| Column | Type    | Constraints        |
| ------ | ------- | ------------------ |
| id     | BIGINT  | PK, Auto Increment |
| name   | VARCHAR | NOT NULL           |
| salary | DOUBLE  | NOT NULL           |

Validation rules enforced at API level:

* name → required, 2–50 chars
* salary → positive number

---

## Running the Application

### Using Maven

```bash
mvn spring-boot:run
```

### Using IDE

Run:

```
EmployeePayrollApplication.java
```

Server starts at:

```
http://localhost:9090
```

---

## Base API Path

```
/employee
```

---

## API Endpoints

### Get All Employees

```
GET /employee/
```

Response: 200 OK

---

### Get Employee By ID

```
GET /employee/get/{id}
```

Response:

* 200 OK
* 404 Not Found

---

### Create Employee

```
POST /employee/create
```

Body:

```json
{
  "name": "Lisa",
  "salary": 5000
}
```

Response:

* 201 Created
* 400 Validation Error

---

### Update Employee

```
PUT /employee/update/{id}
```

Response:

* 200 OK
* 404 Not Found

---

### Delete Employee

```
DELETE /employee/delete/{id}
```

Response:

* 200 OK
* 404 Not Found

---

## CURL Test Examples

Create:

```bash
curl -X POST localhost:8080/employee/create \
-H "Content-Type: application/json" \
-d '{"name":"Lisa","salary":5000}'
```

Get all:

```bash
curl localhost:8080/employee/
```

Update:

```bash
curl -X PUT localhost:8080/employee/update/1 \
-H "Content-Type: application/json" \
-d '{"name":"Lisa2","salary":8000}'
```

Delete:

```bash
curl -X DELETE localhost:8080/employee/delete/1
```

---

## Validation Handling

Implemented using Jakarta Validation:

```
@NotBlank
@Size
@NotNull
@Positive
```

Invalid requests return structured error map with **400 Bad Request**.

---

## Exception Handling

Global exception handler ensures consistent responses:

| Exception                 | HTTP Status |
| ------------------------- | ----------- |
| ResourceNotFoundException | 404         |
| Validation Errors         | 400         |

---

## Features

* Clean layered architecture
* PostgreSQL integration
* RESTful endpoints
* Proper HTTP status codes
* Input validation
* Global exception handling
* Lombok usage
* Production-style controller responses

---

## Possible Extensions

* DTO layer
* Swagger/OpenAPI docs
* Pagination & filtering
* Authentication & authorization
* Audit fields
* Soft delete

---

## Author

Ashutosh Mishra

---
