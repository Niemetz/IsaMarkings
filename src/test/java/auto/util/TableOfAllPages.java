package auto.util;

import net.thucydides.core.steps.ScenarioSteps;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("serial")
public class TableOfAllPages extends ScenarioSteps {
	
	// This table contains all application pages
	private static final Map<String, String> appPages = new HashMap<>();
	
	public TableOfAllPages() {
		appPages.put("home", "auto.pages.HomePage");
		appPages.put("login", "auto.pages.LoginPage");
		appPages.put("account main", "auto.pages.AccountMainPage");
		appPages.put("your account", "auto.pages.YourAccountPage");
		appPages.put("isa markings for x field", "auto.pages.IsaMarkingsForXField");
		appPages.put("isa markings for x", "auto.pages.IsaMarkingsForX");
		appPages.put("control set for x field", "auto.pages.ControlSetForXField");
		appPages.put("control set for x", "auto.pages.ControlSetForX");
		appPages.put("affiliation", "auto.pages.Affiliation");
	}

	@SuppressWarnings("rawtypes")
	public Class getClass(String pageName) throws ClassNotFoundException {
		return  Class.forName(appPages.get(pageName));
	}
	

}
