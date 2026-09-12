**🏥 AI-Driven Early Diagnosis \& Preventive Healthcare Platform**



**🌐 Live Demo**



**🚀 Live Application:**

https://smart-healthcare-app-l2e2.onrender.com





**📌 About the Project**



The \*\*AI-Driven Early Diagnosis \& Preventive Healthcare Platform\*\* is a web-based healthcare application designed to help users understand their symptoms and receive an initial indication of possible health conditions.



The platform provides symptom-based analysis, personalized disease prediction, and location-based recommendations for nearby healthcare facilities.



⚠️ **Disclaimer:** This application provides an initial indication based on user-provided symptoms. It is not a replacement for professional medical diagnosis or consultation.





**🎯 Problem Statement**



Many people ignore early symptoms or are unsure about which healthcare facility they should visit. Professional consultations can also be expensive for minor or initial health concerns.



This project aims to provide users with a simple platform where they can:



\* Analyze their symptoms.

\* Get an initial indication of possible diseases.

\* Find nearby hospitals and healthcare facilities.

\* Access healthcare-related assistance from one platform.





**✨ Key Features**



**🩺 Symptom Analysis**



\* Users can enter their symptoms.

\* The system analyzes the provided symptoms.

\* Provides an initial indication of possible health conditions.



**🤖 AI Assistant**



\* Provides basic healthcare-related responses.

\* Helps users understand common symptoms and health concerns.

\* Designed to provide preliminary information rather than medical diagnosis.



**🏥 Nearby Healthcare Facilities**



\* Uses location-based services to identify nearby healthcare facilities.

\* Displays hospitals and relevant healthcare locations on an interactive map.

\* Uses map-based visualization for easier navigation.



**👤 User Authentication**



\* User registration and login.

\* Session-based user access.

\* Protected application features.



**🗄️ Database Management**



\* Stores application and user-related information using MySQL.

\* Uses Spring Data JPA/Hibernate for database operations.



🌐 **Responsive Web Interface**



\* Simple and user-friendly web interface.

\* Built using HTML, CSS and JavaScript.

\* Integrated with Spring Boot backend services.





**🛠️ Technologies Used**



| Category                 | Technologies                     |

| ------------------------ | -------------------------------- |

| Backend                  | Java, Spring Boot                |

| Frontend                 | HTML, CSS, JavaScript, Thymeleaf |

| Database                 | MySQL                            |

| ORM                      | Spring Data JPA, Hibernate       |

| Maps                     | Leaflet                          |

| Location/Healthcare Data | OpenStreetMap / Overpass API     |

| Build Tool               | Maven                            |

| Containerization         | Docker                           |

| Deployment               | Render                           |

| Cloud Database           | Aiven MySQL                      |

| Version Control          | Git, GitHub                      |





**🏗️ System Architecture**



&#x20;               ┌──────────────────────┐

&#x20;               │       User           │

&#x20;               └──────────┬───────────┘

&#x20;                          │

&#x20;                          ▼

&#x20;               ┌──────────────────────┐

&#x20;               │   Web Interface      │

&#x20;               │ HTML/CSS/JavaScript  │

&#x20;               │     Thymeleaf        │

&#x20;               └──────────┬───────────┘

&#x20;                          │

&#x20;                          ▼

&#x20;               ┌──────────────────────┐

&#x20;               │    Spring Boot       │

&#x20;               │      Backend         │

&#x20;               │ REST APIs / Services │

&#x20;               └──────┬───────┬───────┘

&#x20;                      │       │

&#x20;             ┌────────┘       └─────────┐

&#x20;             ▼                          ▼

&#x20;    ┌─────────────────┐        ┌─────────────────┐

&#x20;    │   MySQL / JPA   │        │ Maps \& Location │

&#x20;    │     Database    │        │ Leaflet /       │

&#x20;    │                 │        │ Overpass API    │

&#x20;    └────────┬────────┘        └─────────────────┘

&#x20;             │

&#x20;             ▼

&#x20;      ┌───────────────┐

&#x20;      │ Aiven MySQL   │

&#x20;      │ Cloud Database│

&#x20;      └───────────────┘



**📸 Screenshots**



📊 **Dashboard**



!\[Dashboard](screenshots/Dashboard.png)





🩺 **Symptom Analyzer**



!\[Symptom Analyzer](screenshots/Symptom%20Analyzer.png)





🤖 **Smart AI Health Assistant**



!\[Smart AI Health Assistant](screenshots/Smart%20AI%20Health%20Assistant.png)





🏥 **Find Nearby Hospitals**



!\[Find Nearby Hospitals](screenshots/Find%20Nearby%20Hospitals.png)





📂 **Project Structure**



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



⚙️ **Running the Project Locally**



1\. Clone the Repository



git clone https://github.com/janvikhonde/Smart-HealthCare-Diagnosis.git



**2. Navigate to the Project**



cd Smart-HealthCare-Diagnosis



**3. Configure MySQL**



Create a MySQL database:



CREATE DATABASE healthcare\_db;



Configure the required database environment variables:



DATABASE\_HOST=localhost

DATABASE\_PORT=3306

DATABASE\_NAME=healthcare\_db

DATABASE\_USERNAME=root

DATABASE\_PASSWORD=your\_password





> Never commit real database passwords or other secrets to GitHub.



**4. Run the Application**



Using Maven Wrapper on Windows:



mvnw.cmd spring-boot:run



Or build the application:



mvnw.cmd clean package



Then run the generated JAR:



java -jar target/smart-healthcare-platform-1.0.0.jar





The application will normally be available at:

http://localhost:8080



🐳 **Running with Docker**



Build the Docker image:



docker build -t smart-healthcare-app .



Run the container:



docker run -d --name smart-healthcare-container -p 8080:8080 ^

\-e DATABASE\_HOST=host.docker.internal ^

\-e DATABASE\_PORT=3306 ^

\-e DATABASE\_NAME=healthcare\_db ^

\-e DATABASE\_USERNAME=root ^

\-e DATABASE\_PASSWORD=your\_password ^

smart-healthcare-app



Check the running container:

docker ps



View logs:

docker logs smart-healthcare-container



☁️ **Deployment**



The application is deployed using a containerized deployment architecture.



**Backend Application**



**Render** is used to host the Spring Boot application.



**Database**



**Aiven MySQL** is used as the cloud-hosted MySQL database.



**Deployment Flow**



GitHub Repository

&#x20;      │

&#x20;      ▼

&#x20;   Docker

&#x20;      │

&#x20;      ▼

&#x20;    Render

&#x20;      │

&#x20;      ▼

&#x20;Spring Boot Application

&#x20;      │

&#x20;      ▼

&#x20;  Aiven MySQL



**Live Application**



👉 https://smart-healthcare-app-l2e2.onrender.com



**🔐 Security**



Sensitive configuration should be supplied through environment variables rather than being hardcoded into the source code.



Examples include:

DATABASE\_HOST

DATABASE\_PORT

DATABASE\_NAME

DATABASE\_USERNAME

DATABASE\_PASSWORD

PORT



The actual database password should \*\*never be committed to GitHub\*\*.





🚀 **Future Enhancements**



Some possible future improvements include:



\* Integration with more advanced machine-learning models.

\* Improved disease prediction accuracy.

\* Doctor appointment booking.

\* User health history and reports.

\* Emergency contact functionality.

\* More healthcare facility categories.

\* Improved authentication and authorization.

\* Mobile application support.

\* Integration with additional healthcare APIs.



