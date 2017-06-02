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

	AmazonBasePageObject currentPage;
	
	// ISA Markings Variables
	String pageID;
	String sectionID ;
	String objectID;


	// This table is used to store all the instance variables for pages under test
	private static final Map<String, AmazonBasePageObject> allPagesUnderTest = new HashMap<>();
	
	// This table contains all pages of the app
	TableOfAllPages tableOfAllPages = new TableOfAllPages();
	TableofIsaObjects tableofIsaObjects = new TableofIsaObjects();


	public EndUserSteps() {
		super() ;
		this.pageID = null;
		this.currentPage = null;
		this.sectionID = null;
		this.objectID = null;
	}
	
	@Step
	public void navigates_to_page(String gherkinpageID) throws Throwable {
		currentPage = getCurrentPage(gherkinpageID);
		currentPage.open();
	}
	
	@SuppressWarnings("unchecked")
	public AmazonBasePageObject getCurrentPage(String gherkinpageID) throws ClassNotFoundException 
	{
		// if the desired page was not registered in the allPageUnderTest, 
		// then add the desired page to the allPageUnderTest.
		pageID = gherkinpageID.toLowerCase();
		if (!allPagesUnderTest.containsKey(pageID)) 
		{
		    @SuppressWarnings("rawtypes")
		    Class targetPageClass = (Class) tableOfAllPages.getClass(pageID);
			allPagesUnderTest.put(new String(pageID),  (AmazonBasePageObject) getPages().get(targetPageClass));
		}
		// return the desired page to the caller
		return allPagesUnderTest.get(pageID);
	}
	
	// This is where the a page, a section or a sub-section is loaded.
	public void clicks_on_elementX(String gherkinElement) throws Throwable {
		//currentPage.getElement(gherkinElement).waitUntilVisible().and().waitUntilClickable().click();
	}
	
	// Ghekin statment = When user clicks on the "Custom ISA Markings" button by the 'Title" field
	public void clicks_on_the_button_by_the_field(String gherkinElementID, String gherFieldID) throws Throwable 
	{
		System.out.println("(1) - When user clicks on the \"Custom ISA Markings\" button by the \"Title\" field");
		// Take advantage of the fact that the user is now on the isa markings at a field level,
		// capture all needed variables for the next steps
		
		// Set the page template to "isa markings for x field"
		pageID = "isa markings for x field";
		System.out.println("pageID = " + pageID);
		
		// set the objectID to the actual objectiD by looking up the value in the tableofIsaObjects
		objectID = tableofIsaObjects.getActualObjectID(gherFieldID.toLowerCase());
		System.out.println("objectID= " + objectID);
		
		// set the sectionID to field name
		sectionID = gherFieldID;
		System.out.println("sectionID = " + sectionID);
		
		// At this point the main page has been load.
		// just get the element "Custom ISA Markings" button by the 'Title" field, then click on it.
		// Exmaple: 
		//currentPage.getElement(pageID, objectID)).click();

		
		// Load the page based on the page template
		currentPage =  getCurrentPage(pageID);
		System.out.println("====================================");	
		
		// Test Data
		System.out.println("(2) - Then user lands on the \"ISA Markings for Title field\" section");
		String gherkinPageID = "ISA Markings for Title field";

//		System.out.println("(2) - Then user lands on the \"ISA Markings for Indicator\" section");
//		String gherkinPageID = "ISA Markings for Indicator";
		
	    lands_on_pageX(gherkinPageID);
		
		// CONTRO SET
	    ///////////////////////////////////
	    System.out.println("(3) - When user clicks on the \"Control Set\" link of the \"ISA Markings for Title field\" section");
	    String subSectionLinkIDControlSet = "Control Set";
	    String sectionPageIDControlSet  = "ISA Markings for Title field";
	    
	    clicks_on_the_link_on_the_section(subSectionLinkIDControlSet, sectionPageIDControlSet);
	    
//	    System.out.println("(3) - When user clicks on the \"Control Set\" link of the \"ISA Markings for Indicator\" section");
//	    String subSectionLinkID = "Control Set";
//	    String sectionPageID = "ISA Markings for Indicator";
	    
	    // POLICIES
//	    //////////////////////////////////
//	    System.out.println("(3) - When user clicks on the \"Policies\" link of the \"ISA Markings for Title field\" section");
//	    String subSectionLinkID = "Policies";
//	    String sectionPageID = "ISA Markings for Title field";
	    
//	    System.out.println("(3) - When user clicks on the \"Policies\" link of the \"ISA Markings for Indicator\" section");
//	    String subSectionLinkID = "Policies";
//	    String sectionPageID = "ISA Markings for Indicator";
	    
	    // FURTHER SHARING
	    //////////////////////////////////
	    System.out.println("(3) - When user clicks on the \"Further Sharing\" link of the \"ISA Markings for Title field\" section");
	    String subSectionLinkID = "Further Sharing";
	    String sectionPageID = "ISA Markings for Title field";
	    
//	    System.out.println("(3) - When user clicks on the \"Further Sharing\" link of the \"ISA Markings for Indicator\" section");
//	    String subSectionLinkID = "Further Sharing";
//	    String sectionPageID = "ISA Markings for Indicator";
	    
		clicks_on_the_link_on_the_section(subSectionLinkID, sectionPageID);
		
	}

public void lands_on_pageX(String gherkinPageID) throws Throwable 
{
	if(gherkinPageID.contains("ISA Markings for"))
	{
		if(gherkinPageID.contains("field"))  // field level
		{
			// get objectID
			objectID = gherkinPageID.split("for")[1].trim().split("field")[0].trim();

			// Set the sectionID
			sectionID = objectID;
			System.out.println("sectionID = " + sectionID);
			
			// Set the pageID
			pageID = "ISA Markings for X field";
			System.out.println("pageID = " + pageID);

			// get the actual objectID
			objectID = tableofIsaObjects.getActualObjectID(objectID.toLowerCase());
			System.out.println("objectID = " + objectID);

			// Get the page
			currentPage =  getCurrentPage(pageID.toLowerCase());
			
			// Print a sample field
			System.out.println("Element \"Sign in\"  = " + currentPage.getElement("Sign in", objectID));
		}
		else if(!gherkinPageID.contains("field")) // Page level
		{
			// get the objectID
			objectID = gherkinPageID.split("for")[1].trim();
			
			// Set the sectionID
			sectionID = objectID;
			System.out.println("sectionID = " + sectionID);

			// Set the page to "ISA Markings for X"
			pageID = "ISA Markings for X";
			System.out.println("pageID = " + pageID.toLowerCase());

			// get the actual objectID
			objectID = tableofIsaObjects.getActualObjectID(objectID.toLowerCase());
			System.out.println("objectID = " + objectID);

			// Get the page
			currentPage =  getCurrentPage(pageID.toLowerCase());
			// Print a sample field
			System.out.println("Element \"Sign in\"  = " + currentPage.getElement("Sign in", objectID));
		}
	}
	else
	{
//		// set sectionID to "Main"
//		sectionID = "Main";
//		// set objectID to "Main"
//		objectID = "Main";
//	    // Get the page
//	    getCurrentPage(gherkinPageID.toLowerCase()).getElement(gherkinPageID.toLowerCase(), objectID);
	}	
}
	// Ghekin statment = 
	// - When user clicks on the "Policies" link on the "ISA Marking for Indicator" section
	public void clicks_on_the_link_on_the_section(String subSectionLinkID, String sectionPageID) throws ClassNotFoundException 
	{
		if(sectionPageID.contains("ISA Markings for"))
		{
			if(sectionPageID.contains("field"))  // field level
			{
				// get objectID
				objectID = sectionPageID.split("for")[1].trim().split("field")[0].trim();

				// Set the sectionID
				sectionID = sectionID + "." + subSectionLinkID;
				System.out.println("sectionID = " + sectionID);

				// Set the pageID
				pageID = subSectionLinkID.toLowerCase() + " for x field".toLowerCase();
				System.out.println("pageID = " + pageID);

				// get the actual objectID
				objectID = tableofIsaObjects.getActualObjectID(objectID.toLowerCase());
				System.out.println("objectID = " + objectID);

				// Get the page
				currentPage =  getCurrentPage(pageID.toLowerCase());
				
				// Print a sample field
				System.out.println("Elelment \"Sign in\"  = " + currentPage.getElement("Sign in", objectID));
			}
			else if(!sectionPageID.contains("field")) // Page level
			{
				// get the objectID
				objectID = sectionPageID.split("for")[1].trim();

				// Set the sectionID
				sectionID = sectionID + "." + subSectionLinkID;
				System.out.println("sectionID = " + sectionID);

				// Set the page to "ISA Markings for X"
				pageID = subSectionLinkID + " for X";
				System.out.println("pageID = " + pageID.toLowerCase());

				// get the actual objectID
				objectID = tableofIsaObjects.getActualObjectID(objectID.toLowerCase());
				System.out.println("objectID = " + objectID);

				// Get the page
				currentPage =  getCurrentPage(pageID.toLowerCase());
				// Print a sample field
				System.out.println("Elelment \"Sign in\"  = " + currentPage.getElement("Sign in", objectID));
			}
		}
		///////////////////////////////////////////////////////////////	 
	}

//	public void enters_inputX_into_the_elementY_input_field(String gherkinInputValue, String gherkinElement) throws Throwable {
//		if(sectionID.equalsIgnoreCase("Main"))
//		   currentPage.getElement(gherkinElement).sendKeys(gherkinInputValue);
//		   // remember to add this input entry into the InputEntries table
//		else
//			currentPage.getElement(gherkinElement,objectID).sendKeys(gherkinInputValue);
//		   // remember to add this input entry into the InputEntries table
//	}
	
//	public void verifyThatAllExpectedElementsAreDisplayedOnPage() {
//		currentPage.verifyThatAllExpectedElementsAreDisplayedOnPage(pageID);
//	}
	
}
