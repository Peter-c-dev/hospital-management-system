# 🏥 Hospital Management System

## 📌 Description

A Hospital Management System backend built with Spring Boot that simulates NHS-style hospital workflows.

This project demonstrates backend software engineering concepts including RESTful APIs, layered architecture, JWT authentication, database relationships, validation, exception handling, and Spring Security integration.

The system supports patient admission, doctor assignment, ward management, patient transfers, appointment scheduling, and user authentication.

**GitHub Repository**

https://github.com/Peter-c-dev/New-Hospital-management

---

## 🚀 Features

* Patient admission system
* Patient transfer between wards
* Patient status tracking (ADMITTED / DISCHARGED)
* Doctor management
* Doctor assignment during patient admission
* Ward assignment and management
* Appointment management
* User registration
* User login with JWT authentication
* RESTful API architecture
* Spring Security authentication
* H2 in-memory database
* DTO architecture
* Input validation using Jakarta Validation
* Custom exception handling
* Global exception handling with HTTP status codes
* Interactive API documentation using Swagger/OpenAPI

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* H2 Database
* Maven
* Swagger / OpenAPI
* Postman

---

## 📂 Project Structure

* Controllers
* Services
* Repositories
* DTOs
* Models
* Security
* Exception Handling
* Configuration

---

## 📚 Key Concepts Demonstrated

* Dependency Injection
* REST API Design
* Layered Architecture
* DTO Pattern
* Entity Relationships
* Spring Security
* JWT Authentication
* Validation
* Custom Exception Handling
* Repository Pattern

---

## 📊 Entity Relationships

* Ward → Patients (One-to-Many)
* Doctor → Patients (One-to-Many)
* Doctor → Appointments (One-to-Many)
* Patient → Appointments (One-to-Many)

---

## 🏗️ Architecture

### Controller Layer

Handles HTTP requests and responses through REST endpoints.

### Service Layer

Contains business logic for patients, doctors, wards, users, and appointments.

### Repository Layer

Uses Spring Data JPA repositories to interact with the database.

### Model Layer

Defines entities and relationships used throughout the application.

### DTO Layer

Separates API request and response models from internal entities.

### Security Layer

Provides Spring Security configuration and JWT authentication support.

* JWT-based authentication
* BCrypt password encryption
* Protected API endpoints

---

## 📸 Screenshots

### Patient Admitted

![Patient Admitted](01-Patient-Admitted.png)

### Get All Patients

![Get All Patients](02-Get-All-Patients.png)

### Search Patient

![Search Patient](03-Search-Patient.png)

### Get All Doctors

![Get All Doctors](04-Get-All-Doctors.png)

### Get Doctor By Id

![Get Doctor By Id](05-Get-Doctor-By-Id.png)

### Get Ward By Id

![Get Ward By Id](06-Get-Ward-By-Id.png)

### Search Ward

![Search Ward](07-Search-Ward.png)

### Doctor Not Found

![Doctor Not Found](08-Doctor-Not-Found.png)

### Project Structure

![Project Structure](09-Project-Structure.png)


---

## ▶️ Running the Project

### Clone Repository

```bash
git clone https://github.com/Peter-c-dev/New-Hospital-management.git
```

### Run Application

```bash
./gradlew bootRun
```

Or on Windows:

```bash
gradlew.bat bootRun
```

Application runs on:

```text
http://localhost:8080
```

Swagger UI:

```text
http://localhost:8080/swagger-ui.html
```

---

## 🔐 Authentication

Spring Security authentication is enabled.

The application includes custom user registration and login functionality.

Users can register accounts and authenticate using username and password.

JWT tokens are generated during login and can be used to access secured endpoints.

Passwords are encrypted using BCrypt before being stored in the database.

---

## 📡 Example API Endpoints

### Register User

```http
POST /api/users/register
```

### Login User

```http
POST /api/users/login
```

### Get All Patients

```http
GET /api/patients
```

### Admit Patient

```http
POST /api/patients/admit/{wardName}/{username}
```

### Update Patient Status

```http
PATCH /api/patients/{id}/status
```

### Discharge Patient

```http
DELETE /api/patients/{id}
```

---

## 📦 Current Project Scope

* 5 Controllers
* 5 Services
* 5 Repositories
* 5 Entities
* Multiple DTOs
* Custom Exceptions
* JWT Authentication
* Validation
* Swagger Documentation
* Spring Security

---

## 📈 Future Improvements

* PostgreSQL integration
* Docker deployment
* React frontend
* JUnit and Mockito testing
* Role-based authorization (ADMIN / DOCTOR)
* CI/CD pipeline with GitHub Actions
* Cloud deployment (AWS / Azure)

---

## 👨‍💻 Author

**Peter Cross**

Built as part of my software engineering portfolio while transitioning into backend Java development using Spring Boot and modern API design principles.