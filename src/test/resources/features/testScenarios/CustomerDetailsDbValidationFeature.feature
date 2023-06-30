@DB
Feature: CustomerDetails

  Scenario: Test CustomerDetails
    Given Database setup is done
    When User is able to connect to the customer details table
    Then User is able to retrieve customer details records
    Then User is able to verify the customer details records
      | Customer Name | Customer Billing Address |
      | Kedar         | Pune                     |
