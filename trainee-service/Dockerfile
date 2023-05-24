FROM openjdk:17-alpine

ARG MAVEN_ARTIFACT=./target/server-*.jar
COPY ${MAVEN_ARTIFACT} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]