Feature: withdrawal use case
  Scenario: Making a withdrawal and ask the statement
    Given I withdraw 50 euros
    When I ask for the statement
    Then My balance should be -50 Euros