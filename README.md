# Scout Maven Demo Cravings Bakery
To build: `mvn package`

To run:

 1. setup a postgres db with username "initech" and password "pass123" and import schema.sql
 2. `mvn spring-boot:run` and browse to http://localhost:8080/balance

To scan: `mvn -U package scout:scan`

To build, scan, & run: `mvn install spring-boot:run`
