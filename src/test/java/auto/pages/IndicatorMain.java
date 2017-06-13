package auto.pages;

public class IndicatorMain extends AmazonBasePageObject {
	public IndicatorMain()
	{
		mapTable.clear();
		mapTable.put("Title".toLowerCase(), "//indicator/main/Title");
		mapTable.put("description".toLowerCase(), "//indicator/main/description");
		mapTable.put("indicator type".toLowerCase(), "///indicator/main/indicator type");
		mapTable.put("Page Unique Element".toLowerCase(), "//Page Unique Element/on/Indicator.Main/Page");
	}
}
