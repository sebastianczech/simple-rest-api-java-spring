FROM maven:3.6.3-jdk-11 AS build
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package

FROM openjdk:11-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=/app/target/*.jar
COPY ${JAR_FILE} app.jar
COPY --from=build ${JAR_FILE} /app.jar
EXPOSE 48080
ENTRYPOINT ["java","-jar","/app.jar"]