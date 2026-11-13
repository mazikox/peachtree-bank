# Peachtree Bank

[![Spring Boot](https://img.shields.io/badge/Spring--Boot-2.7.13-brightgreen)](https://spring.io/projects/spring-boot)
[![Angular](https://img.shields.io/badge/Angular-16-red)](https://angular.io/)
[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Machine Learning](https://img.shields.io/badge/ML-Weka%203.8.0-blue)](https://www.cs.waikato.ac.nz/ml/weka/)

## Overview

Peachtree Bank is an **individual educational full-stack project** for managing personal finances. I built it to practice designing REST APIs, implementing financial business rules, connecting a Java backend with an Angular frontend and experimenting with transaction categorization.

**Stack:** Java 17, Spring Boot 2.7, Spring Data JPA/Hibernate, SQLite, MapStruct, Angular 16 and Weka.

## Features

- **Accounts, payees and transactions:** create and manage financial records with balance-related business logic.
- **Transaction history:** server-side filtering, sorting and pagination.
- **Multi-currency transfers:** balance validation and currency conversion using an external exchange-rate API.
- **Transaction categorization:** an experimental Weka Multilayer Perceptron classifier.
- **Angular frontend:** access backend operations and visualize financial data.

## Architecture and technologies

**Backend**

- Java 17 and Spring Boot 2.7.13
- REST endpoints and service-layer financial logic
- Spring Data JPA / Hibernate with SQLite
- MapStruct for data mapping; Lombok for boilerplate reduction
- JUnit 5 and Mockito for automated testing

**Frontend**

- Angular 16 and Angular Material
- CanvasJS Charts and Moment.js
- HTTP communication with the Spring Boot API

**Machine learning prototype**

- Weka 3.8.0 with Multilayer Perceptron
- `StringToWordVector` to transform transaction descriptions into features
- Experimental classification into categories such as food, transport and health

This is a prototype for learning and experimentation, not a production banking or machine learning service. No model accuracy or production performance is claimed here.

## REST API examples

```bash
# Get paginated transactions
curl 'http://localhost:8080/transactions/get?page=0&pageSize=10'

# Add a transaction
curl -X POST 'http://localhost:8080/transactions/add' \
  -H 'Content-Type: application/json' \
  -d '{
    "title": "Gym Membership",
    "amount": 120.50,
    "currencyCode": "PLN",
    "originatorAccountNumber": "12345678901234567890",
    "counterpartyAccount": "67890123456789012345"
  }'

# Get transaction statistics grouped by category
curl 'http://localhost:8080/transactions/groupBy?dateFrom=1672531200&dateTo=1704067200'

# Get total account balance
curl 'http://localhost:8080/accounts/countBalance'
```

## Run locally

**Prerequisites:** JDK 17, Maven, Node.js 16+ and npm.

**Backend**

```bash
cd backend/springboot
mvn clean install
mvn spring-boot:run
```

**Frontend**

```bash
cd front/peachtreeBank
npm install
npm start
```

Open the frontend at `http://localhost:4200`.

## Project context

Peachtree Bank was developed as a learning project while building my full-stack development skills. It is not a commercial banking product. The repository focuses on application design, REST APIs, business logic, persistence, frontend integration and a small machine learning experiment.
