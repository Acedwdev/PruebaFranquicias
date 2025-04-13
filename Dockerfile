# Usa una imagen base con Java 17
FROM eclipse-temurin:17-jdk

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR en el contenedor
COPY target/*.jar app.jar

# Puerto en el que se ejecuta la app
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
