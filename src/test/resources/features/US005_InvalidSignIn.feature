Feature:Login page should not be accessible with invalid credentials

  Background:
    Given User navigates to login page

  @invalidusername
  Scenario Outline: User cannot login with invalid username validating the error message

    And User provides an invalid username "<username>"
    And User provides a valid password "<password>"
    Then User clicks on Signin button
    Then There should be the error message

    Examples:
      | username       | password         |
      |invalid_username| customer_password|


  @invalidpassword
  Scenario Outline: User cannot login with invalid password validating the error message

    And User provides a valid username "<username>"
    And User provides an invalid password "<password>"
    Then User clicks on Signin button
    Then There should be the error message

    Examples:
      | username        | password        |
      |customer_username| invalid_password|

  @invalidusername&password
  Scenario Outline: User cannot login with invalid username and password validating the error message

    And User provides an invalid username "<username>"
    And User provides an invalid password "<password>"
    Then User clicks on Signin button
    Then There should be the error message
    Examples:
      | username        | password        |
      |invalid_username | invalid_password|

  @resetbutton
  Scenario: User with invalid credentials should be given an option to reset their password
    Then There should be a password reset button that navigates to reset page
