# Quiz Microservice Application

## Overview

This Quiz Microservice Application is built using Spring Boot and Java. It consists of two main microservices: **Quiz Service** and **Question Service**. The application is designed to manage quizzes and questions efficiently, leveraging a MySQL database for data storage.

## Architecture

### Quiz Service
- The primary interface for the frontend.
- Manages quiz creation, retrieval, and user interactions.
- Facilitates seamless communication between users and the question data.

### Question Service
- Handles the management of the question bank.
- Supports CRUD (Create, Read, Update, Delete) operations for questions.
- Provides the Quiz Service with access to question data.

## Database
The application uses a MySQL database to store all quiz and question information. This architecture allows for efficient data management and scalability, enabling the application to handle multiple quizzes and questions simultaneously.

## Benefits
- **Separation of Concerns**: Each microservice can be maintained and enhanced independently.
- **Scalability**: The application can easily adapt to increased demand.
