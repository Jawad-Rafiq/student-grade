# 🎓 School Management REST API

A Spring Boot RESTful service that manages **Students**, **Courses**, **Enrollments**, and **Grades** with real-world business rules (capacity checks, prerequisites, transactional consistency, GPA computation, etc.).

---

## 🛠 Tech Stack

- **Java 17**
- **Spring Boot 3.x**
  - Spring Web (REST API)
  - Spring Data JPA (with H2 in‑memory DB)
  - Spring Validation (Hibernate Validator)
  - Spring Async (for background file import)
- **H2 Database** (in-memory)
- **Lombok** (for boilerplate reduction)
- **Springdoc OpenAPI / Swagger UI** (for API documentation)
- **Maven** (build tool)

---

## ⚙️ Setup Instructions

### Prerequisites
- Java 17+
- Maven 3.8+
- IDE (IntelliJ, Eclipse, VS Code, etc.)

### Steps
1. Clone the repository:
   git clone https://github.com/Jawad-Rafiq/student-grade.git
   cd student-grade
2. Build the project:
   mvn clean install
3. Run the application:
   mvn spring-boot:run
   The app will start on: http://localhost:8080
4. Access H2 Console (optional):
    - URL: http://localhost:8080/h2-console
    - JDBC URL: jdbc:h2:mem:schooldb
    - User: sa, Password: (blank)
5.  Access Swagger UI (API docs & tester):
    - URL: http://localhost:8080/swagger-ui.html

## 📡 API Endpoint Summary

| Method          | Endpoint                                   | Description                                                       |
| --------------- | ------------------------------------------ | ----------------------------------------------------------------- |
| **Students**    |                                            |                                                                   |
| `POST`          | `/students`                                | Create a new student                                              |
| `GET`           | `/students`                                | List students (with pagination)                                   |
| `GET`           | `/students/{id}`                           | Get student by ID                                                 |
| **Courses**     |                                            |                                                                   |
| `POST`          | `/courses`                                 | Create a new course                                               |
| `GET`           | `/courses`                                 | List courses (with pagination)                                    |
| `GET`           | `/courses/{id}`                            | Get course by ID                                                  |
| **Enrollments** |                                            |                                                                   |
| `POST`          | `/enrollments?studentId=&courseId=`        | Enroll a student in a course (validates prerequisites & capacity) |
| **Grades**      |                                            |                                                                   |
| `POST`          | `/grades?studentId=&courseId=&gradeValue=` | Record a grade (validates enrollment and course completion)       |
| **Progress**    |                                            |                                                                   |
| `GET`           | `/progress/{studentId}`                    | Fetch a student's enrollments, grades, and computed GPA           |
| **Import**      |                                            |                                                                   |
| `POST`          | `/import`                                  | Upload a file to import historical data (async)                   |
| `GET`           | `/import/{id}/status`                      | Check status of the async import                                  |
------------------------------------------------------------------------------------------------------------------------------------

## 📌 Notes
- Bean Validation is enabled on all entities (e.g. @NotBlank, @Email, @Past).
- Pagination parameters: ?page=0&size=10&sort=name
- Async file import simulates long-running processing with progress tracking.
