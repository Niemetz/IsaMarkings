package auto.pages;

public class IsaMarkingsForX extends AmazonBasePageObject {
	public IsaMarkingsForX()
	{
		mapTable.clear();
		//System.out.println("I am in the class => IsaMarkingsForX");
		mapTable.put("field A".toLowerCase(), "//ISA Makings for &objectID&  field section/field A");
		mapTable.put("field B".toLowerCase(), "//ISA Makings for &objectID& field section/field B");
		mapTable.put("field C".toLowerCase(), "//ISA Makings for &objectID& field section/field C");
		mapTable.put("policies".toLowerCase(), "//ISA Makings for &objectID& field section/policies link");
		mapTable.put("control set".toLowerCase(), "//ISA Makings for &objectID& field section/control set link");
		mapTable.put("confidence".toLowerCase(), "//ISA Makings for &objectID& field section/Confidence link");
		mapTable.put("responsible entity".toLowerCase(), "//ISA Makings for &objectID& field section/responsible entity link");
		mapTable.put("Page Unique Element".toLowerCase(), "//ISA Makings for &objectID& field section/Page Unique Element");
	}
}
