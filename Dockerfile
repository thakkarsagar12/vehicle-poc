# Stage 1: build jar on image
#FROM gradle:7.0.2-jdk11 as build
#WORKDIR /app
#COPY . /app
#RUN ./gradlew build
#RUN gradle build

# Stage 2: run jar on continer
FROM gradle:7.0.2-jdk11
ENV PROFILE = "stg"

ARG buildFile=/build/libs/vehicleApp-0.0.1-SNAPSHOT.jar
#COPY --from=build ${buildFile} app.jar
ADD ${buildFile} app.jar

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=${PROFILE}", "app.jar"]
EXPOSE 8080