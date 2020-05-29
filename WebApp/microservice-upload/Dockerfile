FROM openjdk:8-jdk-alpine AS builder
WORKDIR target/dependency
ARG APPJAR=target/*.jar
COPY ${APPJAR} app.jar
RUN jar -xf ./app.jar

FROM debian 

RUN apt-get update && \ 
    apt-get install gpac -y && \   
    apt-get install ffmpeg -y && \
    apt-get install default-jre -y

COPY encoding.sh /encoding.sh
COPY encoding2.sh /encoding2.sh
COPY encoding3.sh /encoding3.sh

ARG DEPENDENCY=target/dependency

COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=builder ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /app


CMD sh -c 'java -cp app:app/lib/* com.example.uploadingfiles.UploadingFilesApplication'