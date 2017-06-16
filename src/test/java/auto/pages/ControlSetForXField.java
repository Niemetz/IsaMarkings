package auto.pages;

public class ControlSetForXField extends AmazonBasePageObject {
	public ControlSetForXField()
	{
		mapTable.clear();
		//System.out.println("I am in the class => ControlSetForXField");
		mapTable.put("Sign in".toLowerCase(), "//Control/Set/For/&objectID&/Field-#signInSubmit");
		mapTable.put("Email".toLowerCase(), "//Control/Set/For/&objectID&/Field-#ap_email");
		mapTable.put("Password".toLowerCase(), "//Control/Set/For/&objectID&/Field-#ap_password");
		mapTable.put("Page Unique Element".toLowerCase(), "//Control/Set/For/&objectID&/Field-#signInSubmit");
	}
}
