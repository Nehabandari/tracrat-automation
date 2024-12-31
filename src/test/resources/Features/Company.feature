Feature: Tracrat Automation

@addCompany
Scenario: Add a Company
    Given the user name is "ypatel" and the password is "Ypatel@1234"
    When I click the login button
    Then the login should be successful
    And I select the dropdown 'Select Company'
	  Then verify the selected company should be loaded
    And I click on Manage Company
    Then verify Manage Company page should be open
    