package auto.steps;

import java.util.List;
import auto.steps.serenity.EndUserSteps;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class DefinitionSteps {

	@Steps
	EndUserSteps user;
	
	@Given("^user navigates to Amazon \"([^\"]*)\" website$")
	public void user_navigates_to_Amazon_website(String gherkinPageName) throws Throwable {
		user.navigates_to_page(gherkinPageName.toLowerCase());
	}

	//  <Then|Given> user <should see|lands on|is at|is on> the "X" <page|pulldown list|menu|section>
	@Then("^user (?:should see|lands on|is at|is on) the \"([^\"]*)\" (page|pulldown list|menu|section|sub-section)$")
	public void user_lands_on_page_X(String gherkinPageOrSectionID, String gherkinObjectType) throws Throwable {
		switch(gherkinObjectType.toLowerCase())
		{
		   case "section"     : user.lands_on_the_section_X(gherkinPageOrSectionID); break;
		   case "sub-section" : user.lands_on_the_sub_section_X(gherkinPageOrSectionID); break;
		   default: user.lands_on_page_X(gherkinPageOrSectionID); break;
		}
	}

	
	// Then user clicks on the "X" button by the "Y" field
	@Then("^user clicks on the \"([^\"]*)\" button by the \"([^\"]*)\" field$")
	public void user_clicks_on_the_button_by_the_field(String gherkinElement, String fieldName) throws Throwable {
		user.clicks_on_the_button_by_the_field_X(gherkinElement, fieldName);
	}
	
	// When user clicks on the "X" <button|radio button|check box|fields|section link>
	@When("^user clicks on the \"([^\"]*)\" (button|radio button|check box|field|section link)$")
	public void user_clicks_on_element_X(String gherkinPageOrSectionID,String gherkinObjectType ) throws Throwable {

		switch(gherkinObjectType.toLowerCase())
		{
		   case "section link" : user.clicks_on_the_section_link_X(gherkinPageOrSectionID); break;
		   default: user.clicks_on_element_X(gherkinPageOrSectionID); break;
		}
		
//		if(gherkinObjectType.equalsIgnoreCase("section link"))
//			user.clicks_on_the_section_link_X(gherkinPageOrSectionID);
//		else
//		    user.clicks_on_element_X(gherkinPageOrSectionID);
	}
	
//	//@Then user <should see|lands on|is at|is on> the "X" <page|pulldown list>
//	@Then("^user (?:should see|lands on|is at|is on) the \"([^\"]*)\" (?:page|pulldown list)$")
//	public void user_lands_on_page_X(String gherkinPageName) throws Throwable {
//		user.lands_on_page_X(gherkinPageName);
//	}
//
//	// 1 - Then user <should see|lands on|is at|is on> the "X" section
//	// 2 - Given user is at the "X" section
//	@Then("^user (?:should see|lands on|is at|is on) the \"([^\"]*)\" section$")
//	public void user_lands_on_the_section_X(String gherkinSectionID) throws Throwable 
//	{
//        user.lands_on_the_section_X(gherkinSectionID);
//	}
	
//	// Then user <should see|lands on|is at|is on> the "X" sub-section
//	@Then("^user (?:should see|lands on|is at|is on) the \"([^\"]*)\" sub-section$")
//	public void user_should_see_the_sub_section(String gherkinSubSectionID) throws Throwable 
//	{
//		user.lands_on_the_sub_section_X(gherkinSubSectionID);
//	}
	
//	// When user clicks on the "X" section link
//	@When("^user clicks on the \"([^\"]*)\" section link$")
//	public void user_clicks_on_the_section_link(String gherkinSectionLinkID) throws Throwable 
//	{
//          user.clicks_on_the_section_link_X(gherkinSectionLinkID);
//	}
	
	// Then user verifies that all expected elmenets are dispayed
	@Then("^user verifies that all expected elmenets are dispayed$")
	public void user_verifies_that_all_expected_elmenets_are_dispayed() throws Throwable {
           user.verifies_that_all_expected_elmenets_are_dispayed();
	}

}