Spring-boot-starter: "restLogger" 
===============================
-------------------------------------------------------------
### Description:


- Stack: [JDK 17](http://jdk.java.net/17/), Spring Boot 3.3.0, Lombok, Swagger/OpenAPI 3.0. 
- Run: `mvn install` in root directory.
- Add to pom.xml
``` 
   <dependency>
        <groupId>ru.nikitin</groupId>
        <artifactId>rest-logger-spring-boot-starter</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
```
-----------------------------------------------------
#####  To connect, set the properties
```
spring:  
  rest-logger:
    enabled: true
    level: debug 
```
-----------------------------------------------------