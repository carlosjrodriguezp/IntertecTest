# IntertecTest

Rest Services in Java for validating user names from an Apache Derby DB.

## Getting Started

In order to give solution to the Username List Problem, it was designed 
this java project, which contains 2 services on a REST architecture:
```
1.- http://localhost:8080/IntertecTest/users/checkName/{userName} --> GET method, for validating the userName given.
```
```
2.- http://localhost:8080/IntertecTest/users/restrictedWord/{restrictedWord} --> POST, for saving new restrictedWords into the DB.
```
This repo includes:

- Apache Derby grab files for recreating the tables needed (../src/sql/*.grab).
- Libraries and dependencies (../lib)
- JUnit tests configured

## Deployment

Simple steps to run on an Apache Tomcat 8 - required this version:
- It could be deployed from any IDE (Eclipse/NetBeans) to a local Apache Tomcat 8 environment.
- The database and tables have to be recreated and then, if needed, configure the context.xml with the new data for the connection.
- From any RESTClient reach the uri for each service described above.
