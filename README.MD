### Run the API
type the following in the root directory of the application and Sptring Boot will startup. After that you can interact with the API in another terminal.
```bash
$ mvn spring-boot:run
```

### adds a new customer
```bash
$ curl -H "Content-Type: application/json" -X POST -d '{
    "firstName": "Kristoffer",
    "lastName": "Solberg"
}'  http://localhost:8080/customers 
```

### retrieves all customers
```bash
$ curl http://localhost:8080/customers
```

### updates customer with id 1
```bash
$ curl -H "Content-Type: application/json" -X PUT -d '{
    "id": 1,
    "firstName": "Kristoffer",
    "lastName": "Rakstad"
}'  http://localhost:8080/customers/1
```

### deletes customer with id 1
```bash
$ curl -X DELETE http://localhost:8080/customers/1
```
