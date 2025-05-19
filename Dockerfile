FROM openjdk:21-jdk-slim
WORKDIR /app

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

# Espera 15s antes de iniciar o jar (tempo ajustável)
ENTRYPOINT ["sh", "-c", "sleep 15 && java -jar app.jar"]