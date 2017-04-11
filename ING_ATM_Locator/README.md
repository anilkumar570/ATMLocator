ING_ATM_Locator Starts at http://localhost:8080/index

This project is based on the sample project 'spring-security-samples-boot-insecure' distributed with Spring Security Master 4.1.x .

Instead of using the in-memory authentication module seen in Spring Security Master 4.1.x, this project uses a Camel route. 
On top of this, the UI was constructed with a combination of BootStrap, EcmaScript and HandlebarsJS. 

The GET request http://localhost:8080/locate/atms works in both the UI and Postman.

The GET request http://localhost:8080/locate/atms/{city} does not currently work due to a JSON serialization issue which could not be fixed with Jackson. However, the AllATMsInCity() function found in src.main.resources.static.javascript.page.js is a temporary fix that performs this request through the DOM.    

