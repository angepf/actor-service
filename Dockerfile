FROM openjdk:17-jdk-alpine as builder

RUN addgroup -S quisange && adduser -S admin -G quisange
USER admin:quisange
VOLUME /tmp
ARG JAR_FILE=target/*.jar
ADD target/${JAR_FILE} app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]