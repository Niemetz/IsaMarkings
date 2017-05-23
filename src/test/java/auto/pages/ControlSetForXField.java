package auto.pages;

public class ControlSetForXField extends AmazonBasePageObject {
	public ControlSetForXField()
	{
		mapTable.clear();
		System.out.println("I am in the ControlSetForXField");
		mapTable.put("Sign in".toLowerCase(), "CONTROLSETFORXFIELD#signInSubmit&objectID&");
		mapTable.put("Email".toLowerCase(), "CONTROLSETFORXFIELD#ap_email&objectID&");
		mapTable.put("Password".toLowerCase(), "CONTROLSETFORXFIELD#ap_password&objectID&");
		mapTable.put("Page Unique Element".toLowerCase(), "CONTROLSETFORXFIELD#signInSubmit&objectID&");
	}
}
