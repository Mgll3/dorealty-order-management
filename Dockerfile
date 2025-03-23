FROM openjdk:17
ADD target/dorealty-order-management-0.0.1-SNAPSHOT.jar dorealty-order-management.jar
EXPOSE 8080
VOLUME /tmp
ENTRYPOINT ["java", "-jar", "dorealty-order-management.jar"]

