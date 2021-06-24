Feature: Add Place To The Google maps

  Scenario: Add place using api
    Given user init the request sucessfully
    When user created place body successfully
    And user make the post "" request
    Then "status" status will be "OK"
    And "scope" scope will be "APP"
    And status code will be 200
