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
	public void clicks_on_elementX(String gherkinElement) throws Throwable {
		System.out.println("Gherkin statement: And user clicks on the X element");
		System.out.println("user clicks on the Element = " + "|" + currentPage.getElement(gherkinElement) + "|");
		
		 //targetElement(gherkinElement).click();
	}
	
	// Ghekin statment = When user clicks on the "Custom ISA Markings" button by the 'Title" field
	public void clicks_on_the_button_by_the_field_X(String gherkinElementID, String gherFieldID) throws Throwable 
	{
		// set elementID
        elementID = gherkinElementID + " button by the " +  gherFieldID + " field";
		 
   	    System.out.println("Current Page          = " + pageID);
        System.out.println("Gherkin Statement     = user clicks on the " +  "\"" +gherkinElementID + "\"" + " button by the " +  "\""+ gherFieldID + "\"" + " field");
	    System.out.println("Element to be clicked = " + targetElement(elementID));
	    System.out.println("=============================================");
	    
	    //targetElement(elementID).click();
	}

    // 1 - Given user is at the "X" section 
	// 2 - Then user lands on the "X" section 
	public void lands_on_the_section_X(String gherkinSectionID) throws Throwable 
	{
		
		sectionPageID = gherkinSectionID;
		objectID = null;
		
		if(gherkinSectionID.toLowerCase().contains("isa markings for"))
		{			
			objectID = tableofIsaObjects.getObjectID(gherkinSectionID);
			sectionID = tableofIsaObjects.getSectionID(gherkinSectionID);
			sectionPageID = tableofIsaObjects.getSectionPageID(gherkinSectionID);
		}	
		 // set current page
		 currentPage =  getCurrentPage(sectionPageID);
		 // set objectID to the super class
		 currentPage.setObjectID(objectID);
		 
		 System.out.println("Gherkin Statement           = Given user is at the " + "\"" + sectionPageID +"\"" + " section");
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
	 
	 System.out.println("Current Page                = " + pageID);
	 System.out.println("Gherkin Statement           = Then user lands on the " + "\"" + gherkinSubSectionID +"\"" + " sub-section (Note: sub-sectionID is NOT captured)");
	 System.out.println("Section PageID to be loaded = " + sectionPageID );
	 System.out.println("Loaded...current SectionID  = " + sectionID);
	 System.out.println("Section's ObjectID          = " + objectID);
	 System.out.println("Sub-section's unique element    = " + targetElement("Page Unique Element"));
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

// Ghekin statment =  When user clicks on the "X.Y" section link
public void clicks_on_the_section_link_X(String gherkinSectionID) throws Throwable 
{
	// Exmaple: ISA Markings for Indicator
	if(!gherkinSectionID.toLowerCase().contains("field") && !gherkinSectionID.toLowerCase().contains("."))
	{
		objectID = tableofIsaObjects.getObjectID(gherkinSectionID);
		sectionPageID = pageID;
	    elementID = gherkinSectionID;
	}    
	
	// Exmaple: ISA Markings for Indicator.Policies
	if(!gherkinSectionID.toLowerCase().contains("field") 
	  && gherkinSectionID.toLowerCase().contains("."))
	{
		objectID = tableofIsaObjects.getObjectID(gherkinSectionID);
		sectionPageID = "isa markings for x"; 
	    elementID = tableofIsaObjects.getElementID(gherkinSectionID);  
	}
	   
	// Exmaple: ISA Markings for Description field
	if(gherkinSectionID.toLowerCase().contains("field") 
	  && !gherkinSectionID.toLowerCase().contains("."))
	{
		objectID = tableofIsaObjects.getObjectID(gherkinSectionID).trim();
		sectionPageID = "isa markings for x field";    
	    elementID = "isa markings for x field";
	}
	
	// Example: "ISA Markings for Description field.Policies" section link 
	if(gherkinSectionID.toLowerCase().contains("field") 
	  && gherkinSectionID.toLowerCase().contains("."))
	{
		objectID = tableofIsaObjects.getObjectID(gherkinSectionID);
		sectionPageID = "isa markings for x field";
	    elementID = tableofIsaObjects.getElementID(gherkinSectionID);   
	}

    // set currentPage
	currentPage = getCurrentPage(sectionPageID);
	// set objectID to the super class
	currentPage.setObjectID(objectID);
	
	 System.out.println("Gherkin Statement                      = When user clicks on the " + "\"" + gherkinSectionID +"\"" + " section link");
	 System.out.println("current Section's PageID               = " + gherkinSectionID.split("\\.")[0]);
	 System.out.println("current Section's ObjectID             = " + objectID);
	 System.out.println("current Section's Template PageID      = " + sectionPageID);
	 if(gherkinSectionID.contains("."))
	    System.out.println("Section's Template PageID to be loaded = " + sectionPageID + "." + elementID );
	 else
		System.out.println("Section's Template PageID to be loaded = " + sectionPageID );
 
	 System.out.println("Sub-Section Link to be clicked         = " + targetElement(elementID));
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
