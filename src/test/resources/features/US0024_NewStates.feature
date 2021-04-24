Feature: US_025_System should allow to create new states using api end point
  Scenario Outline: TC_001_User can Just create each state 1 by 1

    Given user goes API
    And user goes to "https://www.gmibank.com/api/tp-states" and creates a country "country_name" and state "<state>"
    Then user validates country and state
    Examples:
      | state |
      |Texas|
      |Arizona    |
      |California   |



