package auto.pages;

public class NewIndicatorPage extends AmazonBasePageObject {
	public NewIndicatorPage()
	{
		mapTable.clear();
		mapTable.put("title".toLowerCase(), "//indicator/main//Title/field");
		mapTable.put("custom isa markings button by the title field".toLowerCase(), "//indicator/main/isa marking button/by the/title field");
		
		mapTable.put("description".toLowerCase(), "//indicator/main//Description/f/field");
		mapTable.put("custom isa markings button by the description field".toLowerCase(), "//indicator/main/isa marking button/by the/description field");

		mapTable.put("indicator type".toLowerCase(), "//indicator/main//Indicator Type/ffield");
		mapTable.put("custom isa markings button by the indicator type field".toLowerCase(), "//indicator/main/isa marking button/by the/indicator type field");

		mapTable.put("Page Unique Element".toLowerCase(), "//Page Unique Element/on/New Indicator/Page");
	}
}
