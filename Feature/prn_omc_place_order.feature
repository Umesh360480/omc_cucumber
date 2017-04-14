@OrderCreation
Feature: Placing an Order from OMC

  Background: These are the background steps to place an order from OMC-PRN website
    Given User is on Login Page
    When User enters UserName and Password
      | username         | password   |
      | rakesh.m@cts.com | password-1 |
    Then User should be Logged In Successfully

  Scenario Outline: Should be able to place Order with Immediate PRT
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
      | As soon as possible |
