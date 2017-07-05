package auto.pages;

public class IsaMarkingsForXField extends AmazonBasePageObject {
	public IsaMarkingsForXField()
	{
		mapTable.clear();
		//System.out.println("I am in the class => IsaMarkingsForXField");
		mapTable.put("field A".toLowerCase(), "//ISA Makings for \"&objectID&\" field/field A");
		mapTable.put("field B".toLowerCase(), "//ISA Makings for \"&objectID&\" field/field B");
		mapTable.put("field C".toLowerCase(), "//ISA Makings for \"&objectID&\" field/field C");
		mapTable.put("policies".toLowerCase(), "//ISA Makings for \"&objectID&\" field/policies link");
		mapTable.put("control set".toLowerCase(), "///ISA Makings for \"&objectID&\" field/control set link");
		mapTable.put("confidence".toLowerCase(), "//ISA Makings for \"&objectID&\" field/Confidence link");
		mapTable.put("responsible entity".toLowerCase(), "//ISA Makings for \"&objectID&\" field/responsible entity link");
		mapTable.put("Page Unique Element".toLowerCase(), "//ISA Makings for \"&objectID&\" field/Page Unique Element");
	}
}
