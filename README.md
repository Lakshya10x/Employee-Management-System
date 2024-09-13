# Employee CRUD Application

## Overview

This project is a simple Employee CRUD application designed to manage employee records. It includes functionalities to Create, Read, Update, and Delete employee data. The application is built with Spring Boot and follows standard practices for RESTful web services.

## Global Exception Handling

The application employs a global exception handling mechanism to manage and format error responses consistently. This ensures that users receive clear and structured error messages, and that developers have meaningful logs for debugging.

### Key Features

1. **Standardized Error Responses:**
   - The `ErrorResponse` class provides a consistent format for error messages, including a message and HTTP status code.

2. **Detailed Logging:**
   - Each exception handler logs detailed information about the exception to facilitate troubleshooting and debugging.

3. **Specific Exception Handling:**
   - **EmptyInputException:** Handles cases where input fields are empty. Returns a `400 Bad Request` status with a descriptive message.
   - **NoSuchElementException:** Handles cases where no value is found in the database. Returns a `404 Not Found` status with a descriptive message.
   - **HttpRequestMethodNotSupportedException:** Handles unsupported HTTP methods. Returns a `405 Method Not Allowed` status with a descriptive message.

4. **Global Exception Handler:**
   - Catches any unexpected exceptions and returns a `500 Internal Server Error` status with a generic error message.

### Implementation Details

#### ErrorResponse Class

The `ErrorResponse` class is used to standardize the error messages sent in responses. It includes:

- `message`: A human-readable description of the error.
- `statusCode`: The HTTP status code associated with the error.

#### Example Error Response

```json
{
  "message": "Input field is empty. Please check your input.",
  "statusCode": 400
}
```
---
# Running the Application
To run the application, use the following command:

Code : mvn spring-boot:run

Make sure you have Maven and JDK installed on your system. The application will start on port 8080 by default.

---
# Contributing
Contributions to improve the application are welcome. Please open an issue or submit a pull request with your proposed changes.

```This `README.md` file provides a clear overview of the global exception handling implementation and other relevant details for your project.```
