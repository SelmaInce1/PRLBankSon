@US003
  Feature: US003 Registration page should restrict password usage to a secure
    and high level passcode
    Background: User can access and navigate to their info
      Given user is on main page
      When user clicks to icon menu
      Then user clicks on register button
      And user navigate on Register page

    Scenario: TC01_US003 There should be at least 1 lowercase char for stronger password and
    see the level chart change accordingly
      Then user navigate in the New Password box and provides a lowercase letter
      And user should be see change on the Password strength first bar

    Scenario: TC02_US003 There should be at least 1 uppercase char for stronger password and
    see the level chart change accordingly
      Then user navigate in the New Password box and provides a uppercase letter
      And user should be see change on the Password strength second bar

    Scenario: TC03_US003 There should be at least 1 digit and see the level chart change accordingly
      Then user navigate in the New Password box and provides a digit
      And user should be see change on the Password strength third bar

    Scenario: TC04_US003 There should be at least 1 special char and see the level bar change accordingly
      Then user navigate in the New Password box and provides a special char
      And user should be see change on the Password strength fourth bar

    Scenario: TC05_US003 There should be at least 7 chars for a stronger password
      Then user navigate in the New Password box and provides any three chars
      And user should be see change on the Password strength fifth bar