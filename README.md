# Simple REST API in Java with Spring

Test app:

```bash
mvn test  
```

Build app:

```bash
mvn package  
```

Start app:

```bash
java -jar target/api-0.0.1-SNAPSHOT.jar 
```

Containerizing app:

```bash
docker build -t sebastian-czech/simple-rest-api-java-spring .
```

Run app in container:

```bash
docker run -p 48080:48080 sebastian-czech/simple-rest-api-java-spring
```