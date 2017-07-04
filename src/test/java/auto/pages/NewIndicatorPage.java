package auto.pages;

public class NewIndicatorPage extends AmazonBasePageObject {
	public NewIndicatorPage()
	{
		mapTable.clear();
		mapTable.put("title".toLowerCase(), "//indicator/main//Title/field");
		mapTable.put("custom isa markings button by the title field".toLowerCase(), "//indicator/main/isa marking button/by the/title field");
		
		mapTable.put("description".toLowerCase(), "//indicator/main//Description//field");
		mapTable.put("custom isa markings button by the description field".toLowerCase(), "//indicator/main/isa marking button/by the/description field");

		mapTable.put("indicator type".toLowerCase(), "//indicator/main/Indicator Type/field|dynamic");
		mapTable.put("custom isa markings button by the indicator type field".toLowerCase(), "//indicator/main/isa marking button/by the/indicator type field");

		// This is a section link that is NOT part of "ISA Markings" section links
		mapTable.put("Responsible Entity".toLowerCase(), "//indicator/main/Responsible Entity link");
		
		mapTable.put("ISA Markings for Indicator".toLowerCase(), "//indicator Main Page/ISA Markings for Indicator/Section Link");
		
		mapTable.put("Page Unique Element".toLowerCase(), "//Page Unique Element/on/New Indicator/Page");
	}
}
