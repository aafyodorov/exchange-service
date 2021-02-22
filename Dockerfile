FROM openjdk:15-alpine3.12

WORKDIR /usr/exchange-service-app
COPY . .
RUN ./mvnw package

WORKDIR /usr/exchange-service-app/target
CMD ["java", "-jar", "exchange-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
