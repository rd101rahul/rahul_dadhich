# QA-Engineer Spring Boot Coding Challenge

## Task
The goal is to create one positive and one negative test case with the Spring Boot framework for the following testing-layer of the [microservice test pyramid](https://martinfowler.com/articles/microservice-testing/#conclusion-test-pyramid):
* Unit test
* Integration test
* Component test
* End-To-End test

Please create:
* a git branch with the name firstname_lastname
* a test class for each layer containing the tests 

Feel free to research the internet and add dependencies to the maven project.

## Application
The application is build with Spring boot and offers two endpoints:

### Registration of user
#### Request
POST /registration
Body:
{
"username": "",
"password": ""
}

#### Response

201 User was created

422 Validation Error

400 Syntactically invalid request

Username must be at least 6 digits long and a maximum of 32 digits
Password must be at least 8 digits long and a maximum of 32 digits


### Retrieval of user information
#### Request
GET /users/{username}

#### Response

200 User found

404 User not found

Body:
{
"id": "",
"username": "",
"password": ""
}

## Running the application
The application including a running database can be started by executing inside the project folder mvn spring-boot:run or by running the java class SpringBootCodingChallenge.java



----------------------------
----------------------------
# QA-Engineer Spring Boot Coding Challenge Solution
-----------------------------
-----------------------------

## Additions to the Framework

1. added src/test/java folder to accomodate test cases, runner class, common ultilities and test data
2. added a variable json under src/main/resources for user registration request body
3. added packages under src/test/java
	a. com/ratepay/testcases - each test class and runner class
	c. com/ratepay/utils - constant class with data and utils class with common utilities use by all 	     		cases.
4. required dependencies on pom.xml

## Run Tests

Test cases needed to be run can be added in TestRunner.java
"mvn test" command can be used to run Runner class

## Reports

- Normal text reports can be seen under target > surefire-reports
- added surefire plugin in pom.xml for html reports
	to generate html reports:

	run command "mvn surefire-report:report" instead of "mvn test"
	navigate to target/site/surefire-report.html for report with more details
	
