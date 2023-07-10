package Gaincare;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebElementRepo extends Baseclass {

	public WebElementRepo(WebDriver ldriver) {

		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email']")
	private WebElement EnterEmailId;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement EnterPassword;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement SubmitLogin;

	public WebElement getEnterEmailId() {
		return EnterEmailId;
	}

	public WebElement getEnterPassword() {
		return EnterPassword;
	}

	public WebElement getSubmitLogin() {
		return SubmitLogin;
	}

}
