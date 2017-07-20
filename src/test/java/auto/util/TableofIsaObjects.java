package auto.util;

import java.util.HashMap;
import java.util.Map;

import org.jruby.RubyProcess.Sys;


public class TableofIsaObjects {
	public Map<String, String> mapTable = new HashMap<>();

	String objectID  = null;
	
	public TableofIsaObjects()
	{
		// Objects Level
		mapTable.put("indicator".toLowerCase(), "indicator".toLowerCase());
		mapTable.put("package".toLowerCase(), "package".toLowerCase());
		
		// Fields Level
		mapTable.put("title".toLowerCase(), "title".toLowerCase());
		mapTable.put("description".toLowerCase(), "description".toLowerCase());
		mapTable.put("indicator type".toLowerCase(), "indicator_type".toLowerCase());
	}

	public String getObjectID(String gherkinSectionID)
	{ 
		this.objectID = (gherkinSectionID.split("\\.")[0]).split("for")[1].split("field")[0].trim().toLowerCase();

		if(!(mapTable.containsKey(this.objectID)))
		{
		  System.err.println("ERROR: Section " + "\"" + gherkinSectionID + "\"" + " NOT FOUND in the TableOfIsaObjects!!!");
		  return this.objectID = null;
		}
		else if((org.apache.commons.lang3.StringUtils.countMatches(gherkinSectionID,".") > 1))
		{
			System.err.println("ERROR: Section Name " + "\"" + gherkinSectionID + "\"" + " is an invalid input!!!\n");
			System.err.println("The correct format is <Section X|.| SubSection Y>, for exmaple: ISA Markigs for Inidicator.Policies");
			return this.objectID = null;
		}
		else
         return  mapTable.get(this.objectID);
	}
	
	public String getNextSectionPageID(String gherkinSectionID)
	{  
		return gherkinSectionID.toLowerCase().replace(getObjectID(gherkinSectionID), "x");
	}
	
	public String getCurrentSectionPageID(String gherkinSectionID)
	{  	
		return gherkinSectionID.toLowerCase().split("\\.")[0].replace(getObjectID(gherkinSectionID), "x");
	}
			
	public String getElementID(String gherkinSectionID)
	{  
		String returnedElement = gherkinSectionID.toLowerCase().replace(getObjectID(gherkinSectionID), "x").trim();
		if(gherkinSectionID.toLowerCase().contains("."))
			returnedElement = gherkinSectionID.split("\\.")[1].trim();
		return returnedElement;
	}

}