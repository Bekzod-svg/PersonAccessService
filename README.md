# Person Access Service
## Overview
Java-based application built using Spring Boot, providing a REST API for managing Person entities. It uses PostgreSQL for data persistence and employs Spring Data JPA for database interactions.

## Features
- CRUD operations for Person entities.
- RESTful service implementation.
- Database interaction with PostgreSQL.

## Development Environment
- **Java**: JDK 21
- **Framework**: Spring Boot 3.2.2
- **Database**: PostgreSQL
- **Build Tool**: Maven

## Configuration
- PostgreSQL datasource is configured in application.yml.
- The V1__PersonTable.sql script initializes the Person table in the database.
- REST endpoints are defined in PersonController.
## Running the Application
- Ensure Java and PostgreSQL are installed.
- Set up the database and run the V1__PersonTable.sql script.
- Update application.yml with your database credentials.
- Run Demo3Application to start the server.

## Endpoints
- GET /persons: List all persons.
- POST /persons: Add a new person.
- PUT /persons/{id}: Update an existing person.
- DELETE /persons/{id}: Delete a person.

## Dependencies
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- PostgreSQL JDBC Driver
