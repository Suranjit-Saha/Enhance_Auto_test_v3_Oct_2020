#This feature file contains few test scenarios to verify UI and API
#Author: Suranjit Saha
Feature: To verify UI and API automation with Selenium and Rest Assured
Scenario Outline: To verify that St John is included in the charities list - GET Method
Given To initiate Rest service to get charities list
Then Response status code should be "200"
And response should includes "<Data>"
  Examples:
    |Data         |
    | St John     |


  Scenario Outline: To verify used Car listing and confirm that the required details are shown for that car - GET Method
Given To initiate Rest service to get used car list
Then Response status code should be "200"
And The "<Attribute>" is returned in the response with value "<Value>"

  Examples:
    | Attribute    | Value                      |
    | NumberPlate  | EDD369                     |
    | Kilometres   | 163,794km                  |
    | BodyStyle    |  Dark Blue, 4 door, Sedan  |
    | Seats        |  5                         |

  Scenario: Number plate Kilometres Body and Seats are displayed for the posted used cars
Given User is on Used Car listing Page
When User queries an existing Used Car from the listing
Then The Number plate is displayed
And The Kilometres is displayed
And The Body is displayed
And The Seats are displayed



