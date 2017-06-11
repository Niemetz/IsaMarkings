package auto.pages;

public class PoliciesForXField extends AmazonBasePageObject {
	public PoliciesForXField()
	{
		mapTable.clear();
		System.out.println("I am in the class => PoliciesForXField");
		mapTable.put("Sign in".toLowerCase(), "//Policies/ForXField/&objectID&-#signInSubmit");
		mapTable.put("Email".toLowerCase(), "//Policies/ForXField/&objectID&-#ap_email");
		mapTable.put("Password".toLowerCase(), "//Policies/ForXField/&objectID&-#ap_password");
		mapTable.put("Page Unique Element".toLowerCase(), "//Policies/ForXField/&objectID&-#signInSubmit");
	}
}