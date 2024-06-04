@Google
Feature: Search on google

  @Search
  Scenario: User is able to see result about his search
    Given The user is on the google home page
    When The user search for the word "Colombia"
    Then The user should see a list of results related to "Colombia"

  @Filter
  Scenario: User is able to see result about his search
    Given The user is on the google home page
    When The user filter by using the "site:amazon.com" command
    Then The user should only see result of the "amazon.com" domain