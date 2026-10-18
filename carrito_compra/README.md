# Carrito de Compras - Spring Boot

Proyecto backend desarrollado con Java y Spring Boot para la gestión de una tienda en línea y su carrito de compras. Utiliza una arquitectura monolítica por capas y persistencia en base de datos relacional.

## Tecnologías utilizadas
* **Java 21**
* **Spring Boot 3.3.3**
* **Spring Data JPA** (Hibernate)
* **Thymeleaf** (Motor de plantillas para el frontend)
* **MariaDB / MySQL** (Base de datos)
* **Maven** (Gestor de dependencias)
* **JUnit 5 y Mockito** (Pruebas unitarias)

## Requisitos previos
Antes de ejecutar el proyecto, asegúrate de tener instalado:
1. JDK 21
2. MariaDB o MySQL corriendo en el puerto 3306
3. Maven

## Configuración de la Base de Datos
1. Ingresa a MariaDB y crea la base de datos:
   ```sql
   CREATE DATABASE shop;
