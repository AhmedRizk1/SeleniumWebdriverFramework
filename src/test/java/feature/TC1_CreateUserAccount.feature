Feature: Create New User Account
  I want to Create New User Account

  Scenario: Check Create New User Account
    Given User in home page
    When User Register With the New Account Email
    And User Fill The Presonal Information
    Then The registration page displayed successfully
