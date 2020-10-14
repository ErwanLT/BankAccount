Feature: testing the print statement use case
  Scenario: Multiple Deposit / Withdraw and ask the statement balance
    Given I deposit 100 euros
    And I withdraw 80 euros
    When I ask for the statement
    Then My balance should be 20 Euros