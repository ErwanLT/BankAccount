Feature: deposit use case
  Scenario: Making a deposit and ask the statement
    Given I deposit 100 euros
    When I ask for the statement
    Then My balance should be 100 Euros