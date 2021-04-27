@demo2all
Feature: Api Demo 3
@demo2ui
  Scenario Outline: Creating a customer account in UI and validating with API
    Given user is on main page
    And User navigates to registration page
    And user provides information for registration
    Then user is on main page
    Then admin user clicks sign in button
    And login to admin account "<adminusername>" and "<adminpswd>"
    Then admin activates the account of the user
    And login out from admin account
    Then login to employee account "<employeeusername>" and "<employeepswd>"
    And employee integrates accounts for the user
    Then login out from employee account
    And Authorized user on the api endpoint “customers_api” and read the customers
    And Validate the customer

    Examples:
      |adminusername|adminpswd|employeeusername|employeepswd|
      |team43admin|T43admin.|team43employee|T43employee.|

  @demo2api
  Scenario: Create a country with api and validate it from UI, Update a country with api and validate it from UI and Delete a country with api and validate it from UI
    And user create a country with countries api end point "team43_country"
    Then login to employee account "emplUsername" and "emplPaswd"
    And employee navigate create or edit customer page
    And employee can validate new country created "team43_country"
    Then login out from employee account

    And user update created country using api end point "team43_countryUpdated"
    Then login to employee account "emplUsername" and "emplPaswd"
    And employee navigate create or edit customer page
    And employee can validate new country updated "team43_countryUpdated"
    Then login out from employee account

    And user delete created country using api end point "countriesEndPoint"
    Then login to employee account "emplUsername" and "emplPaswd"
    And employee navigate create or edit customer page
    And employee can not select new country deleted "team43_countryUpdated"
    Then login out from employee account
