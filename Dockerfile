FROM openjdk:8u121-jre-alpine
VOLUME /tmp

COPY target/miaosha-1.0-SNAPSHOT.jar app.jar

EXPOSE 8020
ENTRYPOINT ["sh","-c","java -jar app.jar"]