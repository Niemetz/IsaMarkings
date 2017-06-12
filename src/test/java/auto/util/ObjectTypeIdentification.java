package auto.util;

import java.util.HashMap;
import java.util.Map;

public class ObjectTypeIdentification {
	private static final Map<String, String> mapTable = new HashMap<>();
	public ObjectTypeIdentification()
	{
		//Object section
		mapTable.put("indicator".toLowerCase(), "object");
		
		// field section
		mapTable.put("control set".toLowerCase(), "field");
		mapTable.put("policies".toLowerCase(), "field");
		mapTable.put("further sharing".toLowerCase(), "field");
		mapTable.put("title".toLowerCase(), "field");
	}
	public String objectTypeIs(String objectType)
	{
		return mapTable.get(objectType.toLowerCase());
	}
}