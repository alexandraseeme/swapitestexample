# Example test project

###Purpose:
The project is created to cover the following test scenario based on example API: https://swapi.co

1. Create a basic test project with a proper structure, i.e. classes, resources, tests etc. are logically separated 
2. Create a test, which will verify the following data using REST Api: 
    - Given a base url: https://swapi.co/ 
    - Get a resource: /people/1/ 
    - Change all links in “films” array with actual movie titles 
    - Assert that received result (whole character data containing substituted films data) equals to the expected data
    
###Instruction:

In order to run the project please follow the instructions below:

1. Clone this github project 
2. cd to your project directory and execute: `mvn clean test`

###Requirements and tools description:
- Java 8 or later
- Maven 3.x

Tools:
- Rest-Assured for building an api client: http://rest-assured.io
- To generate JAVA class from JSON http://www.jsonschema2pojo.org/ has been used


