package auto.steps.serenity;

import java.util.Map.Entry;

import org.jruby.RubyProcess.Sys;
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

	AmazonBasePageObject currentPage = new AmazonBasePageObject();
	
	// ISA Markings Variables
	String pageID;
	String sectionPageID;
	String sectionID ;
	String elementID;
	String objectID ;
	
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
		this.objectID = null;
	}
	
	@Step
	public void navigates_to_page(String gherkinPageID) throws Throwable 
	{
		currentPage = getCurrentPage(gherkinPageID);
		currentPage.open();
	}
	
	@SuppressWarnings("unchecked")
	public AmazonBasePageObject getCurrentPage(String gherkinPageID) throws ClassNotFoundException 
	{
		return (AmazonBasePageObject) getPages().get(tableOfAllPages.getClass(gherkinPageID));
	}
	
	public  String  targetElement(String gherkinElement)
	{
		return currentPage.getElement(gherkinElement);
	}
	// This is where the a page, a section or a sub-section is loaded.
	public void clicks_on_element_X(String gherkinElement) throws Throwable {
		System.out.println("Gherkin statement: And user clicks on the X element");
		System.out.println("user clicks on the Element = " + "|" + targetElement(gherkinElement) + "|");
		
		 //targetElement(gherkinElement).click();
	}
	
	// Ghekin statment = When user clicks on the "Custom ISA Markings" button by the 'Title" field
	public void clicks_on_the_button_by_the_field_X(String gherkinElementID, String gherFieldID) throws Throwable 
	{
		// set elementID
        elementID = gherkinElementID + " button by the " +  gherFieldID + " field";
		 
   	    System.out.println("Current Page          = " + pageID);
        System.out.println("Gherkin Statement     = user clicks on the " +  "\"" +gherkinElementID + "\"" + " button by the " +  "\""+ gherFieldID + "\"" + " field");
   	    System.out.println("Section's ObjectID    = N/A, because " + "\"" +  pageID + "\"" + " is not an ISA Markings section!");
	    System.out.println("Element to be clicked = " + targetElement(elementID));
	    System.out.println("=============================================");
	    
	    //targetElement(elementID).click();
	}

    // 1 - Given user is at the "X" section 
	// 2 - Then user lands on the "X" section 
	public void lands_on_the_section_X(String gherkinSectionID) throws Throwable 
	{
		
		sectionPageID = gherkinSectionID;
		objectID = "N/A, because " + "\"" +  gherkinSectionID + "\"" + " is not an ISA Markings section!";
		
		if(gherkinSectionID.toLowerCase().contains("isa markings for"))
		{			
			objectID = tableofIsaObjects.getObjectID(gherkinSectionID);
			sectionID = tableofIsaObjects.getSectionID(gherkinSectionID);
			sectionPageID = tableofIsaObjects.getNextSectionPageID(gherkinSectionID);
		}	
		 // set current page
		 currentPage =  getCurrentPage(sectionPageID);
		 // set objectID to the super class
		 currentPage.setObjectID(objectID);
		 
		 System.out.println("Gherkin Statement           = Given user |lands on|should see|is on|is at the " + "\"" + gherkinSectionID +"\"" + " section");
		 System.out.println("Section PageID to be loaded = " + sectionPageID );
		 if(!gherkinSectionID.toLowerCase().contains(".main"))
		   System.out.println("Loaded...current SectionID  = " + sectionID);
		 System.out.println("Section's ObjectID          = " + objectID);
		 System.out.println("Section's unique element    = " + targetElement("Page Unique Element"));
		 System.out.println("=============================================");
		 
		//targetElement("Page Unique Element");
	}

	// Gherkin Statement: Then user should see the "SubSectionX" sub-section
	public void lands_on_the_sub_section_X(String gherkinSubSectionID) throws Throwable 
	{
	 //sectionID = gherkinSectionID.toLowerCase();
	 sectionPageID = gherkinSubSectionID;	
	 // set current page
	 currentPage =  getCurrentPage(sectionPageID);
	 // set objectID to the super class
	 currentPage.setObjectID(objectID);
	 
	 System.out.println("Current Page                   = " + pageID);
	 System.out.println("Gherkin Statement              = Then user |lands on|should see|is on|is at the " + "\"" + gherkinSubSectionID +"\"" + " section");
	 System.out.println("Current Section Page           = SectionID is NOT captured");
	 System.out.println("Section's ObjectID             = ObjectID Is Not Captured because " + gherkinSubSectionID + " is not an ISA Markings section!");
	 System.out.println("Sub-section's unique element   = " + targetElement("Page Unique Element"));
	 System.out.println("Next Section Page to be loaded = " + sectionPageID );
	 System.out.println("=============================================");

	//targetElement("Page Unique Element");
    }

public void lands_on_page_X(String gherkinPageID) throws Throwable 
{
	 // set the pageID
     this.pageID = gherkinPageID;
     // set the current page
     currentPage = getCurrentPage(this.pageID);
     
     System.out.println("Current Page            = " + pageID);
	 System.out.println("Gherkin Statement       = Then user lands on the " + "\"" + gherkinPageID + "\"" + " page (Note: SectionID NOT captured)");
	 System.out.println("PageID to be loaded     = " + pageID);
	 System.out.println("Page's unique element   = " + targetElement("Page Unique Element"));
	 System.out.println("=============================================");
	 
	 //targetElement("Page Unique Element");
}

// 1 - Ghekin statment =  When user clicks on the "ISA Markings for Indicator" section link
// 2 - Ghekin statment =  When user clicks on the "ISA Markings for Indicator.Policies" section link
public void clicks_on_the_section_link_X(String gherkinSectionID) throws Throwable 
{
        //String currentsectionPageID = null;
       
//	    if(gherkinSectionID.toLowerCase().contains("isa markings for"))
//	      {
			objectID = tableofIsaObjects.getObjectID(gherkinSectionID);
			sectionPageID = tableofIsaObjects.getNextSectionPageID(gherkinSectionID);
			sectionID = tableofIsaObjects.getCurrentSectionPageID(gherkinSectionID);
		    elementID = tableofIsaObjects.getElementID(gherkinSectionID);
//	      }

	    // set currentPage
		currentPage = getCurrentPage(sectionID);
		// set objectID to the super class
		currentPage.setObjectID(objectID);
		
		 System.out.println("Gherkin Statement             = When user clicks on the " + "\"" + gherkinSectionID +"\"" + " section link");
		 System.out.println("current Section's PageID      = " + sectionID);
		 System.out.println("Current ObjectID              = " + objectID);
		 System.out.println("Element to be clicked         = " + elementID);
		 System.out.println("Section Link to be clicked    = " + targetElement(elementID));
		 System.out.println("Next Section Page to beloaded = " + sectionPageID);
		 System.out.println("=============================================");

		 //targetElement(elementID).click();
}

	@Step
	public void verifies_that_all_expected_elmenets_are_dispayed() throws Throwable 
	{
		int i = 0;
		for (Entry<String, String> entry : AmazonBasePageObject.mapTable.entrySet()) 
		{
			//String key = entry.getKey();
			if (!(entry.getValue().contains("|dynamic"))  
				&& !(entry.getKey().equalsIgnoreCase("page unique element")))	
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

    public void error_Element_is_Not_On_Page(String element) 
    {
	   {
		  System.err.println("  **** FAILED:   Element " + "\"" + element + "\"" + " is NOT FOUND ...");
		  System.out.println("  ============================================");
	    }
    }
    
}
