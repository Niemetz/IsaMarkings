@version:Sprint-6.5.0-RC-1
@version:GD-Release-6.5.0-RC-1
Feature: Requirement ID = 80.3 An Amazon existing user is able to log on to his/her account
         Acceptance Criteria:
         As an amazone existing cusomter
         I should have be able to log on to my account
         In order to purchase things that I like
@Amazon-User-Login-Authentication
Scenario: Amazon User Login Authentication
    Given user navigates to Amazon "Home" website
    Then user lands on the "New Package" page
    
    Given user is at the "Package.Main" section 
    #Then user enters the "Title Summary Entered by John" into the "Title" input field
    
    ####################################
    When user clicks on the "Custom ISA Markings" button by the "Description" field
    Then user lands on the "ISA Markings for Description field" section
    # DDO SOMETHING...on the "ISA Markings for Description field" section
    When user clicks on the "Description.Policies.Further Sharing" section link
    Then user lands on the "Description.Policies.Further Sharing" section
    # DO SOMETHING...on the "Description.Policies.Further Sharing" section
    
    ####################################
    #Given user is at the "ISA Markings for Indicator" section 
    # DO SOMETHING...on the ""ISA Markings for Package" section
    #When user clicks on the "Indicator.Policies" section link
    #Then user lands on the "Indicator.Policies" section
    # DO SOMETHING...on the "Package.Policies" section
    
    ####################################
    # mimic the actions for profile page
    #Then user lands on the "Indicator Profile" page
    