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
    Then user lands on the "New Indicator" page
    
    ####################################
    # And user verifies that all expected elmenets are dispayed
    # And user clicks on the "Indicator Type" field
    
    ####################################
    # User clicks on the a link on the page.  This link is NOT part of the ISA MArkings links
    # When user clicks on the "Responsible Entity" section link 
    
    ####################################
    Given user is at the "Indicator.Main" section 

    ####################################
     When user clicks on the "Custom ISA Markings" button by the "Description" field
     Then user lands on the "ISA Markings for Description field" section
    # DO SOMETHING...on the "ISA Markings for Description field" section
     When user clicks on the "Description.Policies" section link
    # Then user lands on the "Description.Policies.Further Sharing" section
    Then user should see the "SubsectionX" section
    # DO SOMETHING...on the "Description.Policies.Further Sharing" section
    
    ####################################
    # Given user is at the "ISA Markings for Indicator" section 
    # DO SOMETHING...on the ""ISA Markings for Package" section
    # When user clicks on the "Indicator.Policies" section link
    # Then user lands on the "Indicator.Policies" section
    # DO SOMETHING...on the "Package.Policies" section
    
    ####################################
    # mimic the actions for profile page
    #Then user lands on the "Indicator Profile" page
    