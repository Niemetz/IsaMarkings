package auto.util;

import net.thucydides.core.steps.ScenarioSteps;
import java.util.HashMap;
import java.util.Map;
//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("serial")
public class TableOfAllPages extends ScenarioSteps {
	
	// This table contains all application pages
	private static final Map<String, String> appPages = new HashMap<>();
	
	public TableOfAllPages() {
		
		appPages.put("login", "auto.pages.LoginPage");
		appPages.put("account main", "auto.pages.AccountMainPage");
		appPages.put("your account", "auto.pages.YourAccountPage");
		appPages.put("new indicator", "auto.pages.NewIndicatorPage");
		appPages.put("indicator.main", "auto.pages.IndicatorMain");
		appPages.put("page2", "auto.pages.IndicatorMain");
		appPages.put("home", "auto.pages.HomePage");
		appPages.put("page3", "auto.pages.IndicatorMain");
		appPages.put("page4", "auto.pages.IndicatorMain");
		appPages.put("isa markings for x field", "auto.pages.IsaMarkingsForXField");
		appPages.put("page5", "auto.pages.IndicatorMain");
		appPages.put("page6", "auto.pages.IndicatorMain");
		appPages.put("page7", "auto.pages.IndicatorMain");
		appPages.put("policies for x", "auto.pages.PoliciesForX");
		appPages.put("page8", "auto.pages.IndicatorMain");
		appPages.put("page9", "auto.pages.IndicatorMain");
		appPages.put("further sharing for x field", "auto.pages.FurtherSharingForXField");
		appPages.put("page10", "auto.pages.IndicatorMain");
		appPages.put("page11", "auto.pages.IndicatorMain");
		appPages.put("page12", "auto.pages.IndicatorMain");
		appPages.put("further sharing for x", "auto.pages.FurtherSharingForX");
		appPages.put("page13", "auto.pages.IndicatorMain");
		appPages.put("page14", "auto.pages.IndicatorMain");
		appPages.put("policies for x field", "auto.pages.PoliciesForXField");
		appPages.put("page15", "auto.pages.IndicatorMain");
		appPages.put("page16", "auto.pages.IndicatorMain");
		appPages.put("page17", "auto.pages.IndicatorMain");
		appPages.put("page18", "auto.pages.IndicatorMain");
		appPages.put("page19", "auto.pages.IndicatorMain");
		appPages.put("control set for x field", "auto.pages.ControlSetForXField");
		appPages.put("page20", "auto.pages.IndicatorMain");
		appPages.put("page21", "auto.pages.IndicatorMain");
		appPages.put("page22", "auto.pages.IndicatorMain");
		appPages.put("control set for x", "auto.pages.ControlSetForX");
		appPages.put("page23", "auto.pages.IndicatorMain");
		appPages.put("page24", "auto.pages.IndicatorMain");
		appPages.put("page25", "auto.pages.IndicatorMain");
		appPages.put("isa markings for x", "auto.pages.IsaMarkingsForX");
	}

	@SuppressWarnings("rawtypes")
	public Class getClass(String pageName) throws ClassNotFoundException {
		return  Class.forName(appPages.get(pageName));
	}
}
