FROM openjdk:17-jdk-slim

EXPOSE 8080

ADD target/SpringBoot-0.0.1-SNAPSHOT.jar myapp1.jar

CMD ["java", "-jar", "myapp1.jar"]