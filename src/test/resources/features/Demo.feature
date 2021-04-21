@demo
Feature: Demo presentation
  Scenario Outline: Steps for money transfer
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
    Then user logs into their own account
    And user navigates to My Operations
    Then user makes money transfer
    And user verifies their money transfer

    Examples:
    |adminusername|adminpswd|employeeusername|employeepswd|
    |team43admin  |T43admin.|                |            |





