# Kafka sample

# Requirements
 
  1. Build a Kafka streamer that reads from 1 topic and publish into 2 different topics
  2. Input topic will have a payload of first name, last name, date of birth.
  3. Logic: when age is even number, publish to topic: CustomerEVEN, if age is odd number, publish to topic: CustomerODD
  4. Build using Maven/Gradle and Spring Boot.


# Skills used in this exercise

## 1. Spring Boot.       
      As Spring boot can quick start a web application.
## 2. Maven
	  To manage the Jar files.	  

# Before run the application

- Install Maven and JDK11

# Run locally in JDk11 Env
1. go to kafkasample folder
2. run ' mvn clean package spring-boot:run '