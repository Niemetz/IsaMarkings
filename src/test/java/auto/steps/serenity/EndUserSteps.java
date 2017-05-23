package auto.steps.serenity;

import java.util.HashMap;
import java.util.Map;
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
	String isAPageOrAField = null;

	// This table is used to store all the instance variables for pages under test
	private static final Map<String, AmazonBasePageObject> allPagesUnderTest = new HashMap<>();
	
	// This table contains all pages of the app
	TableOfAllPages tableOfAllPages = new TableOfAllPages();
	TableofIsaObjects tableofIsaObjects = new TableofIsaObjects();

	public EndUserSteps() {
		super() ;
		this.pageName = null;
		this.currentPage = null;
		this.sectionID = "Main";
		this.objectID = null;
		this.isAPageOrAField = null;
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
	// Ghekin statment = When user clicks on the "Custom Markings" button by the 'X" field
	public void clicks_on_the_button_by_the_field(String gherkinElement, String fieldName) throws Throwable {

		   clicks_on_elementX(gherkinElement);
		   String templateTableName;
		   templateTableName = "Custom Markings".toLowerCase();
	       //System.out.println("Custome Marking Table Name = " + templateTableName);
		   sectionID = fieldName.toLowerCase();
	       //System.out.println("Custome Marking Field Name = " + this.fieldName);  
	       // Assume that the section (page) for the custom makring field is "custome markings for title"
	       System.out.println("click on this button => " + templateTableName + " for " +  sectionID);   
	}
	
	// Create a step definition for "And User lands on the "ISA Custom Markings for Title field" section
	//or "Given User is at the "ISA Custom Markings for Title field" section
	public void lands_on_pageX(String gherkinPageName) throws Throwable {
		
		  	this.pageName = gherkinPageName.toLowerCase();
			currentPage =  getCurrentPage(pageName);
			currentPage.getElement("page unique element", "Main");
			
	    // Copy this block to real EndUserStep
		///////////////////////////////////////////////////////////////////////
        //  Create a step for landing on "Section" and use the following logic
	    // gherkinPageName2 is the section string passed down by Gherkin
			
		//String gherkinPageName2 = "ISA Custom Markings for Package";
		
		String gherkinPageName2 = "Control Set";
			
		System.out.println("====================================");
		System.out.println("gherkinPageName = " + gherkinPageName2);
		if(gherkinPageName2.contains("ISA Custom Markings") && gherkinPageName.equalsIgnoreCase("Login") )
		{
			if(gherkinPageName2.contains("field"))  // field level
			{
				// Set the global isAPageOrAField to "field"
				this.isAPageOrAField="field";
				
				// get the isa field name
				this.objectID = gherkinPageName2.split("for")[1].trim().split("field")[0].trim();
				
				// Set the sectionID
				this.sectionID = this.objectID;
				
				// Set the page to "ISA Custom Markings for X field "
				this.pageName = gherkinPageName2.replace(this.objectID, "X");
				System.out.println("The page to be called = " + this.pageName.toLowerCase());
				// get the actual objectID
				this.objectID = tableofIsaObjects.getActualObjectID(this.objectID.toLowerCase());
				System.out.println("ObjectID = " + this.objectID);


			}
	      else // Page level
		     {
				// get the page level
				this.objectID = gherkinPageName2.split("for")[1].trim();
				
				// Set the sectionID
				this.sectionID = this.objectID;
				
				// Set the page to "ISA Custom Markings for X"
				this.pageName = gherkinPageName2.replace(this.objectID, "X");
				System.out.println("The page to be called = " + this.pageName.toLowerCase());
				// get the actual objectID
				this.objectID = tableofIsaObjects.getActualObjectID(this.objectID.toLowerCase());
				System.out.println("ObjectID = " + this.objectID);
				// Set the global isAPageOrAField to "field"
				this.isAPageOrAField="page";

			}
		}
		else if(!gherkinPageName2.contains("ISA Custom Markings") && gherkinPageName.equalsIgnoreCase("Login"))
		{
			// set these variables to meet the condition
			this.isAPageOrAField="field";
			this.sectionID = "Title";
			if(this.isAPageOrAField.equalsIgnoreCase("field"))
			{
				// Set the sectionID
				this.sectionID = this.sectionID + "." + gherkinPageName2 ;
				System.out.println("current Section = " + this.sectionID);
				// set the gherkinPageName
				this.pageName = gherkinPageName2 + " " + "for x field";
				System.out.println("Call this page = " + this.pageName.toLowerCase());
			}
			else if(this.isAPageOrAField.equalsIgnoreCase("page"))
			{
				// Set the sectionID
				this.sectionID =  gherkinPageName2 ;
				System.out.println("current Section = " + this.sectionID);
				// set the gherkinPageName
				this.pageName = gherkinPageName2 + " " + "for x";
				System.out.println("Call this page = " + this.pageName.toLowerCase());
			}
			
			// Get the page
			currentPage =  getCurrentPage(this.pageName.toLowerCase());
			// Print a sample field
			System.out.println("sign in object path = " + currentPage.getElement("Sign in", "TITLE"));
		}
        ///////////////////////////////////////////////////////////////////////

	}


	public void enters_inputX_into_the_elementY_input_field(String gherkinInputValue, String gherkinElement) throws Throwable {
		if(sectionID.equalsIgnoreCase("Main"))
		   currentPage.getElement(gherkinElement).sendKeys(gherkinInputValue);
		   // remember to add this input entry into the InputEntries table
		else
			currentPage.getElement(gherkinElement,this.objectID).sendKeys(gherkinInputValue);
		   // remember to add this input entry into the InputEntries table
	}

	public void verifyThatAllExpectedElementsAreDisplayedOnPage() {
		currentPage.verifyThatAllExpectedElementsAreDisplayedOnPage(this.pageName);
	}
	
}
