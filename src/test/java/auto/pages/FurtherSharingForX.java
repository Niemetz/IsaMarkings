package auto.pages;

public class FurtherSharingForX extends AmazonBasePageObject {
	public FurtherSharingForX()
	{
		mapTable.clear();
		System.out.println("I am in the class => FurtherSharingForX");
		mapTable.put("Sign in".toLowerCase(), "//Further/Sharing/ForX/&objectID&-#signInSubmit");
		mapTable.put("Email".toLowerCase(), "///Further/Sharing/ForX/&objectID&-#ap_email");
		mapTable.put("Password".toLowerCase(), "///Further/Sharing/ForX/&objectID&-#ap_password");
		mapTable.put("Page Unique Element".toLowerCase(), "//Further/Sharing/ForX/&objectID&-#signInSubmit");
	}
}
