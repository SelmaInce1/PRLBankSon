@US006
Feature: User info segment (User Settings) should be editable

  Background: User can sign in and navigate to their info
    Given user goes to login page
    Then user signs in as a customer
    And user navigates to user info

    Scenario Outline: User can update their first name
      Given user updates "<firstname>", lastname "<lastname>", and email "<email>"
      When user selects turkish option from dropdown "<From>"
      Then user clicks save button
      Then user can see the aprroved message

      Examples:
        |firstname  | lastname|   email     |
        |    Refia  |  Sen    |  ref@gm.com |
