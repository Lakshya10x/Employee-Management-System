# README: Employee Management Application

### Introduction
This Spring Boot application provides a RESTful API for managing employee information using a MySQL database. It leverages Data JPA for data access and custom exception handling for a robust and error-proof experience.

### Technologies Used
* **Spring Boot:** A framework for building Spring-based applications.
* **MySQL:** A popular relational database management system.
* **Data JPA:** A Java persistence API that provides an abstraction layer over JPA.

### Prerequisites
* Java Development Kit (JDK) 8 or later
* Spring Boot CLI or a build tool like Maven or Gradle
* MySQL database and driver

### Installation and Setup
1. **Clone the repository:**
   ```bash
   git clone [https://github.com/your-username/employee-management-app](https://github.com/your-username/employee-management-app)
   ```
2. **Set up database:**
* Create a MySQL database named employee_db.
* Import the necessary schema and data from the schema.sql file.
3. **Configure application properties:**
* Open the application.properties file and adjust the database connection details.
4. **Build and run:**
* Use Maven or Gradle to build the application.
* Run the built JAR file or use Spring Boot DevTools for hot reloading.
---
  ## API Endpoints

### Employee CRUD Operations

- **GET /employees**: Retrieve a list of all employees.
- **GET /employees/{id}**: Retrieve a specific employee by ID.
- **POST /employees**: Create a new employee.
- **PUT /employees/{id}**: Update an existing employee.
- **DELETE /employees/{id}**: Delete an employee.
---
## Custom Exception Handling

Custom exception handling is a crucial aspect of the Employee Management Application, designed to manage and communicate errors effectively. By using custom exceptions, the application ensures that errors are handled gracefully and that users receive clear, meaningful feedback.

### Overview

1. **Custom Exception Classes:** The application uses custom exception classes, such as `BusinessException` and `ControllerException`, to handle various error scenarios. `BusinessException` is used for business logic errors, while `ControllerException` provides a structured way to communicate these errors through the API.

2. **Service Layer Handling:** In the service layer, methods handle exceptions that may arise during operations. For example, if an employee's name is missing, a `BusinessException` with a specific error code is thrown. This approach separates business logic errors from other types of errors, allowing for more precise error handling.

3. **Controller Layer Handling:** The controller layer catches exceptions thrown by the service layer and translates them into appropriate HTTP responses. For instance, if a `BusinessException` is thrown, the controller creates a `ControllerException` with relevant details and returns it with a suitable HTTP status, such as `BAD_REQUEST`. This ensures that the API responses are both informative and appropriate to the error context.

4. **Consistent Error Responses:** By utilizing custom exceptions, the application provides consistent error responses across different endpoints. Each error response includes an error code and a descriptive message, making it easier for users to understand the nature of the problem and take corrective actions.

5. **Error Handling Example:** When adding a new employee, if an error occurs, the controller handles it by returning a `ControllerException` with a corresponding HTTP status code. This could include errors such as invalid input or internal server issues, with specific codes like `611`, `612`, `613`, and `614` indicating different types of problems.

Custom exception handling enhances the robustness of the application by ensuring that errors are managed in a structured manner and that users receive clear and actionable feedback.
