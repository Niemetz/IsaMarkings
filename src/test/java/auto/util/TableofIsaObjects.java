package auto.util;

import java.util.HashMap;
import java.util.Map;

public class TableofIsaObjects {
	
	private static final Map<String, String> mapTable = new HashMap<>();
	public TableofIsaObjects()
	{
		// Page level
		mapTable.put("indicator".toLowerCase(), "indicator");
		mapTable.put("package".toLowerCase(), "package_YYY");
		// field level
		mapTable.put("title".toLowerCase(), "title");
		mapTable.put("short notification".toLowerCase(), "short_notification");
	}
	
	public String getActualObjectID(String tempOjectID)
	{
		return mapTable.get(tempOjectID.toLowerCase());
	}
}