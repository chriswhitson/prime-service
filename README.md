# Prime Service
Microservice to calculate prime numbers

## Building
``` 
mvn clean package
```

## Running
```
java -jar target/prime-service-0.0.1-SNAPSHOT.jar 
```

## API
__port__: 8080

#### GET /primes

-----------------------------------------
| request param | required? | validation |
|---------------|-----------|-------|
| limit         | yes       | \>=2  |

##### Example
```
curl http://localhost:8080/primes?limit=50
```