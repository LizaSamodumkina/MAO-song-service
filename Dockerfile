FROM openjdk:17-jdk-slim
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} MAO-song-service-1.0.jar
ENTRYPOINT ["java","-jar","/MAO-song-service-1.0.jar"]
