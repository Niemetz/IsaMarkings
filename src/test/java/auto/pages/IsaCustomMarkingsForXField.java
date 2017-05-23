package auto.pages;

public class IsaCustomMarkingsForXField extends AmazonBasePageObject {
	public IsaCustomMarkingsForXField()
	{
		mapTable.clear();
		System.out.println("I am in the IsaCustomMarkingsForXField");
		mapTable.put("Sign in".toLowerCase(), "#FIELDsignInSubmit&objectID&");
		mapTable.put("Email".toLowerCase(), "#FIELDsignInSubmitap_email&objectID&");
		mapTable.put("Password".toLowerCase(), "FIELDsignInSubmit#ap_password&objectID&");
		mapTable.put("Page Unique Element".toLowerCase(), "FIELDsignInSubmit#signInSubmit&objectID&");
	}
}
