package auto.steps.serenity;

import java.util.HashMap;
import java.util.Map;
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
	String isAPageOrAField ;

	// This table is used to store all the instance variables for pages under test
	private static final Map<String, AmazonBasePageObject> allPagesUnderTest = new HashMap<>();
	
	// This table contains all pages of the app
	TableOfAllPages tableOfAllPages = new TableOfAllPages();
	TableofIsaObjects tableofIsaObjects = new TableofIsaObjects();

	public EndUserSteps() {
		super() ;
		pageID = null;
		this.currentPage = null;
		sectionID = "Main";
		objectID = null;
		isAPageOrAField = null;
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
	
	public void clicks_on_elementX(String gherkinElement) throws Throwable {
	//	currentPage.getElement(gherkinElement).waitUntilVisible().and().waitUntilClickable().click();
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
	       //System.out.println("click on this button => " + templateTableName + " for " +  sectionID);   
	}
	
	// Create a step definition for "And User lands on the "ISA Custom Markings for Title field" section
	//or "Given User is at the "ISA Custom Markings for Title field" section
	public void lands_on_pageX(String gherkinpageID) throws Throwable {
		
		  	pageID = gherkinpageID.toLowerCase();
			currentPage =  getCurrentPage(pageID);
			currentPage.getElement("page unique element");
			
	    // Copy this block to real EndUserStep
		///////////////////////////////////////////////////////////////////////
		// Two Gherkin Statements can use this method: 
	    // 1 - Then user lands on the "X" section
		// 2 - Then user should see the "X" section
		
	    // Test Data to test this block of code
		//String gherkinpageID2 = "ISA Markings for Title field";
		String gherkinpageID2 = "Control Set";
		//String gherkinpageID2 = "Affiliation";
			
        // Check to see if the "X" section is a "ISA Markings" section
		if(gherkinpageID2.contains("ISA Markings for") && gherkinpageID.equalsIgnoreCase("Login") )
		{
			if(gherkinpageID2.contains("field"))  // field level
			{
				// Set the global isAPageOrAField to "field"
				isAPageOrAField="field";
				
				// get the isa field name
				objectID = gherkinpageID2.split("for")[1].trim().split("field")[0].trim();
				
				// Set the sectionID
				sectionID = objectID;
				
				// Set the page to "ISA Custom Markings for X field "
				pageID = gherkinpageID2.replace(objectID, "X");
				System.out.println("The page to be called = " + pageID.toLowerCase());
				
				// get the actual objectID
				objectID = tableofIsaObjects.getActualObjectID(objectID.toLowerCase());
				System.out.println("ObjectID = " + objectID);
				
				// Get the page
				currentPage =  getCurrentPage(pageID.toLowerCase());
				// Print a sample field
				System.out.println("CSS Path for Sign in  = " + currentPage.getElement("Sign in", objectID));
			}
	      else // Page level
		     {
				// Set the global isAPageOrAField to "page"
				isAPageOrAField="page";
				
				// get the page level
				objectID = gherkinpageID2.split("for")[1].trim();
				
				// Set the sectionID
				sectionID = objectID;
				
				// Set the page to "ISA Custom Markings for X"
				pageID = gherkinpageID2.replace(objectID, "X");
				System.out.println("The page to be called = " + pageID.toLowerCase());
				
				// get the actual objectID
				objectID = tableofIsaObjects.getActualObjectID(objectID.toLowerCase());
				System.out.println("ObjectID = " + objectID);

				
				// Get the page
				currentPage =  getCurrentPage(pageID.toLowerCase());
				// Print a sample field
				System.out.println("CSS Path for Sign in  = " + currentPage.getElement("Sign in", objectID));

			}
		}
		
		// Check to see if the section "X" is a sub-section of a "ISA Markings" section
		else if(!gherkinpageID2.contains("ISA Markings for") && gherkinpageID.equalsIgnoreCase("Login"))
		{
		   // YES, the section "X" is one of the sub-section of a "ISA Markings" section
		   if(gherkinpageID2.equalsIgnoreCase("control set") ||
			  gherkinpageID2.equalsIgnoreCase("policies") ||
			  gherkinpageID2.equalsIgnoreCase("resonsible entity") ||
			  gherkinpageID2.equalsIgnoreCase("further sharing") )
		   {
			   ///////////////////////////////////////
			   // Test Data to test out this section
			   isAPageOrAField="field";
			   objectID = "title";
			   sectionID = "Title";
               ///////////////////////////////////////
			    // Check if the parent "ISA Markings" section is at the field level or at the page level
				if(isAPageOrAField.equalsIgnoreCase("field"))
				{
					// Set the sectionID
					sectionID = sectionID + "." + gherkinpageID2 ;
					System.out.println("current Section = " + sectionID);
					
					// set the gherkinpageID
					pageID = gherkinpageID2 + " " + "for x field";
					System.out.println("Call this page = " + pageID.toLowerCase());
					
					// Get the page
					currentPage =  getCurrentPage(pageID.toLowerCase());
					// Print the retrieved Element
					
					System.out.println("CSS Path for Sign in  = " + currentPage.getElement("Sign in", objectID));
				}
				//else if(isAPageOrAField.equalsIgnoreCase("page"))
				else
				{
					// Set the sectionID
					sectionID = sectionID + "." + gherkinpageID2 ;
					System.out.println("current Section = " + sectionID);
					
					// set the gherkinpageID
					pageID = gherkinpageID2 + " " + "for x";
					System.out.println("Call this page = " + pageID.toLowerCase());
					
					// Get the page
					currentPage =  getCurrentPage(pageID.toLowerCase());
					
					// Print the retrieved Element
					System.out.println("CSS Path for Sign in  = " + currentPage.getElement("Sign in", objectID));
					
				}
		   }

	   // If the "X" section is NONE of an "ISA MArking" section or a sub-section
	   else 
	   {
		   sectionID = gherkinpageID2;
		   System.out.println("current Section = " + sectionID);
		   
		   pageID = gherkinpageID2;
		   
		   // Get the page
		   currentPage =  getCurrentPage(pageID.toLowerCase());
		   
		   // Print the retrieved Element
		   System.out.println("CSS Path for Sign in  = " + currentPage.getElement("Sign in"));
	   }
         
	  }
      ///////////////////////////////////////////////////////////////////////
	}


	public void enters_inputX_into_the_elementY_input_field(String gherkinInputValue, String gherkinElement) throws Throwable {
//		if(sectionID.equalsIgnoreCase("Main"))
//		   currentPage.getElement(gherkinElement).sendKeys(gherkinInputValue);
//		   // remember to add this input entry into the InputEntries table
//		else
//			currentPage.getElement(gherkinElement,objectID).sendKeys(gherkinInputValue);
//		   // remember to add this input entry into the InputEntries table
	}

	public void verifyThatAllExpectedElementsAreDisplayedOnPage() {
		currentPage.verifyThatAllExpectedElementsAreDisplayedOnPage(pageID);
	}
	
}
