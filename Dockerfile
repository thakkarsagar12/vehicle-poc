#
#
#FROM gradle:7.0.2-jdk11 as builder
#COPY . .
#CMD gradle booJar
##RUN java -Djarmode=layertools -jar app.jar extract
#
##FROM adoptopenjdk:11-jre-hotspot
##ENV PROFILE = "stg"
##ARG JAR_FILE=/build/libs/*.jar
##CMD ls -a
##COPY --from=builder ./build/libs/*.jar app.jar
#COPY /build/libs/*.jar app.jar
#
##COPY --from=builder ./dependencies/ ./
##COPY --from=builder ./snapshot-dependencies/ ./
##COPY --from=builder ./spring-boot-loader/ ./
##COPY --from=builder ./application/ ./
#ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=${PROFILE}", "app.jar"]
#EXPOSE 8080

# using multistage docker build
# ref: https://docs.docker.com/develop/develop-images/multistage-build/

# temp container to build using gradle
FROM gradle:7.0.2-jdk11 AS TEMP_BUILD_IMAGE
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle $APP_HOME

COPY gradle $APP_HOME/gradle
COPY --chown=gradle:gradle . /home/gradle/src
USER root
RUN chown -R gradle /home/gradle/src

#RUN gradle bootJar || return 0
COPY . .
RUN gradle clean bootJar

# actual container
FROM adoptopenjdk/openjdk11:alpine-jre
ENV ARTIFACT_NAME=vehicleApp-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME
COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME .

EXPOSE 8080
ENTRYPOINT exec java -jar ${ARTIFACT_NAME}