# AppMeteo

AppMeteo è un’applicazione Java basata su Spring Boot che espone un servizio REST per recuperare i dati meteo attuali di città italiane utilizzando l’API di OpenWeather.  
Include autenticazione Basic Auth per proteggere l’accesso al servizio.

---

## Caratteristiche

- API REST con endpoint GET per ottenere il meteo attuale  
- Integrazione con OpenWeather, con chiave API configurabile  
- Autenticazione Basic Auth configurabile con username e password codificati in Base64  
- Configurazione esterna tramite `application.properties`  

---

## Tecnologie

- Java 17+  
- Spring Boot 3.x  
- Spring Security (per Basic Auth)  
- OpenWeather API  
- Maven  

---
