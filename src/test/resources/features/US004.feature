Feature: US004 Login page should accessible with valid credentials

  Background:
    And User navigates to Sign In Page

  @loginpage
  Scenario: TC001 There should be a valid username and password validating the success message to login

    Then User provides a valid username "username"
    And User provides a valid  password "password"
    And User click on sign in button
    Then User verifies that user logined successfully



  @cancellogin
  Scenario:  TC002 There should be an option to cancel login
    When User provides valid username "username" and password "password"
    And User clicks on cancel button
    Then User can cancel to sign in


