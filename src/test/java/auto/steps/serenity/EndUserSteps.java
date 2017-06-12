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
	String elementID;


	// This table is used to store all the instance variables for pages under test
	private static final Map<String, AmazonBasePageObject> allPagesUnderTest = new HashMap<>();
	
	// This table contains all pages of the app
	TableOfAllPages tableOfAllPages = new TableOfAllPages();
	TableofIsaObjects tableofIsaObjects = new TableofIsaObjects();
	ObjectTypeIdentification objectTypeIdentification = new ObjectTypeIdentification();
	


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
        elementID = gherkinElementID.toLowerCase() + " button for " +  gherFieldID + " field";
        System.out.println("When user clicks on the " + gherkinElementID +  " button by the " +  gherFieldID +  " field");
	    System.out.println("Element to be clicked = " + currentPage.getElement(elementID));
	    System.out.println("=============================================");
	}

public void lands_on_the_section(String gherkinSectionID) throws Throwable 
{
	if(gherkinSectionID.contains("ISA Markings for"))
	{
		if(gherkinSectionID.contains("field"))  // field level
		{
			// get objectID
			objectID = gherkinSectionID.split("for")[1].trim().split("field")[0].trim();

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
			System.out.println("User lands on section = " + gherkinSectionID);
			System.out.println("Page Unique Element = " + currentPage.getElement("Page Unique Element".toLowerCase(), objectID));
			System.out.println("=============================================");
		}
		else if(!gherkinSectionID.contains("field")) // Page level
		{
			// get the objectID
			objectID = gherkinSectionID.split("for")[1].trim();
			
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
			System.out.println("Element \"policies\"  = " + currentPage.getElement("policies", objectID));
		}
	}
	else
	{
//		// set sectionID to "Main"
//		sectionID = "Main";
//		// set objectID to "Main"
//		objectID = "Main";
//	    // Get the page
		System.out.println("User lands on page  = " + gherkinSectionID);
		System.out.println("Page Unique Element = " + getCurrentPage(gherkinSectionID.toLowerCase()).getElement(gherkinSectionID.toLowerCase()));
	    //getCurrentPage(gherkinPageID.toLowerCase()).getElement(gherkinPageID.toLowerCase());
	}	
}

public void lands_on_pageX(String gherkinPageID) throws Throwable 
{
     // Get the page
	 System.out.println("User lands on page  = " + gherkinPageID);
	 System.out.println("Page Unique Element = " + getCurrentPage(gherkinPageID.toLowerCase()).getElement("Page Unique Element".toLowerCase()));
	 System.out.println("=============================================");
}


	// Ghekin statment = 
	// 1 - When user clicks on the "SectionID.subSectionID" 
    // For Exmaple: When user clicks on the "Title.Policies" link.

	public void clicks_on_the_subsection_link(String subSectionLinkID) throws ClassNotFoundException 
	{
		// identify the pageID by splitting the sebSectonLinkID
		String[] pageIdArray = subSectionLinkID.split("\\.");
		
	    // get the objectID
		objectID = pageIdArray[0].trim().toLowerCase();

		// get the elementID
        elementID = pageIdArray[pageIdArray.length-1].trim();
	    System.out.println("Element to be clicked = " + currentPage.getElement(elementID, objectID.toLowerCase()));
	    

		
		
//		if(subSectionLinkID.contains("ISA Markings for"))
//		{
//			if(subSectionLinkID.contains("field"))  // field level
//			{
//				// get objectID
//				objectID = subSectionLinkID.split("for")[1].trim().split("field")[0].trim();
//
//				// Set the sectionID
//				sectionID = sectionID + "." + subSectionLinkID;
//				System.out.println("sectionID = " + sectionID);
//
//				// Set the pageID
//				pageID = subSectionLinkID.toLowerCase() + " for x field".toLowerCase();
//				System.out.println("pageID = " + pageID);
//
//				// get the actual objectID
//				objectID = tableofIsaObjects.getActualObjectID(objectID.toLowerCase());
//				System.out.println("objectID = " + objectID);
//
//				// Get the page
//				currentPage =  getCurrentPage(pageID.toLowerCase());
//				
//				// Print a sample field
//				System.out.println("Elelment \"Sign in\"  = " + currentPage.getElement("Sign in", objectID));
//			}
//			else if(!subSectionLinkID.contains("field")) // Page level
//			{
//				// get the objectID
//				objectID = subSectionLinkID.split("for")[1].trim();
//
//				// Set the sectionID
//				sectionID = sectionID + "." + subSectionLinkID;
//				System.out.println("sectionID = " + sectionID);
//
//				// Set the page to "ISA Markings for X"
//				pageID = subSectionLinkID + " for X";
//				System.out.println("pageID = " + pageID.toLowerCase());
//
//				// get the actual objectID
//				objectID = tableofIsaObjects.getActualObjectID(objectID.toLowerCase());
//				System.out.println("objectID = " + objectID);
//
//				// Get the page
//				currentPage =  getCurrentPage(pageID.toLowerCase());
//				// Print a sample field
//				System.out.println("Elelment \"Sign in\"  = " + currentPage.getElement("Sign in", objectID));
//			}
//		}
//		///////////////////////////////////////////////////////////////	 
	}
	
}
