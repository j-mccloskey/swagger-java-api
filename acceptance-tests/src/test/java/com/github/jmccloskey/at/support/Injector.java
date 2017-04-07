package com.github.jmccloskey.at.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.*;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.guice.CucumberModules;
import cucumber.runtime.java.guice.InjectorSource;
import cucumber.runtime.java.guice.ScenarioScoped;

public class Injector implements InjectorSource {

    @Override
    public com.google.inject.Injector getInjector() {
        return Guice.createInjector(Stage.PRODUCTION, CucumberModules.SCENARIO, new YourModule());
    }

    private class YourModule implements Module {

        public void configure(Binder binder) {}

        @Provides
        @Singleton
        ObjectMapper objectMapper() {
            return new ObjectMapper();
        }

        @Provides
        @ScenarioScoped
        RequestSpecification restRequestSpec() {
            RestAssured.baseURI = "http://" + TestConfig.host();
            RestAssured.port = 8080;
            RestAssured.basePath = "";
            RestAssured.useRelaxedHTTPSValidation();
            return RestAssured.given();
        }

    }
}
