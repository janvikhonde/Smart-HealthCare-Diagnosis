# 🏥 AI-Driven Early Diagnosis & Preventive Healthcare Platform

## 📌 About the Project

The **AI-Driven Early Diagnosis & Preventive Healthcare Platform** is a web-based healthcare application designed to help users understand their symptoms and receive an initial indication of possible health conditions.

The platform provides symptom-based analysis, personalized disease predictions, and location-based recommendations for nearby hospitals and healthcare facilities.

> **⚠️ Disclaimer:** This application provides an initial indication based on user-provided symptoms. It is not a replacement for professional medical diagnosis, treatment, or consultation.

## 🎯 Problem Statement

Many people ignore early symptoms or are unsure about which healthcare facility they should visit. Professional consultations can also be expensive for minor or initial health concerns.

This project aims to provide users with a simple platform where they can:

- Analyze their symptoms.
- Get an initial indication of possible health conditions.
- Find nearby hospitals and healthcare facilities.
- Access healthcare-related assistance from one platform.

## ✨ Key Features

### 🩺 1. Symptom Analysis
- Allows users to enter their symptoms.
- Analyzes the symptoms provided by the user.
- Provides an initial indication of possible health conditions.

### 🤖 2. AI Assistant
- Provides basic healthcare-related responses.
- Helps users understand common symptoms and health concerns.
- Offers preliminary healthcare information rather than a medical diagnosis.

### 🏥 3. Nearby Healthcare Facilities
- Uses location-based services to identify nearby healthcare facilities.
- Displays hospitals and relevant healthcare locations on an interactive map.
- Uses map-based visualization to make navigation easier.

### 👤 4. User Authentication
- User registration and login.
- Session-based user access.
- Protected application features.

### 🗄️ 5. Database Management
- Stores application and user-related information using MySQL.
- Uses Spring Data JPA and Hibernate for database operations.

### 🌐 6. Responsive Web Interface
- Provides a simple and user-friendly interface.
- Built using HTML, CSS, and JavaScript.
- Integrated with Spring Boot backend services.

## 🛠️ Technologies Used

| Category | Technologies |
|---|---|
| Backend | Java, Spring Boot |
| Frontend | HTML, CSS, JavaScript, Thymeleaf |
| Database | MySQL |
| ORM | Spring Data JPA, Hibernate |
| Maps | Leaflet |
| Location and Healthcare Data | OpenStreetMap, Overpass API |
| Build Tool | Maven |
| Containerization | Docker |
| Deployment | Render |
| Cloud Database | Aiven MySQL |
| Version Control | Git, GitHub |

## 🏗️ System Architecture

The application follows a layered architecture in which the frontend communicates with the Spring Boot backend. The backend processes requests and interacts with the MySQL database and external map services.

```text
                  ┌──────────────────────┐
                  │        User          │
                  └──────────┬───────────┘
                             │
                             ▼
                  ┌──────────────────────┐
                  │    Web Interface     │
                  │ HTML / CSS / JS      │
                  │     Thymeleaf        │
                  └──────────┬───────────┘
                             │
                             ▼
                  ┌──────────────────────┐
                  │     Spring Boot      │
                  │       Backend        │
                  │  REST APIs / Services│
                  └──────┬────────┬──────┘
                         │        │
                 ┌───────┘        └────────┐
                 ▼                         ▼
        ┌─────────────────┐       ┌─────────────────┐
        │   MySQL / JPA   │       │ Maps & Location │
        │    Database     │       │ Leaflet /       │
        │                 │       │ Overpass API    │
        └────────┬────────┘       └─────────────────┘
                 │
                 ▼
        ┌─────────────────┐
        │   Aiven MySQL   │
        │  Cloud Database │
        └─────────────────┘
```

## 📂 Project Structure

```text
SmartHealthCareDiagnosis/
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── healthcare/
│   │   │           └── ...
│   │   │
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── css/
│   │       │   ├── js/
│   │       │   └── images/
│   │       │
│   │       ├── templates/
│   │       └── application.properties
│   │
│   └── test/
│
├── screenshots/
│   ├── Dashboard.png
│   ├── Find Nearby Hospitals.png
│   ├── Smart AI Health Assistant.png
│   └── Symptom Analyzer.png
│
├── .gitignore
├── Dockerfile
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## ⚙️ Running the Project Locally

### Prerequisites

Make sure the following tools are installed:

- Java JDK
- MySQL
- Maven (or use the included Maven Wrapper)
- Git

### 1. Clone the Repository

```bash
git clone https://github.com/janvikhonde/Smart-HealthCare-Diagnosis.git
```

### 2. Navigate to the Project Directory

```bash
cd Smart-HealthCare-Diagnosis
```

### 3. Configure MySQL

Create the database in MySQL:

```sql
CREATE DATABASE healthcare_db;
```

Configure the following database environment variables with your own credentials:

```properties
DATABASE_HOST=localhost
DATABASE_PORT=3306
DATABASE_NAME=healthcare_db
DATABASE_USERNAME=root
DATABASE_PASSWORD=your_password
```

**Note:** Keep your database credentials private. Do not upload passwords or other secrets to GitHub.

### 4. Run the Application

On Windows, use the Maven Wrapper:

```cmd
mvnw.cmd spring-boot:run
```

Alternatively, build the application:

```cmd
mvnw.cmd clean package
```

Then run the generated JAR:

```bash
java -jar target/smart-healthcare-platform-1.0.0.jar
```

The application will normally be available at:

**http://localhost:8080**

## 🚀 Future Enhancements

Possible future improvements include:

- Integration with more advanced machine-learning models.
- Improved disease prediction accuracy.
- Doctor appointment booking.
- User health history and reports.
- Emergency contact functionality.
- Support for more healthcare facility categories.
- Improved authentication and authorization.
- Mobile application support.
- Integration with additional healthcare APIs.

## ⚠️ Medical Disclaimer

The platform is intended for preliminary health information and educational purposes only. Its predictions should not be considered a confirmed diagnosis. Users should consult qualified healthcare professionals for medical advice, diagnosis, or treatment.
