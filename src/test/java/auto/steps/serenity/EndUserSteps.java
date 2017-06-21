package auto.steps.serenity;

//import java.util.HashMap;
//import java.util.Map;
import auto.pages.AmazonBasePageObject;
import auto.util.*;
//import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import net.thucydides.core.steps.ScenarioSteps;

@SuppressWarnings("serial")
public class EndUserSteps extends ScenarioSteps {

	AmazonBasePageObject currentPage;
	
	// ISA Markings Variables
	String pageID;
	String sectionPageID;
	String sectionID ;
	String elementID;
	String objectID = null;

	// This table is used to store all the instance variables for pages under test
	//private static final Map<String, AmazonBasePageObject> allPagesUnderTest = new HashMap<>();
	
	// This table contains all pages of the app
	TableOfAllPages tableOfAllPages = new TableOfAllPages();
	
	//This table contains the "real" objectID.  
	//The objectID is used to identify the type of an ISA Markings object.
	TableofIsaObjects tableofIsaObjects = new TableofIsaObjects();

	public EndUserSteps() 
	{
		super() ;
		this.pageID = null;
		this.currentPage = null;
		this.sectionID = null;
		this.elementID = null;
		this.sectionPageID = null;
	}
	
	@Step
	public void navigates_to_page(String gherkinpageID) throws Throwable {
		currentPage = getCurrentPage(gherkinpageID);
		currentPage.open();
	}
	
	@SuppressWarnings("unchecked")
	public AmazonBasePageObject getCurrentPage(String gherkinpageID) throws ClassNotFoundException 
	{
		return (AmazonBasePageObject) getPages().get(tableOfAllPages.getClass(gherkinpageID));
	}
	
	public  String  targetElement(String gherkinElement)
	{
		return currentPage.getElement(gherkinElement);
	}
	// This is where the a page, a section or a sub-section is loaded.
	public void clicks_on_elementX(String gherkinElement) throws Throwable {
		//currentPage.getElement(gherkinElement).waitUntilVisible().and().waitUntilClickable().click();
	}
	
	// Ghekin statment = When user clicks on the "Custom ISA Markings" button by the 'Title" field
	public void clicks_on_the_button_by_the_field(String gherkinElementID, String gherFieldID) throws Throwable 
	{
        elementID = gherkinElementID + " button by the " +  gherFieldID + " field";
        
   	    System.out.println("Current Page          = " + pageID);
        System.out.println("Gherkin Statement     = When user clicks on the " + gherkinElementID + " button by the " +  "\""+ gherFieldID + "\"" + " field");
        System.out.println("Current SectionID     = " + sectionPageID);
	    System.out.println("Element to be clicked = " + targetElement(elementID));
	    System.out.println("=============================================");
	}

// 1 - Given user is at the "X.Y..." section 
// 2 - Then user lands on the "ISA Markings for X field" section
public void lands_on_the_section_X(String gherkinSectionID) throws Throwable 
{
	if(gherkinSectionID.contains("ISA Markings for"))
	{
		// get the sectionID
		sectionID = gherkinSectionID.split("for")[1].trim().split("field")[0].trim();
		//get objectID
		objectID = tableofIsaObjects.getObjectID(sectionID);
		// get the sectionPageID
		if(tableofIsaObjects.getObjecType(sectionID).equalsIgnoreCase("field"))
			sectionPageID = "isa markings for x field";
		else if(tableofIsaObjects.getObjecType(sectionID).equalsIgnoreCase("object"))
			sectionPageID = "isa markings for x";
	}	
	else if(gherkinSectionID.contains(".") && !gherkinSectionID.contains("Main"))
	{
		// identify the pageID by splitting the sebSectonLinkID
		String[] pageIdArray = gherkinSectionID.split("\\.");
		// get the sectionPageID
		String objectType = tableofIsaObjects.getObjecType(pageIdArray[0].trim().toLowerCase());
		if(objectType.equalsIgnoreCase("field"))
			sectionPageID = pageIdArray[pageIdArray.length - 1].trim() + " for x field";
		else if(objectType.equalsIgnoreCase("object"))
			sectionPageID = pageIdArray[pageIdArray.length - 1].trim() + " for x";
		// get the sectionID
		sectionID = gherkinSectionID;
		// get objectID
		objectID = tableofIsaObjects.getObjectID(pageIdArray[0].trim());
	}
	else
	{
		// get the sectionID
		sectionID = gherkinSectionID;
		// get the sectionPageID
		sectionPageID = gherkinSectionID;

		// set objectID
		objectID = null;	
	}

	 // Get the current page
	 currentPage =  getCurrentPage(sectionPageID);
	 // set the objectID to the super class
	 currentPage.setObjectID(objectID);
	 
	 System.out.println("Current Page                = " + pageID);
	 System.out.println("Gherkin Statement           = Then user lands on the " + "\"" + sectionPageID +"\"" + " section");
	 System.out.println("Section PageID to be loaded = " + sectionPageID );
	 System.out.println("Current SectionID           = " + sectionID);
	 System.out.println("Section's unique element    = " + targetElement("Page Unique Element"));
	 System.out.println("=============================================");
}

public void lands_on_page_X(String gherkinPageID) throws Throwable 
{
	 // set the pageID
     this.pageID = gherkinPageID;
     //get the current page
     currentPage = getCurrentPage(this.pageID);
     
     System.out.println("Current Page            = " + pageID);
	 System.out.println("Gherkin Statement       = Then user lands on the " + "\"" + gherkinPageID + "\"" + " page");
	 System.out.println("PageID to be loaded     = " + pageID);
	 System.out.println("Page's unique element   = " + targetElement("Page Unique Element"));
	 System.out.println("=============================================");
}

	// Ghekin statment = 
	// 1 - When user clicks on the "SectionID.subSectionID" 
    // For Exmaple: When user clicks on the "Title.Policies" link.
	public void clicks_on_the_section_link(String gherkinSectionLinkID) throws Throwable 
	{
		if(gherkinSectionLinkID.contains("."))
		{
		  // identify the pageID by splitting the gherkinSectionLinkID
		  String[] pageIdArray = gherkinSectionLinkID.split("\\.");
		
		  // set the objectID to the super class
		  currentPage.setObjectID(tableofIsaObjects.getObjectID(gherkinSectionLinkID.split("\\.")[0].trim()));

		  // set the sectionID
		  for(int i=0; i< (pageIdArray.length -1) ;i++)
		  {
			if(i == 0)
		       sectionID = pageIdArray[i];
			else
			   sectionID = sectionID + "." + pageIdArray[i];
		  }

		 // get the elementID
         elementID = pageIdArray[pageIdArray.length - 1].trim();

	    } //End If
		else
		{
			elementID = gherkinSectionLinkID;
			sectionID = gherkinSectionLinkID;
		}
		
   	    System.out.println("Current Page          = " + pageID);
        System.out.println("Gherkin Statement     = " + "Section link to be clicked = " + "\"" + gherkinSectionLinkID + "\"");
        System.out.println("Current SectionID     = " + sectionID);
	    System.out.println("Element to be clicked = " + targetElement(elementID));
	    System.out.println("=============================================");
	}

	
}
