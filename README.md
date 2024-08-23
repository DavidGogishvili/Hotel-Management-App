The Hotel Management Backend is a robust Java-based application developed with Spring Boot and PostgreSQL to manage essential hotel operations. This backend system provides a comprehensive API for managing bookings, guests, rooms, and staff, facilitating efficient and scalable hotel management.

Table of Contents
Features
Technologies Used
Installation
Usage
API Documentation
Contributing
License
Contact
Features
Booking Management: Create, update, and delete bookings, with functionality to check room availability.
Guest Management: Manage guest information, including personal details and booking history.
Room Management: Track room statuses, prices, and assignments.
Staff Management: Manage staff information, roles, and schedules.
Secure API: Implements security best practices with Spring Security.
Technologies Used
Backend: Java, Spring Boot
Database: PostgreSQL
Build Tools: Gradle
APIs: RESTful APIs
Installation
To set up the Hotel Management backend locally, follow these steps:

Prerequisites
Java 17 installed
PostgreSQL installed and configured
Setup
Clone the repository:


git clone https://github.com/DavidGogishvili/hotel-management-backend.git
cd hotel-management-backend
Configure the database settings in application.properties:

properties

spring.datasource.url=jdbc:postgresql://localhost:5432/your-database
spring.datasource.username=your-username
spring.datasource.password=your-password
Build and run the backend application:


./gradlew bootRun
Usage
API Endpoints: Access the RESTful API to manage bookings, guests, rooms, and staff.
Security: Authentication and authorization are managed via Spring Security, ensuring that only authorized users can access specific endpoints.
API Documentation
API documentation can be accessed via Swagger once the application is running. Navigate to http://localhost:8080/swagger-ui.html to explore available endpoints and their usage.

Contributing
Contributions are welcome! To contribute:

Fork the repository.
Create a new branch (git checkout -b feature/your-feature).
Commit your changes (git commit -m 'Add some feature').
Push to the branch (git push origin feature/your-feature).
Open a pull request.
License
This project is licensed under the MIT License - see the LICENSE file for details.

Contact
For inquiries or feedback:

Email: davidd.gogishvili@gmail.com
LinkedIn: David Gogishvili
GitHub: DavidGogishvili
