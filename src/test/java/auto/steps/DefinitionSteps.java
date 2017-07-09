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

	// @Step
	//@When("^user clicks on the \"([^\"]*)\" (?:button|radio button|check box|.*?)$")
	@When("^user clicks on the \"([^\"]*)\" (?:button|radio button|check box|field)$")
	public void user_clicks_on_elementX(String gherkinElement) throws Throwable {
		user.clicks_on_elementX(gherkinElement);
	}
	
	// Step for Isa marking
	@Then("^user clicks on the \"([^\"]*)\" button by the \"([^\"]*)\" field$")
	public void user_clicks_on_the_button_by_the_field(String gherkinElement, String fieldName) throws Throwable {
		user.clicks_on_the_button_by_the_field_X(gherkinElement, fieldName);
	}

	 @Step
	//@Then("^user lands on the \"([^\"]*)\" page$")
	@Then("^user (?:should see|lands on|is at|is on|.*?) the \"([^\"]*)\" page$")
	public void user_lands_on_page_X(String gherkinPageName) throws Throwable {
		user.lands_on_page_X(gherkinPageName);
	}

	// 1 - @Then("^user (?:lands on the|should see the|.*?) \"([^\"]*)\" section$")
	// 2 - Given user is at the "X" section
	@Then("^user (?:should see|lands on|is at|is on) the \"([^\"]*)\" section$")
	public void user_lands_on_the_section_X(String gherkinSectionID) throws Throwable 
	{
        user.lands_on_the_section_X(gherkinSectionID);
	}
	
	@Then("^user (?:should see|lands on|is at|is on) the \"([^\"]*)\" sub-section$")
	public void user_should_see_the_sub_section(String gherkinSubSectionID) throws Throwable 
	{
		user.lands_on_the_sub_section_X(gherkinSubSectionID);
	}
	
	@When("^user clicks on the \"([^\"]*)\" section link$")
	public void user_clicks_on_the_section_link(String gherkinSectionLinkID) throws Throwable 
	{
          user.clicks_on_the_section_link_X(gherkinSectionLinkID);
	}
	
	@Step
	@Then("^user verifies that all expected elmenets are dispayed$")
	public void user_verifies_that_all_expected_elmenets_are_dispayed() throws Throwable {
           user.verifies_that_all_expected_elmenets_are_dispayed();
	}

}