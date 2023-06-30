Feature: Screen Name :  Test  Request and verify response of API using REST Assured

  Background: 
    Given the user is on "Screen Name" screen
    And the user request method as "POST"

  Scenario Outline: TC_01 Perform POST request and verify the response
    And user create a record
      | JsonFileName   |
      | <JsonFileName> |
    And the user verify status code as 201

    Examples: 
      | JsonFileName  |
      | accounts.json |
