FROM maven:3.6.3-openjdk-8 AS builder
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:8
EXPOSE 8081
COPY --from=builder /app/target/ccutraapi.jar ccutraapi.jar
ENTRYPOINT ["java","-jar","ccutraapi.jar"]
#ADD /target/ccutraapi.jar ccutraapi.jar
#CMD ["./wait-for-it.sh", "mysql-standalone:3306","java", "-jar", "ccutraapi.jar"]
