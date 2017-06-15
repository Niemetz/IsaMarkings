package auto.pages;

public class IndicatorMain extends AmazonBasePageObject {
	public IndicatorMain()
	{
		mapTable.clear();
		mapTable.put("Title".toLowerCase(), "//indicator/main/title field");
		mapTable.put("description".toLowerCase(), "//indicator/main/description field");
		mapTable.put("indicator type".toLowerCase(), "///indicator/main/indicator type field");
		mapTable.put("Page Unique Element".toLowerCase(), "//Page Unique Element/on/Indicator.Main/Page");
	}
}
