@US002
Feature: System should not allow anyone to register with invalid credentials

  Background: User will sign in
    Given user is on main page
    When user clicks to icon menu
    Then user clicks on register button

  Scenario: TC001_Any field on the registration page should not be left blank - positive testing
    When user clicks on SSN text box and provide an SSN number
    Then user clicks on first name text box and provide a first name
    Then user clicks on last name text box and provide a last name
    Then user clicks on address text box and provide an address
    And user clicks on mobilephone text box and provide a mobile phone
    And user clicks on username and provide a username
    Then user clicks on email text box and provide an email
    Then user clicks on new password text box and provide a password
    And user clicks on new password confirmation text box and provide password confirmation
    And user clicks on register button on registration page
    Then user should see the approval message

  Scenario: TC002_Any field on the registration page should not be left blank- negative testing
    When user clicks on SSN text box and provide an SSN number
    Then user clicks on first name text box and provide a first name
    Then user clicks on last name text box and provide a last name
    Then user clicks on address text box and provide an address
    And user clicks on mobilephone text box and provide a mobile phone
    And user clicks on username and provide a username
    Then user clicks on email text box and provide an email
    Then user clicks on new password text box and provide a password
    And user leaves new password confirmation text box blanked
    And user clicks on register button on registration page
    Then user should see rejection message

  Scenario: TC003-SSN number cannot be of any chars nor spec chars except "-" - positive testing
    When user clicks on SSN text box and provide an SSN number
    Then user clicks on register button on registration page
    Then user should not see SSN is not valid error message

  Scenario: TC004-SSN number cannot be of any chars nor spec chars except "-" - negative testing
    When user clicks on SSN text box and provide an invalid SSN number
    Then user clicks on register button on registration page
    Then user should see SSN is not valid error message

  Scenario: TC005-Mobilephone number cannot be of any chars nor spec chars except "-" - positive testing
    When user clicks on mobilephone text box and provide a mobile phone
    Then user clicks on register button on registration page
    Then user should not see mobile phone is not valid error message

  Scenario: TC006-Mobilephone number cannot be of any chars nor spec chars except "-" -negative testing
    When user clicks on mobilephone text box and provide an invalid mobile phone
    Then user clicks on register button on registration page
    Then user should see mobile phone is not valid error message

  Scenario: TC007-Email id cannot be created without "@" sign and "." extensions - positive testing
    Then user clicks on email text box and provide an email
    Then user clicks on register button on registration page
    Then user should not see this field is invalid error message

  Scenario: TC008-Email id cannot be created without "@" sign and "." extensions - negative testing
    Then user clicks on email text box and provide an invalid email
    Then user clicks on register button on registration page
    Then user should see this field is invalid error message











