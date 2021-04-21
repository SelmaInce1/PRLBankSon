@US010
Feature: Address of customer can be created 3

  Background:
    Given user is on main page
    When user clicks to icon menu
    Then user clicks on sign in button
    Then user provides a valid username as manager to username textbox
    And user provides a valid password as manager password to password textbox
    Then User clicks on Signin button
    Then user clicks on my operations button
    And user clicks on manage customers dropdown
    Then user clicks on create a new customer button on customers page

  Scenario: TC001_Address as street and number should be provided and cannot be left blank- negative testing

    Then user clicks on address text box on customer page and click any other places
    And user should see an error message

  Scenario: TC002_Address as street and number should be provided and cannot be left blank-positive testing
    Then user provides an address to address text box
    And user should not see error message

  Scenario: TC003_City should be provided and cannot be left as blank- negative testing
    Then user clicks on city text box on customer page and click any other places
    And user should see an error message

  Scenario: TC004_City should be provided and cannot be left as blank- positive testing
    Then user provides a city to city text box
    And user should not see error message

  Scenario: TC005_Country should be typed and cannot be blank- negative testing
    Then user clicks on country dropdown on customer page and click any other places
    And user should see an error message

  Scenario: TC006_Country should be typed and cannot be blank- positive testing
    Then user provides a country to country DD
    And user should not see error message

  Scenario: TC007_State should be provided as US state and cannot be blank- negative testing
    Then user clicks on state text box on customer page and click any other places
    And user should see an error message

  Scenario: TC008_State should be provided as US state and cannot be blank- positive testing
    Then user provides a state to state text box
    And user should not see error message

