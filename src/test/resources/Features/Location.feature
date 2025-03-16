@Location
Feature: Tracrat Automation

  @locationCrud @smoke
  Scenario: create company
    Given the user name is "ypatel" and the password is "Ypatel@1234"
    When I click the login button
    Then the login should be successful
    When i select the company 'AMWAY' from navigation bar
    Then verify the selected company should be loaded
    When i select the location 'Location' from navigation bar
    Then verify the selected location should be loaded
    And i click on manage location
    Then verify Manage Locations page should be open
    When i click on add location
    Then add location page should be loaded
    Given the required details in location page
    When i click on save button in location page
    Then location should be saved
    When i select the created location from navigation bar
    Then verify that selected location should be loaded
    And i click on manage location
    Then verify Manage Location page should be open
    When search for the location name
    Then location name should be display in the locations list
    When i click on Edit button
    Then location details page should be loaded
    And verify the location details saved
    Given i change the location details
    And i click the update button
    Then location should be updated succesfully
    When i select the created location from navigation bar
    Then verify that selected location should be loaded
    And i click on manage location
    Then verify Manage Location page should be open
    When search for the location name
    Then location name should be display in the companies list
    When i click on Edit button
    Then location details page should be loaded
    And verify the location details saved
    When i click on location expand
    And i click on manage location
    Then verify Manage Location page should be open
    When search for the location name
    Then location name should be display in the location list
    When i click on Delete button
    Then verify delete confirmation popup is visible
    When i click on yes in popup
    Then location should be deleted succesfully


  Scenario: delete location
    Given the user name is "admin" and the password is "Ypatel@1234"
    When I click the login button
    Then the login should be successful