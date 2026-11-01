# Student Internship Record Management - Backend

Java Spring Boot backend service for managing student internship applications with MySQL.

## 🛠️ Tech Stack
- **Language**: Java 17+
- **Framework**: Spring Boot 3.3.5 (Spring Web, Spring Data JPA, Hibernate, Jakarta Validation)
- **Database**: MySQL 8.x
- **Build Tool**: Apache Maven

## 📋 REST APIs
- `GET /api/applications` - Retrieve all applications (ordered newest first)
- `GET /api/applications/{id}` - Retrieve a single application by ID
- `POST /api/applications` - Create a new internship application
- `PUT /api/applications/{id}` - Update application details or status
- `DELETE /api/applications/{id}` - Delete an application by ID

## 🚀 How to Run
1. Make sure MySQL service is running on `localhost:3306`.
2. Configure credentials in `src/main/resources/application.properties` (default: root / root).
3. Run using Maven:
   ```bash
   mvn spring-boot:run
   ```
   Or package into a JAR:
   ```bash
   mvn clean package -DskipTests
   java -jar target/student-internship-management-1.0.0.jar
   ```
4. Server starts on port `8080`.
