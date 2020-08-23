## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com\example\productimage\ProductImageColourServiceApplication.java` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

Lastly, you can use maven to build and test.

```shell
$ cd productimage
$ ./mvnw clean install
```

## Automatic deployments

Currently the repository has pipeline to the heroku app and has automatic builds from master branch.

## Public version

- Swagger: https://product-image.herokuapp.com/api/swagger-ui.html
- Colour API: https://product-image.herokuapp.com/api/product/colours?searchQuery=outdoor

- Curl example: curl -X GET "https://product-image.herokuapp.com/api/product/colours?searchQuery=outdoor" -H "accept: */*"
