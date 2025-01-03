
Objectives:
Movie REST API

Step 1: Initialize the Project
Use Spring Initializr to create a new Spring Boot project.

Add the following dependencies:

Spring Web
Spring Data JPA
Lombok
PostgreSQL Driver
Use Maven for dependency management and install all dependencies.

Set the application to run on port 9001.

Project Goal:
Build a REST API to manage books and authors with a PostgreSQL database.

Requirements:
Task 1: Package Structure
Create the following packages under your main method's package:

controller
entity
service
dao
Task 2: Entity Definitions
Create a Book class under the entity package with the following fields:

id
title
genre
author (Many-to-One relationship with Author)
publishDate
Create an Author class under the entity package with the following fields:

id
firstName
lastName
birthDate
books (One-to-Many relationship with Book)
Use Lombok annotations to generate getters, setters, and constructors.

Use JPA annotations to map relationships.

Task 3: Database Configuration
Configure your application.properties file to connect to a PostgreSQL database.
Enable logging for Hibernate SQL using:
Copy code
logging.level.org.hibernate.SQL=DEBUG  
logging.level.org.hibernate.orm.jdbc.bind=TRACE  
Task 4: DAO Interfaces
Create BookDao and AuthorDao interfaces under the dao package. Define methods for CRUD operations.

Task 5: Service Layer
Create service interfaces and implementations under the service package to handle business logic for Book and Author.

API Endpoints
Books:
[GET] /api/books: Returns a list of all books.
[GET] /api/books/{id}: Returns a book by ID.
[POST] /api/books: Creates a new book with an associated author.
[PUT] /api/books/{id}: Updates the book with the given ID.
[DELETE] /api/books/{id}: Deletes the book with the given ID.
Authors:
[GET] /api/authors: Returns a list of all authors.
[GET] /api/authors/{id}: Returns an author by ID.
[POST] /api/authors: Creates a new author with associated books.
[PUT] /api/authors/{id}: Updates the author with the given ID.
[DELETE] /api/authors/{id}: Deletes the author with the given ID.
Optional Enhancements:
Create a exceptions package:

Implement custom exceptions, e.g., ApiException, extending RuntimeException.
Add a HttpStatus field to ApiException.
Add Global Exception Handling:

Use @ControllerAdvice for centralized exception management.
Add validation using spring-boot-starter-validation:

Create a ValidationUtil class for reusable validation logic.
Add logging with @Slf4j:

Log errors when exceptions are thrown.
Experiment with CORS policies to make requests from a front-end application.