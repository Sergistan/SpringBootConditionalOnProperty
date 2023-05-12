FROM openjdk:8-jdk-alpine
EXPOSE 8081
ADD target/SpringBoot-0.0.1-SNAPSHOT.jar myapp2.jar
ENTRYPOINT ["java","-jar","myapp2.jar"]