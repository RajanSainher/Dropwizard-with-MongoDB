# dwMongo

How to start the dwMongo application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/dwMongo-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Add the following dependencies to your pom.xml file
---
    <dependency>
            <groupId>org.mongodb</groupId>
            <artifactId>mongo-java-driver</artifactId>
            <version>3.5.0</version>
        </dependency>

        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.1</version>
        </dependency>
        <dependency>
            <groupId>com.wordnik</groupId>
            <artifactId>swagger-annotations_2.9.1</artifactId>
            <version>1.0.2</version>
        </dependency>
#clean and build the project after adding these dependencies this will install all dependencies to the project

##Add configuration to your .yml or .yaml file
---
    `mongoHost : localhost`
    `mongoPort : 27017`
    `mongoDB : softwaredevelopercentral`
    `collectionName: employees`
Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
