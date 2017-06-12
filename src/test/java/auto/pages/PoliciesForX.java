package auto.pages;

public class PoliciesForX extends AmazonBasePageObject {
	public PoliciesForX()
	{
		mapTable.clear();
		System.out.println("I am in the class => PoliciesForX");
		mapTable.put("Sign in".toLowerCase(), "//Policies/ForX/&objectID&-#signInSubmit");
		mapTable.put("Email".toLowerCase(), "//Policies/ForX/&objectID&-#ap_email");
		mapTable.put("Password".toLowerCase(), "//Policies/ForX/&objectID&-#ap_password");
		mapTable.put("Page Unique Element".toLowerCase(), "//Policies/ForX/&objectID&/Page Unique Element");
	}
}
