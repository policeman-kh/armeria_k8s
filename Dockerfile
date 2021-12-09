FROM gradle:7.2.0-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon -x test --debug

FROM adoptopenjdk/openjdk11:jre-11.0.12_7-alpine
EXPOSE 8080
EXPOSE 8081
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/app.jar
ENTRYPOINT ["java","-Xms1g", "-Xmx2g", "-jar","/app/app.jar"]
