
  Feature: Tum customer api data testi
    Background: Set the customer api url
      Given All customer API data is set to response using api end point "customer_api_endpoint"

    Scenario: All customers API data validation
      Given all customer info will be set to customers with desirialization
      And all customer info will be saved to txt files
      Then all customer info has been validated

