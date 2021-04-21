Feature: US008 Password segment on Homepage should be editable

  Background: User can access and navigate to their info
    Given user is on main page
    When user clicks to icon menu
    Then user clicks on register button
    And user navigate on Register page


  Scenario: The old password should not be used
    And user should not enter the old password  into new password box
    Then user should see the error message about the password


  Scenario:  "There should be at least 1 lowercase char for stronger password and
    see the level chart change accordingly"
    And user should enter at least 1 lowercase char into new password box
    Then the indicator of password strength turn to green by increasing accordingly


  Scenario:  There should be at least 1 uppercase char and see the level chart change accordingly

    And user should enter at least 1 uppercase char into new password box
    Then  the indicator of password strength turn to green  by increasing accordingly


  Scenario:There should be at least 1 digit and see the level chart change accordingly
    Given user should enter at least 1 digit into new password box
    Then the indicator of password strength turn to green by increasing accordingly

  Scenario: There should be at least 1 special char and see the level bar change accordingly
    Given  user should enter at least 1 special char into new password box
    Then  the indicator of password strength turn to green by increasing accordingly



  Scenario: There should be at least 7 chars for a stronger password




  Scenario: The new passwoerd should be confirmed