# Proyecto de Gestión de Franquicias con Spring Boot + MySQL + Docker + Railway

Este es un proyecto Java Spring Boot que permite gestionar franquicias, sucursales y productos. La aplicación está configurada para funcionar tanto localmente como en producción usando Railway, Docker, DockerHub y GitHub Actions para despliegue automático.


# 📑 Índice

1. [Descripción del Proyecto]  
2. [Requisitos Previos]
3. [Despliegue en Producción]
4. [Clonar el Proyecto]
5. [Configuración del Entorno]
6. [Ejecución Local]
7. [Despliegue Automático (CI/CD)]
8. [Tecnologías Usadas]
9. [Estructura del Proyecto]
10.[Créditos]


# Descripción del Proyecto

Esta aplicación permite registrar y consultar franquicias, sucursales y productos en una base de datos MySQL. El proyecto incluye:

- Backend en Java 17 con Spring Boot.
- Persistencia con JPA/Hibernate.
- Despliegue automático mediante Docker, GitHub Actions, Railway y DockerHub.


# Requisitos Previos

- [Java 17+]
- [Maven](https://maven.apache.org)
- [Docker](https://www.docker.com)
- [Git](https://git-scm.com)
- Cuenta en:
  - [GitHub](https://github.com)
  - [DockerHub](https://hub.docker.com)
  - [Railway](https://railway.app)
  
# Despliegue en Producción

- URL pública: [https://pruebafranquicias-production.up.railway.app]

Crear Franquicia
- POST /api/franquicias
{
  "nombre": "Franquicia Nueva"
}

Actualizar una Franquicia
PUT /api/franquicias/{id}
{
  "nombre": "Nuevo Nombre"
}

Crear una Sucursal para una Franquicia
POST /api/franquicias/{idFranquicia}/sucursales
{
  "nombre": "Sucursal A"
}

Actualizar una Sucursal
PUT /api/sucursales/{id}
{
  "nombre": "Sucursal Actualizada"
}

Crear un Producto en una Sucursal
POST /api/sucursales/{idSucursal}/productos
{
  "nombre": "Producto X",
  "stock": 100
}

Actualizar un Producto
PUT /api/productos/{id}
{
  "nombre": "Producto Editado",
  "stock": 150
}

Eliminar un Producto
DELETE /api/productos/{id}

Producto con Mayor Stock en una Franquicia
GET /api/franquicias/{franquiciaId}/productos/max-sto


# Clonar el Proyecto

- git clone https://github.com/Acedwdev/PruebaFranquicias.git

# Configuración del Entorno

 - application properties
	spring.datasource.url=jdbc:mysql://caboose.proxy.rlwy.net:46186/railway
	spring.datasource.username=root
	spring.datasource.password=YQdMlmcafmWKEiKRqLEDRmmlCXZqHZCM
	spring.jpa.hibernate.ddl-auto=update
	spring.jpa.show-sql=true
 
# Ejecución Local

- ./mvnw spring-boot:run
 
 Con Docker:
 - docker built -t yoannyayaladev/prueba-franquicia:latest
 - docker run -d 8080:8080 yoannyayaladev/prueba-franquicia:latest
 
 Acceder a:
 - http://localhost:8080
 
# Despliegue Automático (CI/CD)

1. push a la rama main
2. GitHub Actions construye la imagen Docker
3. GitHub Actions publica la imagen en DockerHub
4. Railway detecta la nueva imagen y la ejecuta

Archivos clave:
- .github/workflows/docker.yml: contiene el workflow de GitHub Actions
- Dockerfile: define cómo se construye la imagen de la app

# Tecnologías Usadas

- Java 17
- Spring Boot
- MySQL
- Docker
- Railway
- DockerHub
- Github Actions

# Estructura del Proyecto

.
├── src/
│   └── main/java/com.franquicia.prueba/...
├── src/
│   └── main/resources
│                   └── application.properties
├── Dockerfile
├── .github/workflows/docker.yml
├── README.md
└── pom.xml

# Créditos

- Edwin Acevedo Ayala
- Desarrollador FullStack