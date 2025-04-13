# Imagen base con Maven y Java 17
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Copia el código fuente
COPY . /app
WORKDIR /app

# Ejecuta el build (compilar y generar el JAR)
RUN mvn clean package -DskipTests

# Imagen de ejecución con Java 17
FROM eclipse-temurin:17-jdk

# Directorio de trabajo
WORKDIR /app

# Copia el JAR desde la imagen de build
COPY --from=build /app/target/*.jar app.jar

# Puerto que expone la app (ajustalo si es distinto)
EXPOSE 8080

# Comando para ejecutar la app
CMD ["java", "-jar", "app.jar"]

