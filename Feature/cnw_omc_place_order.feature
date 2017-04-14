@CNWOrderCreation
Feature: Placing an Order from OMC using CNW Customer

  Background: These are the background steps to place an order from OMC-CNW website
  	Given Navigate to OMC CNW Website
    Given User is on Login Page
    When User enters UserName and Password
      | username         | password   |
      | cnwtestuser2@cts.com | password-1 |
    Then User should be Logged In Successfully

  Scenario Outline: Should be able to place Order with Hold for Call PRT
    When Navigate to Send a Release page
    Then User uploads primary content document
    And User clicks on Distribution Tab
    And User selects Category
    And User selects News Line
    And User selects Public Release Time as <PRT>
    And User selects on Save and Continue Button
    And User selects Terms and Condition Check Box
    And User clicks on Submit Button
    And User fetch the Order No

    Examples: 
      | PRT                 |
      | Hold for Call |
