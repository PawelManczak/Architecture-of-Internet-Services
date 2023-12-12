FROM maven:3.8.4-openjdk-17 AS builder
COPY pom.xml .
COPY src ./src
RUN mvn clean package

FROM eclipse-temurin:latest
COPY --from=builder /target/player-0.0.1-SNAPSHOT.jar player.jar
EXPOSE 8081
CMD ["java", "-jar", "player.jar"]
