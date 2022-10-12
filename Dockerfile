FROM openjdk:17

COPY target/warehouse-srevice-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080:80


CMD ["java", "-jar", "app.jar"]