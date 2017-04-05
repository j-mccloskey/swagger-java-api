# Swagger Java API

This is boilerplate setup for building APIs from a given [Swagger Definition](src/main/resources/swagger.yaml).
It uses the [Swagger Codegen Maven Plugin](https://github.com/swagger-api/swagger-codegen/tree/master/modules/swagger-codegen-maven-plugin) to generate the web.xml, bootstrap, controller, and model classes needed

## Generating sources and war

`mvn clean package`