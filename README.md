# MS3 Contact AI
   URL- http://localhost:8080/contact-service/contact  http://localhost:8080/contact/contact

## Overview
project is running on h2 in memory database.\
To use mysql uncomment h2 properties and enable mysql properties.

## To deploy on docker:
```
docker build -t mohdtabish999/contact-be:0.1 .
docker images
docker run -d -p 8080:8080 mohdtabish999/contact-be:0.1
```
## Use jave service with angular
Use [contact-ui](https://github.com/mohdtabish999/contact-ui) repo. 


## JSON 
```
{
   "Identification":{
      "FirstName":"Bob",
      "LastName":"Frederick",
      "DOB":"06/21/1980",
      "Gender":"M",
      "Title":"Manager"
   },
   "Address":[
      {
         "type ":"home",
         "number":1234,
         "street":"blah blah St",
         "Unit":"1 a",
         "City":"Somewhere",
         "State":"WV",
         "zipcode":"12345"
      }
   ],
   "Communication":[
      {
         "type":"email",
         "value":"bfe@sample.com",
         "preferred":"true"
      },
      {
         "type":"cell",
         "value":"304-555-8282"
      }
   ]
}
```
