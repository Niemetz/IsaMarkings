package auto.pages;

public class ControlSetForX extends AmazonBasePageObject {
	public ControlSetForX()
	{
		mapTable.clear();
		System.out.println("I am in the ControlSetForX");
		mapTable.put("Sign in".toLowerCase(), "CONTROLSETFORX#signInSubmit&objectID&");
		mapTable.put("Email".toLowerCase(), "CONTROLSETFORX#ap_email&objectID&");
		mapTable.put("Password".toLowerCase(), "CONTROLSETFORX#ap_password&objectID&");
		mapTable.put("Page Unique Element".toLowerCase(), "CONTROLSETFORX#signInSubmit&objectID&");
	}
}
