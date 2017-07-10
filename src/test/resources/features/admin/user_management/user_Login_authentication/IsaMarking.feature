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
    
    # DONE
    ####################################
    # Note: Which main ISA Markings section the user is at?
    #Given user is at the "Indicator.Main" section 
    #Given user is at the "ISA Markings for Indicator" section
    #Given user is at the "ISA Markings for Indicator.Policies" section
    #Given user is at the "ISA Markings for Description field" section
    #Given user is at the "ISA Markings for Description field.Policies" section
        
    # DONE
    ####################################
    # Note: Which ISA Markings section user <lands on|should see> ?
    # Then user lands on the "ISA Markings for Indicator" section
    # Then user lands on the "ISA Markings for Indicator.Policies" section
    # Then user lands on the "ISA Markings for Description field" section
    # Then user lands on the "ISA Markings for Description field.control set" section
    
    # DONE
    ####################################
    # Note: Which ISA Markings button (at field level) the user clicks on?
    # When user clicks on the "Custom ISA Markings" button by the "Description" field

    # DONE
    ####################################
    # Note: Which ISA Markings main "section link" the user clicks on?
    # When user clicks on the "ISA Markings for Indicator" section link
    # When user clicks on the "ISA Markings for Indicator.Policies" section link 
     When user clicks on the "ISA Markings for Description field" section link
    # When user clicks on the "ISA Markings for Description field.Policies" section link 
    
    #DONE
    ####################################
    #Then user should see the "SubSectionX" sub-section
     
    ####################################
    # And user verifies that all expected elmenets are dispayed
    # And user clicks on the "Indicator Type" field

    