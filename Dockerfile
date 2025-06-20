# Use uma imagem base do Maven para compilar o projeto
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Define o diretório de trabalho para o build
WORKDIR /app

# Copia os arquivos do projeto para o container
COPY . .

# Executa o comando de build do Maven para gerar o JAR
RUN mvn clean package -DskipTests

# Use uma imagem base do JDK para executar o JAR
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR gerado pelo estágio anterior dinamicamente
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]