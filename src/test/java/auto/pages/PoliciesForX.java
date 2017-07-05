package auto.pages;

public class PoliciesForX extends AmazonBasePageObject {
	public PoliciesForX()
	{
		mapTable.clear();
		//System.out.println("I am in the class => PoliciesForX");
		mapTable.put("Sign in".toLowerCase(), "/ISA Marking for \"&objectID&\"/Policies section/signInSubmit");
		mapTable.put("Email".toLowerCase(), "/ISA Marking for \"&objectID&\"/Policies section/section/ap_email");
		mapTable.put("Password".toLowerCase(), "//ISA Marking for \"&objectID&\"/Policies section/ap_password");
		mapTable.put("Page Unique Element".toLowerCase(), "//ISA Marking for \"&objectID&\"/Policies section/Page Unique Element");
	}
}
