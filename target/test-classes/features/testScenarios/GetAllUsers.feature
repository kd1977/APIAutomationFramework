Feature: Screen Name :  Test  Request and verify response of API using REST Assured

  Background: 
    Given the user is on "Screen Name" screen
    And the user request method as "GET"

  Scenario: TC_03 Perform GET request and verify the response
    And user get All records
    And the user verify status code as 200
