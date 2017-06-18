package auto.pages;

public class PoliciesForX extends AmazonBasePageObject {
	public PoliciesForX()
	{
		mapTable.clear();
		//System.out.println("I am in the class => PoliciesForX");
		mapTable.put("Sign in".toLowerCase(), "//Policies/ForX/&objectID&/section/signInSubmit");
		mapTable.put("Email".toLowerCase(), "//Policies/ForX/&objectID&/section/ap_email");
		mapTable.put("Password".toLowerCase(), "//Policies/ForX/&objectID&/section/ap_password");
		mapTable.put("Page Unique Element".toLowerCase(), "//Policies/ForX/&objectID&//section/Page Unique Element");
	}
}
