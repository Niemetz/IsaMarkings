package auto.util;

import java.util.HashMap;
import java.util.Map;

public class TableofIsaObjects_BASELINE {
	public Map<String, String> mapTable = new HashMap<>();
	String objectKey  = null;
	boolean returnValue ;
	public TableofIsaObjects_BASELINE()
	{
		// Object level
		// The properties are in this order:
		// sectionPageID | objectID
		
		// Indicator Object
		mapTable.put("isa markings for indicator".toLowerCase(), "isa markings for x|indicator");
		mapTable.put("isa markings for indicator.policies".toLowerCase(), "isa markings for x.policies|indicator");
		mapTable.put("isa markings for indicator.control set".toLowerCase(), "isa markings for x.control set|indicator");
		
		// Package Object
		mapTable.put("isa markings for package".toLowerCase(), "isa markings for x|package");
		mapTable.put("isa markings for package.policies".toLowerCase(), "isa markings for x.package|package");
		mapTable.put("isa markings for package.control set".toLowerCase(), "isa markings for x.control set|package");
		
		// Title field
		mapTable.put("isa markings for title field".toLowerCase(), "isa markings for x field|title");
		mapTable.put("isa markings for title field.policies".toLowerCase(), "isa markings for x field.policies|title");
		mapTable.put("isa markings for title field.control set".toLowerCase(), "isa markings for x field.control set|title");
		
		// Description field
		mapTable.put("isa markings for description field".toLowerCase(), "isa markings for x field|description");
		mapTable.put("isa markings for description field.policies".toLowerCase(), "isa markings for x field.policies|description");
		mapTable.put("isa markings for description field.control set".toLowerCase(), "isa markings for x field.control set|description");

	}
	
	public boolean isSectionInTheTable(String gherkinSectionID)
	{
		if(!(returnValue = mapTable.containsKey(gherkinSectionID.trim().toLowerCase()) ? true : false))
		  System.err.println("ERROR: Section " + "\"" + gherkinSectionID + "\"" + " NOT FOUND in the TableOfIsaObjects!!!");
		return returnValue;
	}
	
	
	public String getSectionID(String gherkinSectionID)
	{  
		return gherkinSectionID.split("\\.")[0];
	}
	
	public String getSectionPageID(String gherkinSectionID)
	{  
		if (gherkinSectionID.contains("."))
		   return mapTable.get(gherkinSectionID.toLowerCase()).split("\\|")[0].trim();
		else
			return mapTable.get(gherkinSectionID.toLowerCase()).split("\\|")[0].trim().split("\\.")[0];
	}
	
	public String getObjectID(String gherkinSectionID)
	{  
		return mapTable.get(gherkinSectionID.toLowerCase()).split("\\|")[1].trim();
	}
	
	public String getElementID(String gherkinSectionID)
	{  
		String[] tempArray = gherkinSectionID.split("\\.");
		
		return tempArray[tempArray.length-1].toLowerCase();
	}
	
	
}