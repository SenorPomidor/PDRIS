FROM openjdk:18-alpine

WORKDIR /app

COPY target/homework-2-service-2-1.0-SNAPSHOT.jar /app/homework-2-service-2-1.0-SNAPSHOT.jar

ENV SERVER_PORT=8081

CMD ["java", "-Xms256m", "-Xmx512m", "-jar", "/app/homework-2-service-2-1.0-SNAPSHOT.jar"]