@smoke
Feature: Login and Create EDI Order
  As a OneKonnect user
  I want to login and create an EDI order
  So that I can verify it appears in the Orders list

  Scenario: User logs in and successfully creates an EDI order
    Given user open the OneKonnect website
    When user enter valid username and password
    And user click on the login button
    Then user should be navigated to the OneKonnect homepage and see username greeting

    When user navigate to the EDI creation form from the dashboard
    And user fill only the mandatory EDI fields
    And user submit the EDI order
    Then user navigated to the Orders tab
    And user should see the created order in the Orders list
