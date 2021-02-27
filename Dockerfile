FROM openjdk:8-jre-slim

WORKDIR /root

EXPOSE 8080

COPY build/libs/management-0.0.1-SNAPSHOT.jar .

CMD java -jar management-0.0.1-SNAPSHOT.jar
