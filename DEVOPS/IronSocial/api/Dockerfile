FROM maven:3.8.3-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ /app/src/
RUN mvn package -DskipTests


FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/IronSocial-0.0.1-SNAPSHOT.jar /app/iron-social.jar
EXPOSE 8080
ENTRYPOINT  ["java", "-jar", "iron-social.jar"]
