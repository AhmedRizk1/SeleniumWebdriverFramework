Feature: Cart Checkout scenario
  I want to Test full cycle of items checkout

  Scenario: Cart Checkout scenario
    Given User In Home Page
    When User Login With Authorized Account
    And User Select Product
    And User compelet check out steps with bank wire option
    Then The orede added to orders List
