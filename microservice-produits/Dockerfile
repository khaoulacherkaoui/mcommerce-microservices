FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} user-service.jar
ENTRYPOINT ["java","-jar","/config-server.jar"]
EXPOSE 9001