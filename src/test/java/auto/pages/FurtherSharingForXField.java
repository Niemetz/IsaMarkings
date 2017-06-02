package auto.pages;

public class FurtherSharingForXField extends AmazonBasePageObject {
	public FurtherSharingForXField()
	{
		mapTable.clear();
		System.out.println("I am in the class => FurtherSharingForXField");
		mapTable.put("Sign in".toLowerCase(), "//Further/Sharing/ForXField/&objectID&-#signInSubmit");
		mapTable.put("Email".toLowerCase(), "//Further/Sharing/ForXField/&objectID&-#ap_email");
		mapTable.put("Password".toLowerCase(), "//Further/Sharing/ForXField/&objectID&-#ap_password");
		mapTable.put("Page Unique Element".toLowerCase(), "//Further/Sharing/ForXField/&objectID&-#signInSubmit");
	}
}
