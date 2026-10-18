# Bitácora de Desarrollo - Proyecto CarritoCompras (Spring Boot)

Registro de avances, problemas y soluciones implementadas durante el desarrollo del proyecto.

| Fecha | Avance realizado | Problema o decisión | Solución / aprendizaje | Commit relacionado |
| :--- | :--- | :--- | :--- | :--- |
| 17/10/2026 | Configuración inicial del entorno, MariaDB y Spring Boot. | Error de conexión a la base de datos (`Access denied for user 'root'`). El sistema no reconocía al usuario administrador local. | Se ingresó a MariaDB en modo seguro (`--skip-grant-tables`) para reconfigurar los privilegios. Se creó el usuario `shopuser` y la base de datos `shop`. | `b34836c` |
| 17/10/2026 | Levantamiento del backend y frontend del CarritoCompras. | El servidor fallaba al arrancar por `Port 8080 was already in use`. | Se identificó el proceso antiguo y se detuvo con `fuser -k 8080/tcp`. Se reinició la aplicación Spring Boot correctamente. | `b34836c` |
| 17/10/2026 | Persistencia del carrito en base de datos. | La clase `CartItem` estaba diseñada solo para memoria (HashMap), incumpliendo el requisito de las 2 tablas del proyecto. | Se convirtió `CartItem` en una entidad `@Entity`, se creó `CartItemRepository` y se actualizó `ShopServiceImpl` para usar la base de datos. | `97e399b` |
| 17/10/2026 | Pruebas unitarias para CarritoCompras. | Se necesitaba cubrir la capa de servicio con JUnit 5 y Mockito sin afectar la base de datos real. | Se implementaron pruebas unitarias simulando el repositorio. Se ejecutó `mvn test` con éxito (3 pruebas pasando, `Failures: 0`). | `97e399b` |
| 17/10/2026 | Limpieza del repositorio Git. | La carpeta `target/` (archivos compilados y `.jar` de 52 MB) se subió a GitHub, lo cual no es recomendado. | Se agregó la regla `target/` al archivo `.gitignore` y se eliminó el rastro de la caché de Git con `git rm -r --cached target`. | `97e399b` |
