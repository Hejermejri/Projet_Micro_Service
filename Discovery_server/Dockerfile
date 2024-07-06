FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/discovery-server-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} Discovery-server.jar
ENTRYPOINT ["java","-jar","/Discovery-server.jar"]
