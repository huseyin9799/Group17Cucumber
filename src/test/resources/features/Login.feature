Feature: We are testing the login feature

  Scenario: Happy scenario
    Given "user" is on the login page
    When "driver" enters username and password and clicks log in
    Then "user" should be on Dashboard