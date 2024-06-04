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

![image](https://user-images.githubusercontent.com/32280800/137598073-4b3b3b3b-1b3b-4b3b-8b3b-4b3b3b3b3b3b.png)

## Autores 👥

| Nombre                   |                                          |
| :------------------------ | :----------------------------------------------- |
| Valentina Agudelo             | 🌱                            |
| Nicolas Ramirez             | 🌱                            |
  