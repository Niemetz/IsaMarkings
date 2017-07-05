package auto.pages;

public class NewIndicatorPage extends AmazonBasePageObject {
	public NewIndicatorPage()
	{
		mapTable.clear();
		mapTable.put("title".toLowerCase(), "/Indicator Page/Title field");
		mapTable.put("custom isa markings button by the title field".toLowerCase(), "/Indicator Page/isa marking button by the title field");
		
		mapTable.put("description".toLowerCase(), "//indicator/main//Description//field");
		mapTable.put("custom isa markings button by the description field".toLowerCase(), "/Indicator Page/isa marking button by the description field");

		mapTable.put("indicator type".toLowerCase(), "//indicator/main/Indicator Type/field|dynamic");
		mapTable.put("custom isa markings button by the indicator type field".toLowerCase(), "//Indicator Page/isa marking button by the indicator type field");

		// This is a section link that is NOT part of "ISA Markings" section links
		mapTable.put("Responsible Entity".toLowerCase(), "/Indicator Page//Responsible Entity link");
		
		mapTable.put("ISA Markings for Indicator".toLowerCase(), "//Indicator Page/ISA Markings for Indicator section link");
		
		mapTable.put("Page Unique Element".toLowerCase(), "//Indicator Page/Page Unique Element/");
	}
}
