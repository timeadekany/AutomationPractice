Feature: Input Forms menu item - Simple Form Demo Page

  Scenario: Simple Form Demo Page
    Given I open the page
    And I close the pop up
    And I click on the Input Forms menu
    And I click on the First Menu item
    Then I redirected to the Input form page
    When I Fill the Single Input Field
    And I click on the Show Message button
    Then I validate the Single Input message
    When I Fill Two Input Fields
    And I click on the Get Total button
    Then I validate the Total input message
    And Close the browser

