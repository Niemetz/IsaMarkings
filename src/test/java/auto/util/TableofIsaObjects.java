package auto.util;

import java.util.HashMap;
import java.util.Map;


public class TableofIsaObjects {
	public Map<String, String> mapTable = new HashMap<>();

	String objectID  = null;
	
	public TableofIsaObjects()
	{
		// Objects
		mapTable.put("indicator".toLowerCase(), "indicator".toLowerCase());
		mapTable.put("package".toLowerCase(), "package".toLowerCase());
		
		// fields
		mapTable.put("title".toLowerCase(), "title".toLowerCase());
		mapTable.put("description".toLowerCase(), "description".toLowerCase());
		mapTable.put("indicator type".toLowerCase(), "indicator_type".toLowerCase());
	}

	public String getObjectID(String gherkinSectionID)
	{  
		// Exmaple: ISA Marking for Indicator
		if(!gherkinSectionID.contains("field")  && !gherkinSectionID.contains("."))
			this.objectID = (gherkinSectionID.split("for")[1].trim()).toLowerCase();
		// Exmaple: ISA Markings for Indicator.Policies
		else if (!gherkinSectionID.contains("field") && gherkinSectionID.contains("."))
			this.objectID = (gherkinSectionID.split("\\.")[0].trim().split("for")[1].trim()).toLowerCase();	
		// Exmaple:  ISA Markings for Description field
		else if (gherkinSectionID.contains("field")  && !gherkinSectionID.contains("."))
			this.objectID = (gherkinSectionID.split("for")[1].split("field")[0].trim()).toLowerCase();	
		// Exmaple:  ISA Markings for Description field.Policies
		else if (gherkinSectionID.contains("field") && gherkinSectionID.contains("."))
			this.objectID  = (gherkinSectionID.split("\\.")[0].trim().split("for")[1].trim().split("field")[0].trim()).toLowerCase();

		if(!(mapTable.containsKey(this.objectID)))
		{
		  System.err.println("ERROR: Section " + "\"" + gherkinSectionID + "\"" + " NOT FOUND in the TableOfIsaObjects!!!");
		  return this.objectID = null;
		}
		else if((org.apache.commons.lang3.StringUtils.countMatches(gherkinSectionID,".") > 1))
		{
			System.err.println("ERROR: Section Name " + "\"" + gherkinSectionID + "\"" + " is an invalid section!!!\n");
			return this.objectID = null;
		}
		else
         return  this.objectID;
	}
	
	public String getSectionID(String gherkinSectionID)
	{  
		return gherkinSectionID;
	}
	
	public String getSectionPageID(String gherkinSectionID)
	{  
		String returnSectionPageID = null;
		
		if(!gherkinSectionID.contains("field") && !gherkinSectionID.contains("."))
			returnSectionPageID =  "isa markings for x";
		else if (!gherkinSectionID.contains("field") && gherkinSectionID.contains("."))
			returnSectionPageID =  "isa markings for x." + gherkinSectionID.split("\\.")[1].trim().toLowerCase();
		else if (gherkinSectionID.contains("field") && !gherkinSectionID.contains("."))
			returnSectionPageID =  "isa markings for x field";
		else if (gherkinSectionID.contains("field") && gherkinSectionID.contains("."))
			returnSectionPageID =  "isa markings for x field." + gherkinSectionID.split("\\.")[1].trim().toLowerCase();
			
		return returnSectionPageID;
	}
		
	public String getElementID(String gherkinSectionID)
	{  
		String[] tempArray = gherkinSectionID.split("\\.");
		
		return tempArray[tempArray.length-1].toLowerCase();
	}
	
	
}