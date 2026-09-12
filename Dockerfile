FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B

COPY src src

RUN ./mvnw clean package -Dmaven.test.skip=true

EXPOSE 8080

CMD ["java", "-jar", "target/smart-healthcare-platform-1.0.0.jar"]