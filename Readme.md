# 🏥 Hospital Management System (Spring Boot)

A backend REST API for managing hospital operations such as patients, doctors, and appointments.
This project is built using **Spring Boot**, **Spring Data JPA**, and **MySQL**, following a clean layered architecture.

---

## 🚀 Features

* 👤 Patient Management (Create, Update, Delete, Get)
* 👨‍⚕️ Doctor Management
* 📅 Appointment Booking System
* 🔄 DTO Pattern for API responses
* 🗺️ Entity–DTO Mapping using Mapper classes
* ⚠️ Global Exception Handling
* ✅ Request Validation using Jakarta Validation
* 📄 Swagger API Documentation
* 🧱 Clean Layered Architecture (Controller → Service → Repository)

---

## 🛠️ Tech Stack

* **Java 21**
* **Spring Boot**
* **Spring Data JPA**
* **Hibernate**
* **MySQL**
* **Lombok**
* **Swagger / OpenAPI**
* **Maven**

---

## 📂 Project Structure

```
hospital-management
│
├── controller
│   ├── PatientController
│   ├── DoctorController
│   └── AppointmentController
│
├── service
│   ├── PatientService
│   ├── DoctorService
│   └── AppointmentService
│
├── service.impl
│
├── repository
│
├── entity
│   ├── Patient
│   ├── Doctor
│   └── Appointment
│
├── dto
│
├── mapper
│
├── exception
│   ├── ResourceNotFoundException
│   └── GlobalExceptionHandler
│
└── config
```

---

## 📊 Database Design

### Patient

* id
* name
* email
* city
* bloodGroup
* dateOfBirth

### Doctor

* id
* name
* specialization
* email
* availableFrom

### Appointment

* appointmentId
* appointmentDate
* patient_id
* doctor_id

**Relationships**

* One Patient → Many Appointments
* One Doctor → Many Appointments

---

## 🔗 API Endpoints

### Patient APIs

| Method | Endpoint              | Description       |
| ------ | --------------------- | ----------------- |
| POST   | /patient/save         | Create patient    |
| PUT    | /patient/update/{id}  | Update patient    |
| DELETE | /patient/delete/{id}  | Delete patient    |
| GET    | /patient/getById/{id} | Get patient by id |
| GET    | /patient              | Get all patients  |

---

### Doctor APIs

| Method | Endpoint              | Description     |
| ------ | --------------------- | --------------- |
| POST   | /doctors/create       | Create doctor   |
| PUT    | /doctors/update/{id}  | Update doctor   |
| DELETE | /doctors/delete/{id}  | Delete doctor   |
| GET    | /doctors/getById/{id} | Get doctor      |
| GET    | /doctors/getAll       | Get all doctors |

---

### Appointment APIs

| Method | Endpoint                 | Description          |
| ------ | ------------------------ | -------------------- |
| POST   | /create                  | Create appointment   |
| PUT    | /update/{appointmentId}  | Update appointment   |
| DELETE | /delete/{appointmentId}  | Delete appointment   |
| GET    | /getById/{appointmentId} | Get appointment      |
| GET    | /getAll                  | Get all appointments |

---

## 📖 Swagger API Documentation

After running the application, open:

```
http://localhost:8080/swagger-ui/index.html
```

Swagger provides an interactive UI to test all APIs.

---

## ▶️ How to Run the Project

1. Clone the repository

```
git clone https://github.com/your-username/hospital-management.git
```

2. Open the project in **Spring Tool Suite / IntelliJ / Eclipse**

3. Configure database in `application.properties`

```
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=root
spring.datasource.password=yourpassword
```

4. Run the application

```
HospitalManagementApplication.java
```

---

## 📌 Learning Highlights

This project demonstrates:

* REST API development using Spring Boot
* DTO pattern for data transfer
* Exception handling in Spring Boot
* Entity relationships using JPA
* API documentation with Swagger

---

## 👨‍💻 Author

**Altamash Khan**

Backend Developer (Java | Spring Boot)
