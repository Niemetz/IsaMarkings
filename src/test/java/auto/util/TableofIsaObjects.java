package auto.util;

import java.util.HashMap;
import java.util.Map;

public class TableofIsaObjects {
	private static final Map<String, String> mapTable = new HashMap<>();
	public TableofIsaObjects()
	{
		mapTable.put("indicator".toLowerCase(), "indicator");
		mapTable.put("control set".toLowerCase(), "control_set");
		mapTable.put("policies".toLowerCase(), "policies");
		mapTable.put("further sharing".toLowerCase(), "further_sharing");
		mapTable.put("title".toLowerCase(), "title");
	}
	public String getActualObjectID(String tempOjectID)
	{
		return mapTable.get(tempOjectID.toLowerCase());
	}
}