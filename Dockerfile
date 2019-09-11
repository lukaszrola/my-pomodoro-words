FROM openjdk:11-jdk-slim-stretch

ADD build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
