# shop3layers — Spring Boot MVC (3 capas)

Capas:
- **Controller (Web)**: recibe peticiones y orquesta la vista (Thymeleaf).
- **Service (Business)**: lógica de negocio y gestión del carrito.
- **Repository (Persistence)**: acceso a BD con Spring Data JPA.

## Ejecutar
```bash
mvn spring-boot:run
# http://localhost:8080
```
**H2 en memoria**, semillas en `src/main/resources/data.sql`.

## Estructura
```
shop3layers/
  src/main/java/com/example/shop3layers/
    controller/ShopController.java
    service/ShopService.java, ShopServiceImpl.java
    repository/ProductRepository.java
    domain/Product.java, CartItem.java
  src/main/resources/
    templates/index.html, cart.html
    static/style.css
    application.properties, data.sql
```
