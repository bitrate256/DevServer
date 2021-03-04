# 기존 JRE
# FROM openjdk:8-jre-slim
# ojdk 1.8 282 JRE로 전환
FROM openjdk:8u282-jre-slim

WORKDIR /root

EXPOSE 8080

COPY build/libs/management-0.0.1-SNAPSHOT.jar .

CMD java -jar management-0.0.1-SNAPSHOT.jar
