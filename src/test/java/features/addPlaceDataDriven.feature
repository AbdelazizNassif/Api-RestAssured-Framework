Feature: Add Place To The Google maps using data driven approach
  @FAST
  Scenario Outline: Add place using api
    Given user init the request successfully data driven
    When user created place body successfully with data driven "<name>" "<language>" "<address>"
    And user make the "post" request "API_AddPlaceEP" data driven
    Then "status" status will be "OK" data driven
    And "scope" scope will be "APP" data driven
    And status code will be 200 data driven and get the "place_id" for the EndToEnd Scenario
    And user make the "get" request "API_GetPlaceEP" data driven to get the added place data
    And user check the values of name "name" language "language" and address "address" equal to "<name>" "<language>" "<address>"
    And user tries to delete "delete" with path "API_DeletePlaceEP" the newly created places for the EndToEnd scenario
    Examples:
    |name       | language          |address|
    |Abdelaziz  | English-In        | Cairo |
    |Zaki       | Arabic-In         | Alexandria |

    @DUMMY
  Scenario: Dummy Test for a purpose
    Given user init the request sucessfully
    When user created place body successfully
    Then "status" status will be "OK"



