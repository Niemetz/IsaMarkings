package auto.pages;

public class NewIndicatorPage extends AmazonBasePageObject {
	public NewIndicatorPage()
	{
		mapTable.clear();
		System.out.println("I am in the class => NewIndicatorPage");
		mapTable.put("Sign in".toLowerCase(), "NewIndicatorPage - #signInSubmit");
		mapTable.put("Email".toLowerCase(), "NewIndicatorPage - #ap_email");
		mapTable.put("Password".toLowerCase(), "NewIndicatorPage - #ap_password");
		mapTable.put("Page Unique Element".toLowerCase(), "NewIndicatorPage - #signInSubmit");
	}
}
