# To-Do List API (Java)

Simple REST API for managing tasks and users, built with Java and Spring Boot.

## 📌 Overview

This project is a basic implementation of a To-Do List system with CRUD operations for tasks and users. It was created to practice core backend concepts such as REST APIs, HTTP methods, DTOs, and database integration.

## 🚀 Technologies

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* Maven
* MySQL 

## 📂 Endpoints

### 👤 Users

| Method | Endpoint    | Description     |
| ------ | ----------- | --------------- |
| GET    | /users/{id}      | Get user by id |
| GET    | /users     | Get users |
| POST   | /users      | Create user  |



### ✅ Tasks

| Method | Endpoint   | Description     |
| ------ | ---------- | --------------- |
| GET    | /tasks/{id}  | Get task by id  |
| POST    | /tasks      | Create a new task   |


## 📦 Project Structure

* `controller` → Handles HTTP requests
* `service` → Business logic layer
* `repository` → Data access layer (JPA)
* `model` → Entity classes
* `dto` → Data transfer objects

## ⚙️ How to Run

1. Clone the repository:

```
git clone https://github.com/your-username/your-repo.git
```

2. Navigate to the project folder:

```
cd your-repo
```

3. Run the application:

```
./mvnw spring-boot:run
```

The API will be available at:

```
http://localhost:8080
```

## 🧪 Testing

You can test the endpoints using tools like Postman or Insomnia.

## 🎯 Purpose

This project was created for learning purposes, focusing on:

* REST API design
* Create and Read operations
* Layered architecture (Controller, Service, Repository)
* Integration with relational databases

## 📄 License

This project is open-source and available for study and practice.
