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
	@Then("^user lands on the \"([^\"]*)\" page$")
	public void user_lands_on_pageX(String gherkinPageName) throws Throwable {
		user.lands_on_pageX(gherkinPageName.toLowerCase());
	}

	@Then("^user (?:lands on the|is at the|.*?) \"([^\"]*)\" section$")
	//@Given("^user is at the \"([^\"]*)\" section$")
	public void user_lands_on_the_section(String gherkinSectionID) throws Throwable 
	{
        user.lands_on_the_section(gherkinSectionID);
	}
	
//	@Given("^user is at the \"([^\"]*)\" section$")
//	public void user_is_at_the_section(String arg1) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
	
	
	@When("^user clicks on the \"([^\"]*)\" section link$")
	public void user_clicks_on_the_section_link(String gherkinSectionLinkID) throws Throwable 
	{
          user.clicks_on_the_section_link(gherkinSectionLinkID);
	}
}