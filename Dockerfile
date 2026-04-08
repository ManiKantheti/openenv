FROM maven:3.9.6-eclipse-temurin-17

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

EXPOSE 7860

CMD ["java", "-jar", "target/code-review-env-1.0.jar"]