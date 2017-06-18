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
	@When("^user clicks on the \"([^\"]*)\" (?:button|radio button|check box|)$")
	public void user_clicks_on_elementX(String gherkinElement) throws Throwable {
		user.clicks_on_elementX(gherkinElement);
	}
	
	// Step for Isa marking
	@Then("^user clicks on the \"([^\"]*)\" button by the \"([^\"]*)\" field$")
	public void user_clicks_on_the_button_by_the_field(String gherkinElement, String fieldName) throws Throwable {
		user.clicks_on_the_button_by_the_field(gherkinElement, fieldName);
	}

	// @Step
	//@Then("^user lands on the \"([^\"]*)\" page$")
	@Then("^user (?:should see|lands on|is at|is on|.*?) the \"([^\"]*)\" page$")
	public void user_lands_on_page_X(String gherkinPageName) throws Throwable {
		user.lands_on_page_X(gherkinPageName);
	}

	//@Then("^user (?:lands on the|is at the|.*?) \"([^\"]*)\" section$")
	@Then("^user (?:should see|lands on|is at|is on|.*?) the \"([^\"]*)\" section$")
	public void user_lands_on_the_section_X(String gherkinSectionID) throws Throwable 
	{
        user.lands_on_the_section_X(gherkinSectionID);
	}
	
	@When("^user clicks on the \"([^\"]*)\" section link$")
	public void user_clicks_on_the_section_link(String gherkinSectionLinkID) throws Throwable 
	{
          user.clicks_on_the_section_link(gherkinSectionLinkID);
	}
	

}