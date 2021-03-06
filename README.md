# Swagger Java API

This is starting point for building APIs from a given [Swagger Definition](api/src/main/resources/swagger.yaml).
It uses the [Swagger Codegen Maven Plugin](https://github.com/swagger-api/swagger-codegen/tree/master/modules/swagger-codegen-maven-plugin) 
to generate boilerplate API code.

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

Try out the status endpoint:
```bash
$ curl localhost:8080/v1/status
```
Response should be similar to below:
```json
{
    "name": "Swagger Java API",
    "status": "OK",
    "checks": []
}
```

Re-builds of war should be automatically picked up and deployed by a running API container.

#### Debugging 

Start in debug mode instead:
```bash
$ docker-compose up api-debug
```

#### Acceptance Testing

Given the API is already running:
```bash
$ docker-compose up acceptance-test
```

#### Swagger Editor

```bash
$ docker-compose up swagger-editor
```

Open [localhost 9000](http://localhost:9000/#/) in a browser to view the Swagger Editor. 
This allows you to try out or make changes to the API.

### Non-docker

Generate sources and war
```bash
mvn clean package
```
