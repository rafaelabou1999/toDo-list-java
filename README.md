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
| POST   | `/users/{userId}/tasks` | Create a task for a user 
| PATCH    | `/users/{userId}/tasks/{taskId}` | Update task completion |


---

## 📥 Example Requests

### Create User

```http
POST /users
{
  "name": "Rafaela"
}


Create Task for User
POST /users/1/tasks
{
  "title": "Study Java",
  "description": "Practice Spring Boot",
  "completed": false
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
