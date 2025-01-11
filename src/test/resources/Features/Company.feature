Feature: Tracrat Automation

@companyCrud
Scenario: Company CRUD operations automation
    Given the user name is "ypatel" and the password is "Ypatel@1234"
    When I click the login button
    Then the login should be successful
    When i select the company 'AMWAY' from navigation bar
    Then verify the selected company should be loaded
    And i click on manage company
    Then verify Manage Company page should be open
    When i click on add company
    Then add company page should be loaded
    Given the required details in company page
    When i click on save button in company page
    Then company should be saved
    When i select the created company from navigation bar
    Then verify the selected company should be loaded
    