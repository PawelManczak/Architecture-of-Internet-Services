FROM maven:3.8.4-openjdk-17 AS builder
COPY pom.xml .
COPY src ./src
RUN mvn clean package

FROM eclipse-temurin:latest
COPY --from=builder /target/gateway-0.0.1-SNAPSHOT.jar gateway.jar
EXPOSE 8083
CMD ["java", "-jar", "gateway.jar"]
