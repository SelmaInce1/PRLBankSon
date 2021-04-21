@US11
  Feature: US_011 Date should be created on the time of customer creation
    Background: US_011 Background access
      Given user is on main page
      When user clicks to icon menu
      Then user clicks on sign in button
      Then user provides a valid username as manager to username textbox
      And user provides a valid password as manager password to password textbox
      Then User clicks on Signin button
      Then user clicks on my operations button
      And user clicks on manage customers dropdown
      Then user clicks on create a new customer button on customers page
      Then user enter first name
      Then user enter last name
      Then user enter Middle Initial
      Then user enter Email
      Then user enter Mobile Phone Number
      Then user enter Phone Number
      Then user enter Zip Code
      Then user enter Address
      Then user enter City
      Then user enter Ssn number

      Scenario: TC_01_US11 Date Created
        Then user select valid date in Date table and verify Date


    Scenario: TC_02_US11 select Country
      Then user select the country on the Country Box

    Scenario: TC_03-US11 enter state
      Then user enter State

    Scenario: TC_04_US11 select User
      Then user select the user on the User Box

    Scenario: TC_05_US11 select Account
      Then user select an account on the Account Box

    Scenario: TC_06_US11 Check Zelle Enrolled
      Then user check the Zelle Enrolled box

    Scenario: TC_07_US11 clicks on Save button
      Then user clicks on save button
      And user verify account created
