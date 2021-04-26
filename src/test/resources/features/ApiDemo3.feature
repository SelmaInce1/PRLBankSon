
  Feature: Api Demo 3
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

