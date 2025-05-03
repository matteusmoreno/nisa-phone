# Etapa 1: Construir o projeto
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Executar a aplicação
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/anisatrilestari-0.0.1-SNAPSHOT.jar /app/anisatrilestari.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "anisatrilestari.jar"]
