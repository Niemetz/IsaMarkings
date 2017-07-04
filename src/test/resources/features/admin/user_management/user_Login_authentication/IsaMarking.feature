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
    # Note: Which main ISA Markings section the user is at?
    #Given user is at the "Indicator.Main" section 
    #Given user is at the "Description.Policies" section
    #Given user is at the "ISA Markings for Indicator" section
    
    ####################################
    # Note: Which ISA Markings button (at field level) the user clicks on?
    # When user clicks on the "Custom ISA Markings" button by the "Description" field
    
    ####################################
    # Note: Which ISA Markings main section the user clicks on?
    # When user clicks on the "Description.Policies" section link 
    # When user clicks on the "ISA Markings for Indicator" section link
    
    ####################################
    # Note: Which ISA Markings section user <lands on|should see> ?
    # Then user lands on the "Description.Policies" section
    # Then user lands on the "Description.Policies.Further Sharing" section
    # Then user lands on the "Indicator.Policies" section
    # Then user should see the "SubSectionX" section
    
    ####################################
    # And user verifies that all expected elmenets are dispayed
    # And user clicks on the "Indicator Type" field

    