FROM openjdk:8-jdk-alpine AS builder
WORKDIR target/dependency
ARG APPJAR=target/*.jar
COPY ${APPJAR} app.jar
EXPOSE 9004
RUN jar -xf ./app.jar

FROM openjdk:8-jre-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=builder ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /app
ADD wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh
CMD sh -c '/wait-for-it.sh eureka-server:9102 -t 80 -- java -cp app:app/lib/* com.livefox.zuulserver.ZuulServerApplication'