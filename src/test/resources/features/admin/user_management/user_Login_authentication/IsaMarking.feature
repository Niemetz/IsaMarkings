@version:Sprint-6.5.0-RC-1
@version:GD-Release-6.5.0-RC-1
Feature: Requirement ID = 80.3 I AM FUTURE ENHANCEMENT ....An Amazon existing user is able to log on to his/her account
         Acceptance Criteria:
         As an amazone existing cusomter
         I should have be able to log on to my account
         In order to purchase things that I like
@Amazon-User-Login-Authentication
Scenario: Amazon User Login Authentication
    Given user navigates to Amazon "Home" website
    Then user lands on the "New Indicator" page
    
    Given user is at the "Indicator.Main" section 
    When user clicks on the "Custom ISA Markings" button by the "Title" field
    Then user lands on the "ISA Markings for Title field" section
    When user clicks on the "Title.Policies.Further Sharing" section link
    Then user lands on the "Title.Policies.Further Sharing" section
    
    Given user is at the "ISA Markings for Indicator" section 
    When user clicks on the "Indicator.Policies" section link
    Then user lands on the "Indicator.Policies" section






    #Then user lands on the "Login" page
    #And  user verifies that all expected elelments are displayed on the page
    #When user clicks on the "Sign in securely" button
    #Then user lands on the "Login" page
    #And  user verifies that all expected elelments are displayed on the page
    #When user enters "John.Nguyen@yahoo.com" into the "Email" input field
    #And user enters "John The Gardener" into the "Password" input field