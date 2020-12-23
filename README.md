# FIZZ BUZZ CODE ASSIGNMENT  

This is a Spring Boot web application building with maven .
 
Application works as web service api. You can play Fizz Buzz game by using this api.

To learn more information about game you can check here: https://en.wikipedia.org/wiki/Fizz_buzz


## Build and Run
Make sure you are using JDK 1.8 and Maven 3.x   

Open terminal and navigate to root directory

Run :
```
mvn clean package

java -jar target/fizz-buzz-rest-api.jar
```


## Test Game

```http request

http://localhost:8080/v1/fizz-buzz?move={your-answer}

http://localhost:8080/v1/fizz-buzz?move=1

```

...?move=youStart       : computer starts playing a new game

answer : 1

...?move=1              : user starts playing a new game

answer : 2

...?move={your-answer}  : you can continue next turns

computer answers each turn

## Test Ask 

You can learn correct answer for any number by using 'ask' operation 

```http request

http://localhost:8080/v1/fizz-buzz/ask/{number}-{number}-{number}

http://localhost:8080/v1/fizz-buzz/ask/1980-11-26-5

answer: 1980:FizzBuzz 11:11 26:26 5:Buzz 

```

To see all parameters and more info about api you can check http://localhost:8080/swagger-ui/ after you run it.


##Online Demo

###This is a live demo deployed to AWS :

http://oneio-env.eba-mnadebwj.us-east-2.elasticbeanstalk.com/v1/fizz-buzz?move=1
