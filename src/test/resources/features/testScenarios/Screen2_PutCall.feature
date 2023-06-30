Feature: Screen Name :  Test  Request and verify response of API using REST Assured

  Background: 
    Given the user is on "Screen Name" screen
    And the user request method as "PUT"

  Scenario Outline: TC_02 Perform PUT request and verify the response
    And user update the record
      | JsonFileName   |
      | <JsonFileName> |
    And the user verify status code as 200

    Examples: 
      | JsonFileName        |
      | accountsUpdate.json |
