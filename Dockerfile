FROM openjdk

EXPOSE 8080

ADD target/SpringBootDocker-0.0.1-SNAPSHOT.jar SpringBootDocker.jar

CMD ["java", "-jar", "SpringBootDocker.jar"]
