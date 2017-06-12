package auto.pages;

public class FurtherSharingForXField extends AmazonBasePageObject {
	public FurtherSharingForXField()
	{
		mapTable.clear();
		System.out.println("I am in the class => FurtherSharingForXField");
		mapTable.put("Sign in".toLowerCase(), "//ISA Marking/ForField/&objectID&/Further Sharing/-#signInSubmit");
		mapTable.put("Email".toLowerCase(), "//ISA Marking/ForField/&objectID&/Further Sharing/-#ap_email");
		mapTable.put("Password".toLowerCase(), "//ISA Marking/ForField/&objectID&/Further Sharing/-#ap_password");
		mapTable.put("Page Unique Element".toLowerCase(), "//ISA Marking/For Field/&objectID&/Further Sharing/Page Unique Element");
	}
}
