package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	
	WebDriver driver;
	@Test
	public void UserSValidation() {
		
		driver = BrowserFactory.init();
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		  
		     loginpage.addList();
             loginpage.validateAllCheckBoxAreChecked();
             loginpage.validateSingleListItemIsRemoved();
             loginpage.validateAllListItemAreRemoved();
          
		
		BrowserFactory.tearDown();
		
	}


}
