# Proyecto de Activación de Usuarios

Este proyecto es una aplicación de Spring Boot que maneja la activación de usuarios utilizando JPA para la persistencia de datos. La aplicación proporciona una API REST para crear, leer, actualizar y eliminar usuarios y sus estados.

## Requisitos

- Java 17
- Maven 3.6.0 o superior
- MySQL

## Configuración

Configura tu archivo `application.properties` con las credenciales de tu base de datos:

```properties
spring.application.name=user.activation

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect
spring.datasource.driver-class-name = com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/demo
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
```
## Ejecución

Para ejecutar la aplicación, utiliza el siguiente comando en la raíz del proyecto:
```bash
mvn spring-boot:run
La API estará disponible en http://localhost:8080.
```

## Uso de la API

### Endpoints de Usuarios
- `GET /api/usuarios`: Obtener todos los usuarios.
- `GET /api/usuarios/{idUser}`: Obtener un usuario por ID.
- `POST /api/usuarios`: Crear un nuevo usuario.
- `PUT /api/usuarios`: Actualizar un usuario existente.
- `DELETE /api/usuarios/{idUser}`: Eliminar un usuario por ID.

### Endpoints de Estados
- `GET /api/estado`: Obtener todos los estados.
- `GET /api/estado/{idState}`: Obtener un estado por ID.
- `POST /api/estado`: Crear un nuevo estado.
- `PUT /api/estado`: Actualizar un estado existente.
- `DELETE /api/estado/{idState}`: Eliminar un estado por ID.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o crea un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT.
