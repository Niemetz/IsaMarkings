package auto.steps.serenity;

import java.util.HashMap;
import java.util.Map;
import auto.pages.AmazonBasePageObject;
import auto.util.TableOfAllPages;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

@SuppressWarnings("serial")
public class EndUserSteps extends ScenarioSteps {

	String pageName;
	AmazonBasePageObject currentPage;
	
	// ISA Markings Variables
	String sectionID ;


	// This table is used to store all the instance variables for pages under test
	private static final Map<String, AmazonBasePageObject> allPagesUnderTest = new HashMap<>();
	
	// This table contains all pages of the app
	TableOfAllPages tableOfAllPages = new TableOfAllPages();

	public EndUserSteps() {
		super() ;
		this.pageName = null;
		this.currentPage = null;
	}
	
	@Step
	public void navigates_to_page(String gherkinPageName) throws Throwable {
		currentPage = getCurrentPage(gherkinPageName);
		currentPage.open();
	}
	
	@SuppressWarnings("unchecked")
	public AmazonBasePageObject getCurrentPage(String gherkinPageName) throws ClassNotFoundException 
	{
		// if the desired page was not registered in the allPageUnderTest, 
		// then add the desired page to the allPageUnderTest.
		this.pageName = gherkinPageName.toLowerCase();
		if (!allPagesUnderTest.containsKey(this.pageName)) 
		{
		    @SuppressWarnings("rawtypes")
		    Class targetPageClass = (Class) tableOfAllPages.getClass(this.pageName);
			allPagesUnderTest.put(new String(pageName),  (AmazonBasePageObject) getPages().get(targetPageClass));
		}
		// return the desired page to the caller
		return allPagesUnderTest.get(pageName);
	}
	
	public void clicks_on_elementX(String gherkinElement) throws Throwable {
		currentPage.getElement(gherkinElement).waitUntilVisible().and().waitUntilClickable().click();
	}
	
	// Step for Isa marking
	public void clicks_on_the_button_by_the_field(String gherkinElement, String fieldName) throws Throwable {
	       
		
		   clicks_on_elementX(gherkinElement);
		   String templateTableName;
		   String sectionID;
		   templateTableName = "Custom Markings".toLowerCase();
	       //System.out.println("Custome Marking Table Name = " + templateTableName);
		   sectionID = fieldName.toLowerCase();
	       //System.out.println("Custome Marking Field Name = " + this.fieldName);  
	       // Assume that the section (page) for the custom makring field is "custome markings for title"
	       System.out.println("click on this button => " + templateTableName + " for " +  sectionID);   

	}
	
	public void lands_on_pageX(String gherkinPageName) throws Throwable {
		
		  	this.pageName = gherkinPageName.toLowerCase();
			currentPage =  getCurrentPage(pageName);
			currentPage.getElement("page unique element");
		
        //  Create a step for landing on "Section" and use the following logic
	    // CustomMakrningsPageNameAndFieldName is the section string passed down by Gherkin
		String CustomMakrningsPageNameAndFieldName = "Custom Markings for Title ";
		if(CustomMakrningsPageNameAndFieldName.contains("Custom") && gherkinPageName.equalsIgnoreCase("Login") )
		{
			this.pageName = CustomMakrningsPageNameAndFieldName.split("for")[0].trim().toLowerCase() ;
			System.out.println("Page ID    = " + ":" + this.pageName + ":");
			// get the "custom marking" template.
			this.sectionID = CustomMakrningsPageNameAndFieldName.split("for")[1].trim().toLowerCase();
			System.out.println("Section ID = " + ":" + this.sectionID + ":");
			// Look up the map table for exact section ID based on the section ID (ghetkin) above.
			
			currentPage =  getCurrentPage(pageName);
		
			// get sample elment from the custom markings page
			System.out.println("The element = " + currentPage.getElement("email", this.sectionID));
			
		}
	}


	public void enters_inputX_into_the_elementY_input_field(String gherkinInputValue, String gherkinElement) throws Throwable {
		currentPage.getElement(gherkinElement).waitUntilVisible().and().waitUntilEnabled().sendKeys(gherkinInputValue);

	}

	public void verifyThatAllExpectedElementsAreDisplayedOnPage() {
		currentPage.verifyThatAllExpectedElementsAreDisplayedOnPage(this.pageName);
	}
	
}
