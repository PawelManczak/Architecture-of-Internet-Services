FROM maven:3.8.4-openjdk-17 AS builder
COPY pom.xml .
COPY src ./src
RUN mvn clean package

FROM eclipse-temurin:latest
COPY --from=builder /target/club-0.0.1-SNAPSHOT.jar club.jar
EXPOSE 8082
CMD ["java", "-jar", "club.jar"]
