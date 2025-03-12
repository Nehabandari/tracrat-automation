@company
Feature: Tracrat Automation

    @companyCrud @smoke
    Scenario: create company
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
        Then verify that selected company should be loaded
        And i click on manage company
        Then verify Manage Company page should be open
        When search for the company name
        Then company name should be display in the companies list
        When i click on Edit button
        Then company details page should be loaded
        And verify the company details saved
        Given i change the company details
        And i click the update button
        Then company should be saved
    #And i click on manage company
    #Then verify Manage Company page should be open
    #When i click on Delete button
    #When i change the company Name, Phone, City & State
    # Then verify that deleted Company should not be available in companylist


    Scenario: delete company
        Given the user name is "admin" and the password is "Ypatel@1234"
        When I click the login button
        Then the login should be successful
