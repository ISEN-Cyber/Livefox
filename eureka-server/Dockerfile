FROM openjdk:8-jdk-alpine AS builder
WORKDIR target/dependency
ARG APPJAR=target/*.jar
COPY ${APPJAR} app.jar
EXPOSE 9102
EXPOSE 9101
RUN jar -xf ./app.jar

FROM openjdk:8-jre-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=builder ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /app
ADD wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh
CMD sh -c '/wait-for-it.sh config-server:9101 -t 100 -- java -cp app:app/lib/* com.livefox.eurekaserver.EurekaServerApplication'