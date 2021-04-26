@US026
  Feature: US026 System should allow to update countries using api end point
    "https://www.gmibank-qa-environment.com/api/tp-countries"
  Scenario: TC001 User can just update each country 1 by 1
    Given User goes to api end point "https://gmibank-qa-environment.com/api/tp-countries"
    And User should update each country