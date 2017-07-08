package auto.pages;

public class ControlSetForXField extends AmazonBasePageObject {
	public ControlSetForXField()
	{
		mapTable.clear();
		//System.out.println("I am in the class => ControlSetForXField");
		mapTable.put("Sign in".toLowerCase(), "//ISA Markings for &objectID& Field/-#signInSubmit");
		mapTable.put("Email".toLowerCase(), "///ISA Markings for &objectID& Field/-#ap_email");
		mapTable.put("Password".toLowerCase(), "//ISA Markings for &objectID& Field/-#ap_password");
		mapTable.put("Page Unique Element".toLowerCase(), "//ISA Markings for &objectID& Field/Control set section/Page Unique Element");
	}
}
