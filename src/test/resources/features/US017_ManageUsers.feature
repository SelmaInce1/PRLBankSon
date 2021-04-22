@US017
  Feature: admin manage users

    Background: user register for five roles
      Given user is on main page
      And User navigates to registration page
      And user provides information for registration
      Then user is on main page
      Then admin user clicks sign in button
      And login to admin account "team43admin" and "T43admin."
      And navigates to users page

    Scenario:
      Given admin activates the account of the user
      Then admin selects role as a user

    Scenario:
      Given admin activates the account of the employee
      Then admin selects role as an employee

    Scenario:
      Given admin activates the account of the manager
      Then admin selects role as a manager

    Scenario:
      Given admin activates the account of the admin
      Then admin selects role as an admin


    Scenario:
      Given admin activates the account of the customer
      Then admin selects role as a customer

    Scenario:
      Given admin clicks view button
      Then admin verifies all user info page is displayed

    Scenario:
      Given admin clicks edit button
      Then admin verifies create or edit a user page is displayed

    Scenario:
      Given admin clicks delete button
      Then admin verifies pop up is displayed