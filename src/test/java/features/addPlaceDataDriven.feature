Feature: Add Place To The Google maps using data driven approach

  Scenario Outline: Add place using api
    Given user init the request successfully data driven
    When user created place body successfully with data driven "<name>" "<language>" "<address>"
    And user make the post request data driven
    Then "status" status will be "OK" data driven
    And "scope" scope will be "APP" data driven
    And status code will be 200 data driven

    Examples:
    |name       | language          |address|
    |Abdelaziz  | English-In        | Cairo |
    |Zaki       | Arabic-In         | Alexandria |


