FROM openjdk:11

WORKDIR /app

COPY target/Group777777-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

RUN sh -c "echo spring.datasource.url=jdbc:mysql://my-mysql-con:3306/stock_market >> application.properties"
RUN sh -c "echo spring.datasource.username=root >> application.properties"
RUN sh -c "echo spring.datasource.password=replace_with_your_password >> application.properties"
RUN sh -c "echo server.port=8081 >> application.properties"

ENTRYPOINT ["java", "-jar", "app.jar"]
