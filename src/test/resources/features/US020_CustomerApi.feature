@US020CustomerApi
Feature: All customer api testing

  Background: set the Customer api url
    Given all api data is set to  using api end point "customer_api_endpoint"

    Scenario: all api data validation of customers
      Given all customer info will be set to customers with desirialization
      And all customer info will be saved to correspondent files
      Then all customer info has been validated
