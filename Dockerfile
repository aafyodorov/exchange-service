FROM openjdk:15-alpine3.12

WORKDIR /usr/exchange-service-app
COPY . .
RUN ./mvnw package -DskipTests

#WORKDIR /usr/exchange-service-app/target
CMD ["java", "-jar", "./target/exchange-service-1.0.0.jar"]

EXPOSE 8080
