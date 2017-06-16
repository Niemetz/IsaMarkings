package auto.pages;

public class NewIndicatorPage extends AmazonBasePageObject {
	public NewIndicatorPage()
	{
		mapTable.clear();
		mapTable.put("title".toLowerCase(), "//custom isa markings/button/for/TITLE/field");
		mapTable.put("custom isa markings button by the title field".toLowerCase(), "//indicator/main/isa marking button/by the/title field");
		
		mapTable.put("description".toLowerCase(), "//custom isa markings/button/for/DESCRIPTION/field");
		mapTable.put("custom isa markings button by the description field".toLowerCase(), "//indicator/main/isa marking button/by the/description field");

		mapTable.put("indicator type".toLowerCase(), "//custom isa markings/button/for/INDICATOR TYPE/field");
		mapTable.put("custom isa markings button by the indicator type field".toLowerCase(), "//indicator/main/isa marking button/by the/indicator type field");

		mapTable.put("Page Unique Element".toLowerCase(), "//Page Unique Element/on/New Indicator/Page");
	}
}
