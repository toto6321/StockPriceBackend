FROM openjdk:11

WORKDIR /app

ADD target/Group777777-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

RUN sh -c "echo spring.datasource.url=jdbc:mysql://my-mysql-con:3306/stock_market >> application.properties"

ENTRYPOINT ["java", "-jar", "app.jar"]
