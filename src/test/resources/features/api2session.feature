@country_api_testing_ders
Feature: Country Api Testing ders

  @create_ders
  Scenario: Create
    And ders create a country "https://www.gmibank.com/api/tp-countries"

  @update_ders
  Scenario: Update ders
    And ders update created country using api end point "https://www.gmibank.com/api/tp-countries"

  @delete_ders
  Scenario: Delete ders
    And ders delete created country using api end point "https://www.gmibank.com/api/tp-countries" "91009"
