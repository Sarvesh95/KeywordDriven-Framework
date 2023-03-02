

Feature: to Test the navigation between the Pages


  Scenario: to check whether each of the link is navigated to the correct page and there is no crash.
    Given browser is open
    And user is on the home page
    When User clicks on the Customers link
    Then verify that user is navigated to the customers Page
    When User clicks on the Pricing link
    Then verify that user is navigated to the Pricing page
    When User clicks on the Resources link
    Then verify that user is navigated to the Resources page
    When User clicks on the Partners link
    Then verify that user is navigated to the Partners page
 