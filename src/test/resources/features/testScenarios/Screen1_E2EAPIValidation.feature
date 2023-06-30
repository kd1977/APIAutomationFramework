Feature: Screen Name :  Test  Request and verify response of API using REST Assured

  Background: 
    Given the user is on "Screen Name" screen

  Scenario Outline: TC_01 Perform POST request and verify the response
    And the user request method as "POST"
    And the user creates a new record and store the new generated id
      | JsonFileName   |
      | <JsonFileName> |
    And the user verify status code as 201

    Examples: 
      | JsonFileName  |
      | accounts.json |

  Scenario Outline: TC_02 Perform PUT request and verify the response
    And the user request method as "PUT"
    And the user updates a record for new generated id
      | JsonFileName   |
      | <JsonFileName> |
    And the user verify status code as 200

    Examples: 
      | JsonFileName        |
      | accountsUpdate.json |

  #Scenario: TC_03 Perform GET request and verify the response
 #   And the user request method as "GET"
  #  And the user get the record for new generated id
  #  And the user verify status code as 200

  Scenario: TC_04 Perform DELETE request and verify the response
    And the user request method as "DELETE"
    And the user delete a record for new generated id
    And the user verify status code as 200
