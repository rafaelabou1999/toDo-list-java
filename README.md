# To-Do List API

A simple REST API built with Java and Spring Boot to manage users and tasks.

---

## 🚀 Technologies

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- MySQL

---

## 📌 Endpoints

### 👤 Users

| Method | Endpoint | Description |
|--------|----------|------------|
| GET    | `/users` | List all users |
| POST   | `/users` | Create a new user |

---

### 📝 Tasks (by User)

| Method | Endpoint | Description |
|--------|----------|------------|
| GET    | `/users/{userId}/tasks` | Get all tasks from a user |
| GET    | `/users/tasks` | Get all tasks |
| GET    | `/users/{userId}/tasks/{status}` | Get all tasks by the status |
| POST   | `/users/{userId}/tasks` | Create a task for a user 
| PATCH    | `/users/{userId}/tasks/{id}` | Update task status |


---

## 📥 Example Requests

### Create User

```http
POST /users
  {
    "name": "Rafaela"
  }

GET /users/{userId}/tasks
	{
		"id": 1,
		"title": "Do the dishes",
		"description": "I should do the dishes",
		"userId": 2,
		"status": "DONE",
		"createdAt": "2026-05-02"
	}
```
## 📂 Project Structure
* `controller` → Handles HTTP requests
* `service` → Business logic layer
* `repository` → Data access layer (JPA)
* `model` → Entity classes
* `dto` → Data transfer objects

## ▶️ How to Run
```http
git clone https://github.com/rafaelabou1999/toDo-list-java.git
cd toDo-list-java/to-do-list
./mvnw spring-boot:run
````

## 🌐 Base URL
```http
http://localhost:8080
```

## 🎯 Purpose
This project was created to practice backend development concepts such as:
- REST APIs
- DTO pattern
- JPA relationships
- Layered architecture (Controller → Service → Repository)
