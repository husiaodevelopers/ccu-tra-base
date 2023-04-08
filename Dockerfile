FROM openjdk:8
WORKDIR /app
EXPOSE 8081
RUN rm -f ccutraapi.jar
ADD ./target/ccutraapi.jar ccutraapi.jar
ENTRYPOINT ["java","-jar","ccutraapi.jar"]

#CMD ["./wait-for-it.sh", "mysql-standa lone:3306","java", "-jar", "ccutraapi.jar"]
