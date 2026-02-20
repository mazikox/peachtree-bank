# Peachtree Bank

[![Spring Boot](https://img.shields.io/badge/Spring--Boot-2.7.13-brightgreen)](https://spring.io/projects/spring-boot)
[![Angular](https://img.shields.io/badge/Angular-16-red)](https://angular.io/)
[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Machine Learning](https://img.shields.io/badge/ML-Weka%203.8.0-blue)](https://www.cs.waikato.ac.nz/ml/weka/)

Peachtree Bank is a sophisticated **Personal Finance Management (PFM)** application designed to streamline personal financial tracking through intelligent automation and data-driven insights. 

The system leverages a modern Full-stack architecture, integrating a robust Spring Boot backend with a dynamic Angular frontend, complemented by an embedded Machine Learning engine for automated transaction analysis.

---

## Key Features

- **Advanced Transaction Management**: Comprehensive transaction history with high-performance server-side pagination, multi-criteria filtering, and dynamic sorting.
- **Intelligent ML Categorization**: Automatic classification of bank transactions (e.g., Health, Food, Transport) powered by a Neural Network engine.
- **Data-Driven Analytics**: Interactive dashboards featuring real-time data visualization via responsive charts for better financial decision-making.
- **Multi-Currency Support**: Automated currency conversion and exchange rate handling for cross-account transactions.
- **Payee & Account Management**: Centralized management of financial entities and liquid assets with real-time balance updates.

---

## Technical Stack

### Backend (Java / Spring Boot)
- **Framework**: Spring Boot 2.7.13
- **Data Access**: Spring Data JPA / Hibernate (optimized with Paging & Sorting)
- **Database**: SQLite (Embedded, high-portability storage)
- **ML Engine**: Weka 3.8.0 (Multilayer Perceptron implementation)
- **Data Mapping**: MapStruct (High-performance type-safe bean mapping)
- **Utilities**: Project Lombok (Boilerplate reduction)

### Frontend (Angular)
- **Framework**: Angular 16
- **UI Architecture**: Angular Material Design (Responsive and modular)
- **Data Visualization**: CanvasJS Charts
- **Date Utilities**: Moment.js

---

## API Documentation

Peachtree Bank exposes a full REST API, allowing for seamless integration and automation of financial data.

```bash
# Fetch paginated transactions
curl http://localhost:8080/transactions/get?page=0&pageSize=10

# Add a new transaction
curl -X POST http://localhost:8080/transactions/add \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Gym Membership",
    "amount": 120.50,
    "currencyCode": "PLN",
    "originatorAccountNumber": "12345678901234567890",
    "counterpartyAccount": "67890123456789012345"
  }'

# Get transaction analytics by category
curl http://localhost:8080/transactions/groupBy?dateFrom=1672531200&dateTo=1704067200

# Get total account balance
curl http://localhost:8080/accounts/countBalance
```

---

## Technical Deep Dive: ML Integration

One of the project's defining features is its seamless integration with the **Weka** library to automate business processes. 

- **The Model**: Implements a *Multilayer Perceptron* neural network.
- **The Pipeline**: Transactions are processed through a `StringToWordVector` filter, enabling the network to classify raw transaction titles into meaningful business domains.
- **Value Proposition**: By automating categorization, the application significantly reduces friction in user budget management, demonstrating the practical application of AI in fintech.

---

## Getting Started

### Prerequisites
- JDK 17
- Node.js (v16+) & npm
- Maven

### Installation

**Backend Setup**
1. Navigate to `backend/springboot`.
2. Build the project: `mvn clean install`.
3. Run the application: `mvn spring-boot:run`.

**Frontend Setup**
1. Navigate to `front/peachtreeBank`.
2. Install dependencies: `npm install`.
3. Start the development server: `npm start`.
4. Access the app at `http://localhost:4200`.

---

## About the Project
Developed and refined during professional internships, this project showcases the implementation of modern software architecture patterns and the integration of advanced machine learning algorithms within a enterprise-grade Full-stack environment.


