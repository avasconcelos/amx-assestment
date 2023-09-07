FROM openjdk:17-alpine
EXPOSE 8080
VOLUME /tmp
COPY /build/libs/assestment-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]