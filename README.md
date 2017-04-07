# Swagger Java API

This is boilerplate setup for building APIs from a given [Swagger Definition](api/src/main/resources/swagger.yaml).
It uses the [Swagger Codegen Maven Plugin](https://github.com/swagger-api/swagger-codegen/tree/master/modules/swagger-codegen-maven-plugin) to generate the web.xml, bootstrap, controller, and model classes needed

## Running

### Docker

Generate sources and war:
```bash
$ docker-compose up build-war
```

Run API (inside tomcat container):
```bash
$ docker-compose up api
```

### Acceptance Testing

Given the API is already running:
```bash
$ docker-compose up acceptance-test
```

Re-builds of war should be automatically picked up and deployed by a running API container.

### Non-docker

Generate sources and war
```bash
mvn clean package
```
