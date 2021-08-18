FROM openjdk:11

WORKDIR /app

ADD target/Group777777-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

RUN sh -c "echo spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver >> application.properties"
RUN sh -c "echo spring.datasource.url=jdbc:mysql://mysql:3306/stock_market >> application.properties"
RUN sh -c "echo spring.datasource.username=root >> application.properties"
RUN sh -c "echo spring.datasource.password=replace_with_your_password >> application.properties"
RUN sh -c "echo spring.jpa.hibernate.ddl-auto=update >> application.properties"
RUN sh -c "echo spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect >> application.properties"
RUN sh -c "echo spring.jackson.serialization.FAIL_ON_EMPTY_BEANS=false >> application.properties"

ENTRYPOINT ["java", "-jar", "app.jar"]