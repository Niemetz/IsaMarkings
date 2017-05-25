package auto.pages;

public class IsaMarkingsForXField extends AmazonBasePageObject {
	public IsaMarkingsForXField()
	{
		mapTable.clear();
		System.out.println("I am in the class => IsakingsForXField");
		mapTable.put("Sign in".toLowerCase(), "ISA Makings For &objectID& Field - signInSubmit");
		mapTable.put("Email".toLowerCase(), "ISA Makings For &objectID& Field - signInSubmitap_email");
		mapTable.put("Password".toLowerCase(), "ISA Makings For &objectID& Field - signInSubmit#ap_password");
		mapTable.put("Page Unique Element".toLowerCase(), "ISA Makings For &objectID& Field - signInSubmit");
	}
}
