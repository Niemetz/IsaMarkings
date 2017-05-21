package auto.pages;

public class CustomMarkingsPage extends AmazonBasePageObject {
	public CustomMarkingsPage()
	{
		mapTable.clear();
		mapTable.put("Sign in".toLowerCase(), "#signInSubmit&objectID&");
		mapTable.put("Email".toLowerCase(), "#ap_email&objectID&");
		mapTable.put("Password".toLowerCase(), "#ap_password&objectID&");
		mapTable.put("Page Unique Element".toLowerCase(), "#signInSubmit&objectID&");
	}
}
