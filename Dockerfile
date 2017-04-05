FROM tomcat:8.0.20-jre8

COPY ./target/swagger-java-api-0.1.0.war /usr/local/tomcat/webapps/swagger-java-api-0.1.0.war