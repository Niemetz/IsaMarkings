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
	    System.out.println("Element to be clicked = " + currentPage.getElement(elementID,objectID));
	    System.out.println("=============================================");
	}

public void lands_on_the_section(String gherkinSectionID) throws Throwable 
{
	if(gherkinSectionID.contains("ISA Markings for"))
	{
		// get the sectionID
		sectionID = gherkinSectionID.split("for")[1].trim().split("field")[0].trim();
		
		// get the objectID
		objectID = tableofIsaObjects.getObjectID(sectionID);
		
		// get the pageID
		if(tableofIsaObjects.getObjecType(sectionID).equalsIgnoreCase("field"))
			pageID = "isa markings for x field";
		else if(tableofIsaObjects.getObjecType(sectionID).equalsIgnoreCase("object"))
			pageID = "isa markings for x";


		// Get the page
		currentPage =  getCurrentPage(pageID.toLowerCase());
		
		System.out.println("User lands on section = " + sectionID);
		System.out.println("Page Unique Element = " + currentPage.getElement("Page Unique Element".toLowerCase(), objectID.toLowerCase()));
		System.out.println("=============================================");
	}	
	else if(gherkinSectionID.contains(".") && !gherkinSectionID.contains("Main"))
	{
		// identify the pageID by splitting the sebSectonLinkID
		String[] pageIdArray = gherkinSectionID.split("\\.");
		
	    // get the objectID
		objectID = tableofIsaObjects.getObjectID(pageIdArray[0].trim().toLowerCase());
		
		// get the pageID
		String objectType = tableofIsaObjects.getObjecType(pageIdArray[0].trim().toLowerCase());
		if(objectType.equalsIgnoreCase("field"))
			pageID = pageIdArray[pageIdArray.length - 1].trim().toLowerCase() + " for x field";
		else if(objectType.equalsIgnoreCase("object"))
			pageID = pageIdArray[pageIdArray.length - 1].trim().toLowerCase() + " for x";
		
		// get the sectionID
		sectionID = gherkinSectionID;
		
		// Get the page
		currentPage =  getCurrentPage(pageID.toLowerCase());	
		
		System.out.println("User lands on section  = " + sectionID);
		System.out.println("Page Unique Element = " + currentPage.getElement("Page Unique Element".toLowerCase(), objectID.toLowerCase()));
		System.out.println("=============================================");

	}
	else
	{
		// get the sectionID
		sectionID = gherkinSectionID;
		// get the pageID
	    pageID = gherkinSectionID;
		// Get the page
		currentPage =  getCurrentPage(pageID.toLowerCase());	

		System.out.println("User lands on section  = " + sectionID);
		System.out.println("Page Unique Element = " + currentPage.getElement("Title".toLowerCase(),objectID));
		System.out.println("=============================================");
	}
	
}

public void lands_on_pageX(String gherkinPageID) throws Throwable 
{
     // Get the page
	 System.out.println("User lands on page  = " + gherkinPageID);
	 System.out.println("Page Unique Element = " + getCurrentPage(gherkinPageID.toLowerCase()).getElement("Page Unique Element".toLowerCase(),objectID));
	 System.out.println("=============================================");
}


	// Ghekin statment = 
	// 1 - When user clicks on the "SectionID.subSectionID" 
    // For Exmaple: When user clicks on the "Title.Policies" link.

	public void clicks_on_the_section_link(String gherkinSectionLinkID) throws Throwable 
	{
		// identify the pageID by splitting the sebSectonLinkID
		String[] pageIdArray = gherkinSectionLinkID.split("\\.");
		
	    // get the objectID
		objectID = gherkinSectionLinkID.split("\\.")[0].trim().toLowerCase();

		// get the elementID
        elementID = pageIdArray[pageIdArray.length - 1].trim();
        System.out.println("user clicks on the " + gherkinSectionLinkID + " section link");
	    System.out.println("Element to be clicked = " + currentPage.getElement(elementID, objectID.toLowerCase()));
	    System.out.println("=============================================");
	}
	
}
