package auto.steps.serenity;

import java.util.HashMap;
import java.util.Map;

import org.jruby.RubyProcess.Sys;

import auto.pages.AmazonBasePageObject;
import auto.util.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

@SuppressWarnings("serial")
public class EndUserSteps extends ScenarioSteps {

	String pageName;
	AmazonBasePageObject currentPage;
	
	// ISA Markings Variables
	String sectionID ;
	String objectID;

	// This table is used to store all the instance variables for pages under test
	private static final Map<String, AmazonBasePageObject> allPagesUnderTest = new HashMap<>();
	
	// This table contains all pages of the app
	TableOfAllPages tableOfAllPages = new TableOfAllPages();
	TableofIsaObjects tableofIsaObjects = new TableofIsaObjects();

	public EndUserSteps() {
		super() ;
		this.pageName = null;
		this.currentPage = null;
		this.sectionID = null;
		this.objectID = null;
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
	
	// Create a step definition for "And User lands on the "ISA Custom Markings for Title field" section
	public void lands_on_pageX(String gherkinPageName) throws Throwable {
		
		  	this.pageName = gherkinPageName.toLowerCase();
			currentPage =  getCurrentPage(pageName);
			currentPage.getElement("page unique element");
		
        //  Create a step for landing on "Section" and use the following logic
	    // gherkinPageName2 is the section string passed down by Gherkin
		String gherkinPageName2 = "ISA Custom Markings for Package";
		System.out.println("====================================");
		System.out.println("gherkinPageName = " + gherkinPageName2);
		if(gherkinPageName2.contains("ISA Custom Markings") && gherkinPageName.equalsIgnoreCase("Login") )
		{
			if(gherkinPageName2.contains("field"))  // field level
			{
				// get the field name
				this.objectID = gherkinPageName2.split("for")[1].trim().split("field")[0].trim();
				// Set the page to "ISA Custom Markings for X field "
				gherkinPageName = gherkinPageName2.replace(this.objectID, "X");
				System.out.println("The page to be called = " + gherkinPageName.toLowerCase());
				// get the actual objectID
				this.objectID = tableofIsaObjects.getActualObjectID(this.objectID.toLowerCase());
				System.out.println("ObjectID = " + this.objectID);
			}
			else // Page level
			{
				// get the page level
				this.objectID = gherkinPageName2.split("for")[1].trim();
				// Set the page to "ISA Custom Markings for X"
				gherkinPageName = gherkinPageName2.replace(this.objectID, "X");
				System.out.println("The page to be called = " + gherkinPageName.toLowerCase());
				// get the actual objectID
				this.objectID = tableofIsaObjects.getActualObjectID(this.objectID.toLowerCase());
				System.out.println("ObjectID = " + this.objectID);
			}

			currentPage =  getCurrentPage(gherkinPageName.toLowerCase());
			
		}
	}


	public void enters_inputX_into_the_elementY_input_field(String gherkinInputValue, String gherkinElement) throws Throwable {
		currentPage.getElement(gherkinElement).waitUntilVisible().and().waitUntilEnabled().sendKeys(gherkinInputValue);

	}

	public void verifyThatAllExpectedElementsAreDisplayedOnPage() {
		currentPage.verifyThatAllExpectedElementsAreDisplayedOnPage(this.pageName);
	}
	
}
