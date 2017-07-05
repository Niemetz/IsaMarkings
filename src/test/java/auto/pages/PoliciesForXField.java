package auto.pages;

public class PoliciesForXField extends AmazonBasePageObject {
	public PoliciesForXField()
	{
		mapTable.clear();
		//System.out.println("I am in the class => PoliciesForXField");
		mapTable.put("Sign in".toLowerCase(), "//ISA Markings for &objectID& field/Policies section/signInSubmit");
		mapTable.put("Email".toLowerCase(), "//ISA Markings for &objectID& field/Policies section/ap_email");
		mapTable.put("Password".toLowerCase(), "//ISA Markings for &objectID& field/Policies section/ap_password");
		mapTable.put("Page Unique Element".toLowerCase(), "//ISA Markings for &objectID& field/Policies section/Page Unique Element");
	}
}
