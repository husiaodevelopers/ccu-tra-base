FROM openjdk:8
EXPOSE 8081
ADD /target/ccutraapi.jar ccutraapi.jar
ENTRYPOINT ["java","-jar","ccutraapi.jar"]
CMD ["./wait-for-it.sh", "mysql-standalone:3306","java", "-jar", "ccutraapi.jar"]
