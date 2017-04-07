package com.github.jmccloskey.at.steps;

import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

import javax.inject.Inject;
import javax.inject.Provider;
import java.net.URI;

import static org.hamcrest.MatcherAssert.assertThat;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs;

@ScenarioScoped
public class RestStepDefinitions {

    private final RequestSpecification requestSpecification;
    private URI resource;
    private ValidatableResponse response;

    @Inject
    public RestStepDefinitions(Provider<RequestSpecification> requestSpecificationProvider) {
        this.requestSpecification = requestSpecificationProvider.get();
        requestSpecification.log().all();
    }

    @Given("^I have a resource at (.*)$")
    public void I_have_a_resource_at(URI resource) throws Throwable {
        this.resource = resource;
    }

    @When("^I perform a ([GET]*)$")
    public void I_perform_a_on(String httpMethod) throws Throwable {
        if (httpMethod.toUpperCase().equals("GET")) {
            response(requestSpecification.when().get(resource).then());
        } else {
            throw new RuntimeException(String.format("Unsupported http method: %s", httpMethod));
        }
    }

    @And("^I should get the response body:$")
    public void I_should_get_the_response_body(String expectedTemplate) throws Throwable {
        assertThat(response.extract().body().asString(), sameJSONAs(expectedTemplate).allowingAnyArrayOrdering().allowingExtraUnexpectedFields());
    }

    @Then("^the response code should be (\\d+)$")
    public void the_response_code_should_be(int expectedStatus) throws Throwable {
        response.assertThat().statusCode(expectedStatus);
    }

    private void response(ValidatableResponse response) {
        this.response = response;
        response.log().all();
    }

}
