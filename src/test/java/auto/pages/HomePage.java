package auto.pages;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.amazon.com") 

public class HomePage extends AmazonBasePageObject 
{
		public HomePage()
		{
			mapTable.clear();
			mapTable.put("Sign in securely".toLowerCase(),"#a-autoid-0-announce>span");
			mapTable.put("Account & Lists".toLowerCase(),".//*[@id='nav-link-accountList']/span[2]");
			mapTable.put("Page Unique Element".toLowerCase(), "#a-autoid-0-announce>span");
		}
}