package auto.steps.serenity;

import java.util.Map.Entry;

import org.junit.Assert;

//import java.util.HashMap;
//import java.util.Map;
import auto.pages.AmazonBasePageObject;
import auto.util.*;
//import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import net.serenitybdd.core.pages.WebElementFacade;

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
		System.out.println("Gherkin statement: And user clicks on the X element");
		System.out.println("user clicks on the Element = " + "|" + currentPage.getElement(gherkinElement) + "|");
		//currentPage.getElement(gherkinElement).waitUntilVisible().and().waitUntilClickable().click();
	}
	
	// Ghekin statment = When user clicks on the "Custom ISA Markings" button by the 'Title" field
	public void clicks_on_the_button_by_the_field(String gherkinElementID, String gherFieldID) throws Throwable 
	{
		// set sectionID
		sectionID = gherFieldID;
        elementID = gherkinElementID + " button by the " +  gherFieldID + " field";
        
   	    System.out.println("Current Page          = " + pageID);
        System.out.println("Gherkin Statement     = user clicks on the " +  "\"" +gherkinElementID + "\"" + " button by the " +  "\""+ gherFieldID + "\"" + " field");
        System.out.println("Current SectionID     = " + sectionID);
	    System.out.println("Element to be clicked = " + targetElement(elementID));
	    System.out.println("=============================================");
	}

    // 1 - Given user is at the "X" section 
	public void is_at_the_section_X(String gherkinSectionID) throws Throwable 
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
			// set the sectionID
			sectionID = gherkinSectionID;
			// identify the pageID by splitting the gherkinSectionID
			String[] pageIdArray = gherkinSectionID.split("\\.");
			// get the sectionPageID
			String objectType = tableofIsaObjects.getObjecType(pageIdArray[0].trim().toLowerCase());
			if(objectType.equalsIgnoreCase("field"))
				sectionPageID = "isa markings for x field: " + pageIdArray[pageIdArray.length - 1].trim();
			else if(objectType.equalsIgnoreCase("object"))
				sectionPageID = "isa markings for x: " + pageIdArray[pageIdArray.length - 1].trim() ;
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
		 System.out.println("Gherkin Statement           = Given user is at the " + "\"" + sectionPageID +"\"" + " section");
		 System.out.println("Section PageID to be loaded = " + sectionPageID );
		 System.out.println("Current SectionID           = " + sectionID);
		 System.out.println("Section's unique element    = " + targetElement("Page Unique Element"));
		 System.out.println("=============================================");
	}

// Gherkin Statement: Then user lands on the "ISA Markings for X field" section
public void lands_on_the_section_X(String gherkinSectionID) throws Throwable 
{
	if(gherkinSectionID.contains("ISA Markings for"))
	{
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
			sectionPageID = "isa markings for x field: " + pageIdArray[pageIdArray.length - 1].trim();
		else if(objectType.equalsIgnoreCase("object"))
			sectionPageID = "isa markings for x: " + pageIdArray[pageIdArray.length - 1].trim() ;
		// get objectID
		objectID = tableofIsaObjects.getObjectID(pageIdArray[0].trim());
	}
	else
	{
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
	 System.out.println("Gherkin Statement           = user lands on the " + "\"" + gherkinSectionID +"\"" + " section");
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
	 System.out.println("Gherkin Statement       = user lands on the " + "\"" + gherkinPageID + "\"" + " page");
	 System.out.println("PageID to be loaded     = " + pageID);
	 System.out.println("Page's unique element   = " + targetElement("Page Unique Element"));
	 System.out.println("=============================================");
}

	// Ghekin statment =  When user clicks on the "X.Y" section link
    // For Exmaple: When user clicks on the "Title.Policies" link 
    // Important Note: 
    // The sectionID is set at the following gherkin statements:
    //  1 -  When user clicks on the "X.Y" section link
    //  2 -  Given user is at the "X" section
  
	public void clicks_on_the_section_link(String gherkinSectionLinkID) throws Throwable 
	{
		if(gherkinSectionLinkID.contains("."))
		{
		  // identify the pageID by parsing the gherkinSectionLinkID
		  String[] pageIdArray = gherkinSectionLinkID.split("\\.");
		
		  // set the objectID to the super class
		  currentPage.setObjectID(tableofIsaObjects.getObjectID(gherkinSectionLinkID.split("\\.")[0].trim()));
		  sectionID = gherkinSectionLinkID;

		 // get the elementID
         elementID = pageIdArray[pageIdArray.length - 1].trim();

	    } //End If
		else
		{
			elementID = gherkinSectionLinkID;
			sectionID = gherkinSectionLinkID;
		}
		
   	    System.out.println("Current Page          = " + pageID);
        System.out.println("Gherkin Statement     = " + "user clicks on the " + "\"" + gherkinSectionLinkID + "\"" + " section link");
        System.out.println("Current SectionID     = " + sectionID);
	    System.out.println("Element to be clicked = " + targetElement(elementID));
	    System.out.println("=============================================");
	}

	@Step
	public void verifies_that_all_expected_elmenets_are_dispayed() throws Throwable 
	{
		int i = 0;
		for (Entry<String, String> entry : AmazonBasePageObject.mapTable.entrySet()) 
		{
			//String key = entry.getKey();
			if (!(entry.getValue().contains("|dynamic"))  && !(entry.getKey().equalsIgnoreCase("page unique element")))	
			{	
				System.out.println("  " + ++i + ") " + "Verifying Element " + "\"" + entry.getKey() + "\"" + " is Displayed ... ");
				try 
				{
					//Assert.assertNotNull($(entry.getValue()).waitUntilVisible().and().waitUntilEnabled());
					System.out.println("  **** PASSED:   Element " + "\"" + entry.getValue() + "\"" + " FOUND ... ");
					System.out.println("  ============================================");
				} catch (Exception e) 
				{
					error_Element_is_Not_On_Page(entry.getKey());
		        }
			  }
        }
	}


    public void error_Element_is_Not_On_Page(String element) {
	   {
		  System.err.println("  **** FAILED:   Element " + "\"" + element + "\"" + " is NOT FOUND ...");
		  System.out.println("  ============================================");
	    }
   }
}
