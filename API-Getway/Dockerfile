FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/api-gateway-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} API-Geteway.jar
ENTRYPOINT ["java","-jar","/API-Geteway.jar"]
