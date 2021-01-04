Feature: Validating Place API

  Scenario: Verify if a place can be added successfully using AddPlaceAPI
    Given Add Place Payload is available
    When User calls AddPlaceAPI with Post http request
    Then The API call is sucessful with status code 200
    And "status" in response body is "OK"