package Gaincare;

import org.openqa.selenium.WebDriver;




public class LoginPage extends Baseclass{

	WebElementRepo ele;


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		ele = new WebElementRepo(driver);




	}

	public void GiveIndiaLoginPage(String Username, String Password) throws InterruptedException {

		setText(ele.getEnterEmailId(),Username );
		setText(ele.getEnterPassword(),Password );
		clickbttn(ele.getSubmitLogin());
	}




}
