package auto.pages;

public class IsaCustomMarkingsForX extends AmazonBasePageObject {
	public IsaCustomMarkingsForX()
	{
		mapTable.clear();
		System.out.println("I am in the IsaCustomMarkingsForX");
		mapTable.put("Sign in".toLowerCase(), "PAGE#signInSubmit&objectID&");
		mapTable.put("Email".toLowerCase(), "PAGE#ap_email&objectID&");
		mapTable.put("Password".toLowerCase(), "PAGE#ap_password&objectID&");
		mapTable.put("Page Unique Element".toLowerCase(), "PAGE#signInSubmit&objectID&");
	}
}
