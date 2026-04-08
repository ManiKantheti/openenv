FROM openjdk:17
COPY target/code-review-env.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]