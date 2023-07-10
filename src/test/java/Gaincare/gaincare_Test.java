package Gaincare;

import java.io.IOException;
import java.text.ParseException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class gaincare_Test extends Baseclass {

	WebElementRepo ele;
	LoginPage login;


	@BeforeMethod
	public void LaunchDriver() throws IOException, InterruptedException {

		Launchdriver();
		ele = new WebElementRepo(driver);
		login = new LoginPage(driver);


	}

	@AfterMethod
	public void Endbrowser() throws IOException, InterruptedException {

     // driver.quit();
	}



	@Test
	//(enabled = true, priority = 0)

	public void loginpage() throws InterruptedException, IOException, ParseException {
		//
		login.GiveIndiaLoginPage("jeyadmin@gmail.com", "Abcd1234");
	
	}

//	//@Test(enabled = false, priority = 1)
//
//	public void loginpage2() throws InterruptedException, IOException, ParseException {
//		//
//		login.GiveIndiaLoginPage("navya@giveindia.org", "test1234");
//
//
//	}

}
