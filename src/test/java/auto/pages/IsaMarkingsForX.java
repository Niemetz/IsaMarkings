package auto.pages;

public class IsaMarkingsForX extends AmazonBasePageObject {
	public IsaMarkingsForX()
	{
		mapTable.clear();
		System.out.println("I am in the class => IsaMarkingsForX");
		mapTable.put("Sign in".toLowerCase(), "//ISA/Makings/For/&objectID&/-signInSubmit");
		mapTable.put("Email".toLowerCase(), "//ISA/Makings/For/&objectID&/-#ap_email");
		mapTable.put("Password".toLowerCase(), "//ISA/Makings/For/&objectID&/-#ap_password");
		mapTable.put("Page Unique Element".toLowerCase(), "//ISA/Makings/For/&objectID&/-signInSubmit");
	}
}
