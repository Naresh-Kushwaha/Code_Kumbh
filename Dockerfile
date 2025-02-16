FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY target/*.jar app.jar

EXPOSE 8080
CMD ["java","-jar","app.jar"]