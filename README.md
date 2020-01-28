# Knowledge test in Spring Boot and MongoDB

Development of a simple application using Spring Boot and MongoDB. 
This small project was made due to a personal challenge, in order to get to know the mongoDB bank.


## Endpoints
POST: http://localhost:8080/api/request/create

`
[
     {
         "code": 0,
         "type": 1,
         "description": "Test 1...",
         "date": 1579982682
     },
     {
         "code": 1,
         "type": 1,
         "description": "Test 2...",
         "date": 1579982682
     },
     {
         "code": 2,
         "type": 1,
         "description": "Test 3..",
         "date": 1579982682
     }
 ]`

GET: http://localhost:8080/api/request/getall

GET: http://localhost:8080/api/request/getbyid/<id>

UPDATE: http://localhost:8080/api/request/update/<id>
`{
     "type": 2,
     "description": "Teste update f...",
     "date": 1579982682
 }`

DELETE: http://localhost:8080/api/request/delete/<id>

DELETE: http://localhost:8080/api/request/deleteall

Technologies used: Java 8, MongoDB, Maven and Spring Boot. 

## License
Feel free to use, extend and submit a pull request.