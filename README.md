# Circuit Breaker - Parcial

Este proyecto es una implementación de un circuit breaker en el lenguaje de programación X. 🔌

## Descripción

El circuit breaker es un patrón de diseño que se utiliza para mejorar la resiliencia y la tolerancia a fallos en sistemas distribuidos. Permite controlar y proteger las llamadas a servicios externos, evitando que una falla en uno de ellos afecte al sistema completo. 🚀

## Funcionamiento

El circuit breaker monitorea continuamente el estado de un servicio externo. Si el servicio comienza a responder con errores o se vuelve inaccesible, el circuit breaker se activa y bloquea las llamadas subsiguientes al servicio. En su lugar, se pueden tomar acciones alternativas, como devolver una respuesta predeterminada o intentar acceder a un servicio de respaldo. 🚦

Una vez que el servicio se recupera, el circuit breaker se desactiva y permite que las llamadas vuelvan a fluir normalmente. ✅

## Comandos

| Command                   | Action                                           |
| :------------------------ | :----------------------------------------------- |
| `mvn spring-boot:run`             | Run service                            |
| `mvn clean install`             | Build service                            |

## Endpoints

| Método | Endpoint                   | Descripción                                           |
| :----- | :------------------------ | :--------------------------------------------------- |
| POST   | /customers                | Crea un nuevo cliente                                 |
| GET    | /customers/{customerId}   | Obtiene los detalles de un cliente específico         |
| PUT    | /customers/{customerId}   | Actualiza los detalles de un cliente específico       |
| DELETE | /customers/{customerId}   | Elimina un cliente específico                         |

## Swagger

http://localhost:8500/swagger-ui/index.html#/ 📚

## Dependencias

- Java 11 ☕️
- Spring Boot 🍃
- Maven 🧰


## Capturas 📸
![WhatsApp Image 2024-06-04 at 12 07 08 PM](https://github.com/VaAgudelo17/Circuit-breaker-parcial/assets/114451968/f5fd5adf-ea25-4948-ae0d-67a50716eb2d)


## Autores 👥

| Nombre                   |                                          |
| :------------------------ | :----------------------------------------------- |
| Valentina Agudelo             | 🌱                            |
| Nicolas Ramirez             | 🌱                            |
  
