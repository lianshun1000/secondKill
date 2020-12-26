FROM openjdk:8u121-jre-alpine
VOLUME /tmp

COPY target/miaosha-1.0-SNAPSHOT.jar app.jar

EXPOSE 8020
RUN echo -e "java -jar app.jar" > ./entrypoint.sh
RUN chmod +x /entrypoint.sh
ENTRYPOINT ["/entrypoint.sh"]