
@wip
Feature: US007 System should not allow to make updates with invalid credentials

  Background: User can access and navigate to their info
    Given user is on main page
    When user clicks to icon menu
    Then user clicks on register button
    And user navigate on Register page

  Scenario: TC001 System should not allow to make updates with invalid credentials
    Given user on the "prlbank_url"
    And User navigates to registration page
    And User clicks on email textbox
    And User enters an invalid email
    Then user should see the error message

  Scenario: TC002 There should not be an option of any other language other than Englisg or Turkish
      Given user on the "prlbank_url"
      And User navigates to registration page
      Then User can not enter data in only  English and Turkish languages, so the user can not enter data on other languges
      And user should see the error message















