package auto.pages;

public class SubSectionX extends AmazonBasePageObject {
	public SubSectionX()
	{
		mapTable.clear();
		mapTable.put("field x".toLowerCase(), "//subsectionX/subsectionX/Field_X");
		mapTable.put("field y".toLowerCase(), "//subsectionX/subsectionX/Field_Y");
		mapTable.put("field x".toLowerCase(), "//subsectionX/subsectionX/Field_Z");
		mapTable.put("Page Unique Element".toLowerCase(), "//subsectionX/Page Unique Element");
	}
}
