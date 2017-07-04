package auto.pages;

public class IsaMarkingsForXField extends AmazonBasePageObject {
	public IsaMarkingsForXField()
	{
		mapTable.clear();
		//System.out.println("I am in the class => IsaMarkingsForXField");
		mapTable.put("field A".toLowerCase(), "//ISA/Makings/For/&objectID&/Field/field A");
		mapTable.put("field B".toLowerCase(), "//ISA/Makings/For/&objectID&/Field/field B");
		mapTable.put("field C".toLowerCase(), "//ISA/Makings/For/&objectID&/Field/field C");
		mapTable.put("policies".toLowerCase(), "//ISA/Makings/For/&objectID&/policies link");
		mapTable.put("control set".toLowerCase(), "//ISA/Makings/For/&objectID&/control set link");
		mapTable.put("confidence".toLowerCase(), "//ISA/Makings/For/&objectID&/Confidence link");
		mapTable.put("responsible entity".toLowerCase(), "//ISA/Makings/For/&objectID&/responsible entity link");
		mapTable.put("Page Unique Element".toLowerCase(), "//ISA/Makings/For/&objectID&/policies link");
	}
}
