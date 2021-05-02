
@US008
Feature: US008 Password segment on Homepage should be editable

  Background: User can sign in and navigate to their info
    Given user goes to login page
    Then user signs in as a customer
    And user navigates to password
    And user enter old password to current password box

  Scenario: The old password should not be used
    And user should not enter the old password  into new password box
    Then user should see the error message about the password


  Scenario:  "There should be at least 1 lowercase char for stronger password and
  see the level chart change accordingly"
    And user should enter at least 1 lowercase char into new password box
    Then the indicator of password strength turn to orange or green color accordingly


  Scenario:  There should be at least 1 uppercase char and see the level chart change accordingly

    And user should enter at least 1 uppercase char into new password box
    Then  the indicator of password strength turn to orange or green color accordingly


  Scenario:There should be at least 1 digit and see the level chart change accordingly
    And user should enter at least 1 digit into new password box
    Then the indicator of password strength turn to orange or green color accordingly

  Scenario: There should be at least 1 special char and see the level bar change accordingly
    And  user should enter at least 1 special char into new password box
    Then  the indicator of password strength turn to orange or green color accordingly


  Scenario: There should be at least 7 chars for a stronger password
    And user should enter at least 7 chars into new password box
    Then the indicator of password strength turn to orange or green color accordingly

  Scenario: The new passwoerd should be confirmed
    And User should enter your valid password into new password box
    And User should enter your same password into new password confirmation box
    Then User should not see the error message
