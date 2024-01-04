# JAVA-SE-Course-info-api

## Requirements
- Store courses in a database
- Expose courses over REST API
- Allow addition of notes through the API
- Fill the database with courses (automated)

### Application flow
![screenshot.png](..%2F..%2F..%2FDownloads%2Fscreenshot.png)

## Tools
- Build tool
- Web API call
- Json handling
- REST API + server
- Database interaction 
- Testing

### Option 1, Java Frameworks: 
Spring Boot, Java EE, Quarkus, Micronaut etc.

#### Pros: 
- Takes care of a lot of these tools for us
- Most likely we will use these frameworks in a real world application. 

#### Cons: 
- For this application my goal is learning and building using java
- I can learn frameworks after I am comfortable with Java SE projects 

### Option 2, Java + libraries: 
We don't need dependency injection for this level of application, so we can use Java to handle most of these tools to build, run and serve our application 

`Libraries: `
- Maven: Build tool
- Jackson: JSON
- JAX-RS/ Jersey: REST
- H2 database: JDBC API Access
- JUnit: Testing

#### Pros:
- Only need to know Java SE, Collections and Streams

#### Cons:
- This is not how java development happens in real world