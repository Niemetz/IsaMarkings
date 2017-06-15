package auto.pages;

public class NewIndicatorPage extends AmazonBasePageObject {
	public NewIndicatorPage()
	{
		mapTable.clear();
		mapTable.put("title".toLowerCase(), "//custom isa markings/button/for/TITLE/field");
		mapTable.put("description".toLowerCase(), "//custom isa markings/button/for/DESCRIPTION/field");
		mapTable.put("indicator type".toLowerCase(), "//custom isa markings/button/for/INDICATOR TYPE/field");
		mapTable.put("Page Unique Element".toLowerCase(), "//Page Unique Element/on/New Indicator/Page");
	}
}
