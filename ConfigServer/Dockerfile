FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/config-server-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} ConfigServer.jar
ENTRYPOINT ["java","-jar","/ConfigServer.jar"]
