FROM eclipse-temurin:17-jdk-jammy

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY target/demoHelloWorld-0.0.1-SNAPSHOT.jar /usr/src/app/demoHelloWorld-0.0.1-SNAPSHOT.jar
COPY src/main/resources/application.properties /usr/src/app/application.properties

EXPOSE 8080

CMD ["java", "-Dspring.config.location=/usr/src/app/application.properties" ,"-jar" , "demoHelloWorld-0.0.1-SNAPSHOT.jar"]