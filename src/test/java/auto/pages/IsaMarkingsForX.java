package auto.pages;

public class IsaMarkingsForX extends AmazonBasePageObject {
	public IsaMarkingsForX()
	{
		mapTable.clear();
		//System.out.println("I am in the class => IsaMarkingsForX");
		mapTable.put("field A".toLowerCase(), "//ISA/Makings/For Object X/&objectID&/ field A");
		mapTable.put("field B".toLowerCase(), "//ISA/Makings/For Object X/&objectID&/ field B");
		mapTable.put("field C".toLowerCase(), "//ISA/Makings/For Object X/&objectID&/ field C");
		mapTable.put("policies".toLowerCase(), "//ISA/Makings/For Object X/&objectID&/policies link");
		mapTable.put("control set".toLowerCase(), "//ISA/Makings/For Object X/&objectID&/control set link");
		mapTable.put("further sharing".toLowerCase(), "///ISA/Makings/For Object X/&objectID&/further sharing link");
		mapTable.put("responsible entity".toLowerCase(), "//ISA/Makings/For Object X/&objectID&/responsible entity link");
		mapTable.put("Page Unique Element".toLowerCase(), "//ISA/Makings/For Object X/&objectID&/Section");
	}
}
