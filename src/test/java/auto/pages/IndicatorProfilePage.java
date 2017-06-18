package auto.pages;

public class IndicatorProfilePage extends AmazonBasePageObject {
	public IndicatorProfilePage()
	{
		mapTable.clear();
		mapTable.put("title".toLowerCase(), "//indicator/Profile/Title/field");
		mapTable.put("custom isa markings button by the title field".toLowerCase(), "//indicator/Profile/isa marking button/by the/title field");
		
		mapTable.put("description".toLowerCase(), "//indicator/Profile/Description/f/field");
		mapTable.put("custom isa markings button by the description field".toLowerCase(), "///indicator/Profile/isa marking button/by the/description field");

		mapTable.put("indicator type".toLowerCase(), "//indicator/Profile/Indicator Type/combo box");
		mapTable.put("custom isa markings button by the indicator type field".toLowerCase(), "//indicator/Profile/isa marking button/by the/indicator type field");

		// Because all of the sections are dynamic.  There will be no element checking at the page level
		// However, the element checking will be performed at the section level.
		
		// When this section is referred to:
		// 1 - load the page "isa markings for object"
		// 2 - pass the "object type" to this section.
		mapTable.put("isa markings for object".toLowerCase(), "//isa markings for object/section");
		
		
		mapTable.put("Page Unique Element".toLowerCase(), "//indicator/Profile/page unique element");
	}
}
