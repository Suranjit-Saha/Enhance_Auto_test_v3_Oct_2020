#This feature file contains few test scenarios to verify UI and API
#Author: Suranjit Saha
Feature: To verify UI and API of used car list and charities with Selenium and Rest Assured
  Scenario: Number plate Kilometres Body and Seats are displayed for the posted used cars in the UI
    Given User is on Used Car listing Page
    When User queries an existing Used Car from the listing
    Then The Number plate is displayed
    And The Kilometres is displayed
    And The Body is displayed
    And The Seats are displayed

Scenario: To verify that St John is included in the charities list - GET Method
Given To initiate Rest service to get charities list
When Response status code should be "200"
Then the response should include below value
| St John |


  Scenario: To verify used Car listing and confirm that the required details are shown for that car - GET Method
Given To initiate Rest service to get used car list
When Response status code should be "200"
Then the response should include below attributes with value
    | Attribute    | Value                      |
    | NumberPlate  | EDD369                     |
    | Kilometres   | 163,794km                  |
    | BodyStyle    |  Dark Blue, 4 door, Sedan  |
    | Seats        |  5                         |





