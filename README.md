# Prime Service
Microservice to calculate prime numbers

## Building
``` 
mvn clean package
```
* __Java version__: 11
* __Maven version__: 3.6.3

## Running
```
 java -jar target/prime-service-0.0.1.jar 
```
The service runs on port __8080__

## API


#### `GET /primes`

| request param | required? | validation |
|---------------|-----------|-------|
| limit         | yes       | \>=2  |

##### Example
```
curl http://localhost:8080/primes?limit=50
```