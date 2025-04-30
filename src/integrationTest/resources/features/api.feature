Feature: API feature
  Test scenarios for API deployed to on Swagger Hub

  Scenario: Reading API from Swagger Hub
    Given System is running
    When We make a request to Swagger Hub
    Then We receive a response from Swagger Hub
