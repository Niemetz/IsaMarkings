package auto.util;

import java.util.HashMap;
import java.util.Map;

public class TableofIsaObjects {
	public Map<String, String> mapTable = new HashMap<>();
	String objectKey  = null;
	public TableofIsaObjects()
	{
		// Object level
		mapTable.put("indicator".toLowerCase(), "indicator|object");
		mapTable.put("package".toLowerCase(), "package|object");
		
		// field level
		mapTable.put("title".toLowerCase(), "title|field");
		mapTable.put("description".toLowerCase(), "description|field");
		mapTable.put("indicator type".toLowerCase(), "indicator_type|field");
		mapTable.put("address observable".toLowerCase(), "address|field");
		mapTable.put("further sharing".toLowerCase(), "further_sharing|field");
	}
	public String getObjectID(String tempOjectID)
	{  
		objectKey = tempOjectID.trim().toLowerCase();
		return mapTable.get(objectKey).split("\\|")[0].trim();
	}
	
	public String getObjecType(String tempOjectID)
	{  
		objectKey = tempOjectID.trim().toLowerCase();
		return mapTable.get(objectKey).split("\\|")[1].trim();
	}
}