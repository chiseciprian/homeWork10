FROM openjdk:11.0.11-slim
WORKDIR /app

COPY target/train-app.jar train-app.jar

ENTRYPOINT java -jar /app/train-app.jar