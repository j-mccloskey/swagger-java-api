Feature: Status Resource
  In order to ensure the service is running ok
  I able to see the status of the application
  So that I can be alerted to any problems

  Scenario: Application is up
    Given I have a resource at /v1/status
    When I perform a GET
    Then the response code should be 200
    And I should get the response body:
    """
      {
        "name": "Swagger Java API",
        "status": "OK",
        "checks": [
        ]
      }
    """