Feature: An Employee can create a new Account

  Background:
    Given User navigates to sign in page
    Given User clicks on Username textbox and provide a username "manager_username"
    Given User clicks on Password textbox and provide a password "manager_password"
    And User clicks on Sign in button
    Then User clicks on My Operations and navigates to Manage Accounts page
    And User clicks the button to create new account

  @description
  Scenario: User should create a description for the new account and it cannot be blank
    Given User clicks on Description textbox and provide a "user_description"
    Then there should not be any error message

  @descriptionblank
  Scenario: User should create a description for the new account and it cannot be blank
    Given User leaves the description textbox blank
    And User provide a valid balance "valid_balance"
    Then there should be error message

  @balance
  Scenario: User should provide a balance for the first time account creation as Dollar
    Given User clicks on Description textbox and provide a "user_description"
    And User provide a valid balance "valid_balance"
    Then there should not be any error message saying that this field should be a number

  @balanceinvalid
  Scenario: User should provide a balance for the first time account creation as Dollar
    Given User clicks on Description textbox and provide a "user_description"
    And User provide an invalid balance "invalid_balance"
    Then there should be an error message saying that this field should be a number

  @balanceblank
  Scenario: User should provide a balance for the first time account creation as Dollar
    Given User clicks on Description textbox and provide a "user_description"
    Then User clicks on Balance textbox and leaves the balance textbox blank
    Then there should be an error message saying that this field is required

  @accounttype
  Scenario: User can select an account type as CHECKING, SAVING, CREDIT_CARD or INVESTING
    Given User clicks on Account Type and select an account type
    Then Selected account type should be displayed on the box


  @accountstatustype
  Scenario: Account status should be defined as ACTIVE, SUSPENDED or CLOSED
    Given User clicks on Account Status type and select a type
    Then Selected Account status type should be displayed on the box


  @employee
  Scenario: User can select an employee from the drop-down
    Given User clicks on Employee dropdown
    Then there should be the employee names on the dropdown list