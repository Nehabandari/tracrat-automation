@Location
Feature: Tracrat Automation

  @locationCrud @smoke1
  Scenario: create location
    Given the user name is "tracrat_automation" and the password is "Tracrat@123"
    When I click the login button
    Then the login should be successful
    When i select the company 'AMWAY' from navigation bar
    Then verify the selected company should be loaded
    #When i select the location from  navigation bar
    #Then verify the selected location should be loaded
    #And i click on manage location
    #Then verify Manage Locations page should be open
    #When i click on add location
    #Then add location page should be loaded
    #Given the required details in location page
    #When i click on save button in location page
    #Then location should be saved
    #When i select the created location from navigation bar
    #Then verify that selected location should be loaded


