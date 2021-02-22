FROM openjdk:15-alpine3.12

WORKDIR /usr/exchange-service-app
COPY ./autobuild/exchange-service-*.jar .

CMD java -jar exchange-service-*.jar

EXPOSE 8080
