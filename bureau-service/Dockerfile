FROM openjdk:17
ADD target/bureau-service-0.0.1-SNAPSHOT.jar bureau-service.jar
ENTRYPOINT ["java", "-jar", "bureau-service.jar"]

#docker run -p 3306:3306 --name mysql-standalone -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=account-db -e MYSQL_USER=admin -e MYSQL_PASSWORD=root -d mysql:5.6
