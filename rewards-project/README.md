# Retailer Rewards Program API

## Overview

This project is a Spring Boot REST API that calculates reward points earned by customers based on their purchase transactions during a three-month period.

The application calculates reward points according to the following rules:

- 2 points for every dollar spent over $100 in a transaction.
- 1 point for every dollar spent between $50 and $100 in a transaction.
- No points for spending $50 or less.

## Features

- Spring Boot REST API
- Dynamic monthly reward calculation (No hard-coded months)
- SQL-based data initialization using schema.sql and data.sql
- Customer-level and monthly reward aggregation
- Exception handling using Global Exception Handler
- Unit tests and Integration tests
- H2 in-memory database
- Layered architecture

## Project Structure

```text
src
├── main
│   ├── java
│   └── resources
└── test
```

## API Endpoints

GET /api/rewards

GET /api/rewards/{customerId}

## Running the Application

```bash
mvn clean install
mvn spring-boot:run
```

## Author

N Nanjundaswamy
