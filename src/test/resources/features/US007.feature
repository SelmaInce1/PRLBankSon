
@US007
Feature: US007 System should not allow to make updates with invalid credentials

  Background: User can sign in and navigate to their info
    Given user goes to login page
    Then user signs in as a customer
    And user navigates to user info

  Scenario: TC001 System should not allow to make updates with invalid credentials
    And User clicks on email text box
    And User enters an invalid email without @ sign to email text box
    Then user should see the error message for email


  Scenario: TC002 System should not allow to make updates with invalid credentials
    And User clicks on email text box
    And User enters a valid email with extensions to email text box
    Then user should not see the error message for email



  Scenario: TC00 There should not be an option of any other language other than Englisg or Turkish

    And User can enter data in only  English and Turkish languages, so the user can not enter data on other languages






























