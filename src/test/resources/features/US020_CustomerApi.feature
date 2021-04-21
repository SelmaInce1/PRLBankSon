@US020CustomerApi
Feature: All customer api testing

  Background: set api token
    Given all api data is set to  using api end point ""eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0MzdlbXBsb3llZSIsImF1dGgiOiJST0xFX0VNUExPWUVFIiwiZXhwIjoxNjE4MTkxMDM3fQ.k4-WMA6f46u-yPpuYrwkDqypBwVY2tGkdMkLPjpPhmcq9YU6vep1_ACgsro1OX4HM_It0JO1bIQNtg86jMeymw""

    Scenario: all api data validation of customers
      Given all customer info will be set to customers with desirialization
      And all customer info will be saved to correspondent files
      Then all customer info has been validated
