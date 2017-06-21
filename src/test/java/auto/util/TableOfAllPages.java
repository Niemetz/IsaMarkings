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
		appPages.put("home", "auto.pages.HomePage");
		
		// Indicator
		appPages.put("new indicator", "auto.pages.NewIndicatorPage");
		appPages.put("indicator.main", "auto.pages.IndicatorMain");
		appPages.put("indicator profile", "auto.pages.IndicatorProfilePage");
		
		// Package
		appPages.put("new package", "auto.pages.NewPackagePage");
		appPages.put("package.main", "auto.pages.PackageMain");
		
        // ISA MArkings common templates 
		appPages.put("isa markings for x field", "auto.pages.IsaMarkingsForXField");
		appPages.put("isa markings for x", "auto.pages.IsaMarkingsForX");
		appPages.put("policies for x", "auto.pages.PoliciesForX");
		appPages.put("policies for x field", "auto.pages.PoliciesForXField");
		appPages.put("further sharing for x field", "auto.pages.FurtherSharingForXField");
		appPages.put("further sharing for x", "auto.pages.FurtherSharingForX");
		appPages.put("control set for x field", "auto.pages.ControlSetForXField");
		appPages.put("control set for x", "auto.pages.ControlSetForX");

	}

	@SuppressWarnings("rawtypes")
	public Class getClass(String pageName) throws ClassNotFoundException {

		if(!appPages.containsKey(pageName.toLowerCase()))
		{
			System.out.println("ERROR!!!! The page you are lookng for is NOT registered in the table of all pages....");
			//System.err.println("ERROR!!!! The page you are lookng for is NOT in the table of all pages....");
			return null;
		}
		else
		   return  Class.forName(appPages.get(pageName.toLowerCase()));
		

	}
}
