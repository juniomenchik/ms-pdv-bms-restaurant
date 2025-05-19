# MS-PDV-BMS-RESTAURANT

## Description

This project is a restaurant management system that allows users to handle restaurant operations such as managing tables, orders, and payments. The system is designed to be user-friendly and efficient, streamlining the restaurant staff’s daily activities.

## Purpose

This project exists to showcase every back-end soft skill I have ever implemented, following best practices and design patterns.

---

## Ideas to be Implemented

## Code Coverage and Testing

* Unit tests
* Integration tests
* End-to-end tests

* Code coverage reports
* SonarQube integration for code quality analysis
* External API testing
* Selenium ?

### Input Handling

* File Uploads:

    * PDF
    * Videos
    * Images
    * CSV

### Output Handling

* File Downloads:

    * PDF
    * Videos
    * Images
    * CSV

### Error Handling

* Data overflow
* Data validation via annotations
* Global exception handling

### Circuit Breaker

* Investigate and implement a Circuit Breaker pattern to prevent system overload during failures in external services

### Log Management

* Log server integration (e.g., Splunk, Elasticsearch, or Grafana)
* Microservices compatible with centralized logging
* Use Spring Cloud Sleuth to trace calls between microservices

### Batch Processing

* Environment variable configuration
* Scheduling routines at different times

### Cache (Redis Integration)

* Data caching to improve system performance
* Redis-based cache configuration

### Kafka

* High-throughput user registration queue for bulk data processing

---

## Core Features

### User Authentication & Authorization (Spring Security)

* User registration
* User login
* User roles (admin, staff)

### Table Management

* Database: MySQL

### Entity Relationship Management

* Framework: Spring Data JPA

---

## Tech Stack

* **Java 17+**
* **Spring Boot**
* **Spring Security**
* **Spring Data JPA**
* **Spring Web**
* **MySQL**
* **Redis**
* **Kafka**
* **Log Management**: Sleuth + Splunk/Elasticsearch
* **Batch Processing**: Spring Batch
* **File Handling**: Multipart support for uploads/downloads

---

## Getting Started

### Prerequisites

* JDK 17+
* Maven or Gradle
* Docker (optional, for DB/Redis/Kafka)

### Setup

