# IoT Device Data Platform

A **Java Spring Boot** backend for collecting, storing, and serving telemetry data from distributed IoT devices.  
The system provides **secure REST APIs** for authenticated clients to fetch device data, and uses **PostgreSQL** (running in Docker) for structured time-series storage.

---

## 📌 Features

- **RESTful APIs** to send and retrieve IoT device telemetry.
- **User authentication & authorization** for secure access.
- **PostgreSQL database** (Docker container) for reliable and scalable storage.
- Optimized schema for time-series queries.
- Modular design for future scaling and integration.

---

## 🛠 Tech Stack

- **Backend:** Java, Spring Boot  
- **Database:** PostgreSQL (Docker)  
- **API:** REST  
- **Authentication:** JWT (JSON Web Tokens)  

---

## 🚀 Getting Started

### 1️⃣ Prerequisites
- [Docker](https://www.docker.com/) installed (for PostgreSQL)  
- Java 17+ installed  


### BUILD INSTRUCTIONS IN PROGRESS (these are mainly notes):

docker-compose.yml in the ./database folder is configured for no volume keep it that way during development so you can reseed to a known good database state. ./database/seeder.sh will populate the database using ./database/init.sql

default admin authentication credentials are in the init.sql file.
