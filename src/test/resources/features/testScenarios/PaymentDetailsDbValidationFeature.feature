@DB
Feature: PaymentDetails 

  Scenario: Test PaymentDetails
    Given Database setup is done
    When User is able to connect to the payment details table
    Then User is able to retrieve payment details records
    Then User is able to verify the payment details records
