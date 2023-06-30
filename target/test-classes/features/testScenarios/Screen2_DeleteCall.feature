Feature: Screen Name :  Test  Request and verify response of API using REST Assured

  Background: 
    Given the user is on "Screen Name" screen
    And the user request method as "DELETE"

  Scenario: TC_04 Perform DELETE request and verify the response
    And user deletes the record
    And the user verify status code as 200
