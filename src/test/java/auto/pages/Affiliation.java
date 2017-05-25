package auto.pages;

public class Affiliation extends AmazonBasePageObject {
	public Affiliation()
	{
		mapTable.clear();
		System.out.println("I am in the class => Affiliation");
		mapTable.put("Sign in".toLowerCase(), "Affiliation - #signInSubmit");
		mapTable.put("Email".toLowerCase(), "Affiliation - #ap_email");
		mapTable.put("Password".toLowerCase(), "Affiliation - #ap_password");
		mapTable.put("Page Unique Element".toLowerCase(), "Affiliation - #signInSubmit");
	}
}
