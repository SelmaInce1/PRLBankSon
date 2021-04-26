@US016
Feature: Money transfer should be available

  Background: US016 Background access
    Given user goes to login page
    Then user enter a valid username as customer
    Then user enter a valid password as customer
    Then user logs in
    Then user clicks on My Operations
    Then user clicks on Transfer Money

  Scenario:TC001 User can select the first account as From dropdown where they receive their money from
    Then user select an account on the from box
    Then user select an account on the to box

  Scenario: TC002 User can select a balace that they want to proceed with
    Then user enter balance

  Scenario: TC003 User should provide a description for that transfer
    Then user enter description
    Then user click Make Transfer button

  Scenario: TC004 User can make sure transfer is done successfully validating the message
  an amount of the transaction
    Then user should see transfer is done successfully validating the message




