FROM openjdk:11-jre-slim-buster

LABEL maintainer="Erika Vacacela"
LABEL repo.url="https://github.com/erikavacacela/aws-women-hello-api"

RUN apt-get install tzdata

ENV TZ America/Guayaquil

ADD build/libs/aws-women-hello-api-1.0.0-SNAPSHOT.jar /usr/share/app.jar

ENTRYPOINT ["java", "-jar", "/usr/share/app.jar"]
