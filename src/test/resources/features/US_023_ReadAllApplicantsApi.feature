@US023
Feature: US_023 System should allow to read all Applicants using api end point "https://gmibank-qa-environment.com/api/tp-account-registrations"

  Scenario: TC_01 Read All Applicants and Validate
    Given Authorized user goes to api end point "https://gmibank-qa-environment.com/api/tp-account-registrations"
    And Authorized user validate data