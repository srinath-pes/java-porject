# Vechile Rental System

Web-based Vehicle Rental application built with Spring Boot MVC, Thymeleaf, JPA, and a local H2 database for easy startup. MySQL support is still available through a separate profile.

## Team Details
- Srinath V - PES2UG24CS824
- Chandrasehkar - PES2UG23CS144

## Features
- Vehicle management (add, view, update)
- Customer management (add, view, update)
- Booking creation and tracking
- MVC layered architecture
- Database integration with Spring Data JPA

## Tech Stack
- Java 17
- Spring Boot 3.3.5
- Spring MVC
- Thymeleaf
- Spring Data JPA
- H2 Database
- MySQL Connector/J
- Maven

## Project Structure
- src/main/java/com/example/vehiclerental/controller - Controllers
- src/main/java/com/example/vehiclerental/service - Services
- src/main/java/com/example/vehiclerental/repository - Repositories
- src/main/java/com/example/vehiclerental/entity - Entities
- src/main/resources/templates - Thymeleaf pages
- src/main/resources/static/css - Styling

## Prerequisites
- Java 17 installed
- Maven installed

## Database Setup
The project runs by default with H2 in-memory database, so no manual database setup is required for a quick start.

If you want to use MySQL instead:
1. Create the database:
   ```sql
   CREATE DATABASE vehicle_rental_db;
   ```
2. Run with the MySQL profile:
   ```bash
   mvn clean spring-boot:run -Dspring-boot.run.profiles=mysql
   ```

## Run the Project
1. Open terminal in project root: vehicle-rental-mvc
2. Run:
   ```bash
   mvn clean spring-boot:run
   ```
3. Open in browser:
   http://localhost:8080

Optional H2 console:
- http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:vehicle_rental_db
- User: sa
- Password: empty

## Build and Test
Run:
```bash
mvn clean test
```

## Notes
- The default setup uses H2 so the app can run without external services.
- MySQL can still be used by activating the mysql profile.
