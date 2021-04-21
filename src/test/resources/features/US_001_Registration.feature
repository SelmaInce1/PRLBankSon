
@Registration
Feature:US_001 Registration

  Scenario: TC001 There should be entered valid credentials on registration page and seen successful message.
    Given user on the "prlbank_url"
    And User waits for 1000 miliseconds
    And User navigates to registration page
    Then User provides a valid ssn
    And User provides a valid firstname
    And User provides a valid lastname
    And User provides a valid address
    And User provides a valid phonenumber
    And User provides a valid username
    And User provides a valid email
    And User provides password
    And User provides a valid password confirmation
    And User clicks Register button
    #And User asserts thst he could register successfully

