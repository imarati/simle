FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar SimpleRest.jar
ENTRYPOINT ["java", "-jar", "SimpleRest.jar"]