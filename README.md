
This  application gives you a basic user registration form that receives user data and stores this on a server.
And the server does some sort of validations internally and using an external API. The API  in the server side validates
postal codes using an external API and stores the validated data in an H2 database.

#Prerequisites
Before you begin, ensure you have the following installed:

1. Java Development Kit (JDK): Download and Install JDK
2. Maven: Download and Install Maven

#Backend Setup

 ####Build and run the Spring Boot application:
1. mvn clean install - for building the backend application
2. mvn spring-boot:run - to run the application or to start the server

By default the server will be up and running on port 8080.

##Accessing the application or Usage
1. When the server is started, access the application using the following url:
   http://localhost:8080/form.html
2. Fill in the user info and submit the application.
3. When you submit the frontend.js sends data to back end API(post), the api validates
the request using spring boot annotations and additionaly the postal code is validated by calling Brings open
API.
4. After all validation is success the data is saved in h2 database(in-memory) which is used as local
database for this application


