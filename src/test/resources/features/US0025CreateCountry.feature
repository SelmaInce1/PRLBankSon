Feature: US_025_System should allow to create new countries using api end point
  Scenario Outline: TC_001_User can Just create each country 1 by 1

    Given user goes API
    And user goes to "https://www.gmibank.com/api/tp-countries" and creates a country "<name>" and state "state"
    Then user validates country and state
    Examples:
      | name |
    |USA   |
    |Germany|
    |Australia|

