package auto.pages;

public class ControlSetForX extends AmazonBasePageObject {
	public ControlSetForX()
	{
		mapTable.clear();
		System.out.println("I am in the class => ControlSetForX");
		mapTable.put("Sign in".toLowerCase(), "//Control/Set/For/&objectID&-#signInSubmit");
		mapTable.put("Email".toLowerCase(), "//Control/Set/For/&objectID&-#ap_email");
		mapTable.put("Password".toLowerCase(), "//Control/Set/For/&objectID&-#ap_password");
		mapTable.put("Page Unique Element".toLowerCase(), "//Control/Set/For/&objectID&-#signInSubmit");
	}
}
