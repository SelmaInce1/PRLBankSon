@countries
Feature:"System should allow to read all countries info using api end point "https://www.gmibank.com/api/tp-countries"

  Scenario Outline: User create countries and read and validate them from data set
    Given user goes to API end point "country-api" and read countries
    And user validate countries from data set
    Then user create a countries "<country>" using API end point "country-api"
    And user validate countries created
    Examples:
      | country    |
      | Wonderland |
      | New World  |
      | Nuevo Mundo|
