@US009
Feature: User can search for a new applicant by their SSN and see all their registration info populated

  Scenario: User can search for a new applicant by their SSN and see all their registration info populated
    Given user is on main page
    When user clicks to icon menu
    Then user clicks on sign in button
    Then user provides a valid username as manager to username textbox
    And user provides a valid password as manager password to password textbox
    Then User clicks on Signin button
    Then user clicks on my operations button
    And user clicks on manage customers dropdown
    Then user clicks on create a new customer button on customers page
    And user provides a valid SSN number to SSn text box on create or edit a customer page
    Then user clicks on search button
    And user should see customers' registration info populated




