 @firefox
Feature: OMC Login Functionality

Background: This is background step to navigate to OMC-CNW Website
 Given Navigate to OMC CNW Website

  Scenario: Should be login with valid credentials
   
    Given User is on Login Page
    When User enters UserName and Password
      | username         | password   |
      | cnwtestuser2@cts.com | password-1 |
    Then User should be Logged In Successfully
    And User should be logged out succesfully

  Scenario: Should not be login with invalid credentials
    
    Given User is on Login Page
    When User enters UserName and Password
      | username          | password   |
      | cnwtestuser11@cts.com | password-1 |
    Then User should be alerted for valid credentials
    And User should be logged out succesfully
