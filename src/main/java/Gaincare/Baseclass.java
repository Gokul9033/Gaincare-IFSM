package Gaincare;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass {

	public WebDriver driver;
	WebDriverWait wait;
	public static Properties prop;
	public static String ProjectPath = System.getProperty("user.dir");

	public WebDriver Launchdriver() throws IOException {
		prop = new Properties();
		System.out.println(ProjectPath + "/inputfile/config.properties");
		FileInputStream ip = new FileInputStream(ProjectPath + "/inputfile/config.properties");
		prop.load(ip);
		String browser = "chrome";

		try {

			if (browser.equals("chrome")) {

				System.setProperty("webdriver.chrome.driver", ProjectPath + "/inputfile/chromedriver.exe");
				driver = new ChromeDriver(); driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.get(prop.getProperty("URL"));
				System.out.println(" URL: " + prop.getProperty("URL"));
				Thread.sleep(5000);
			}

		} catch (Exception e) {

			System.out.println("Driver launching failed due to below exception : " + e.getMessage());
		}
		return driver;
	}
	public void setText(WebElement element, String name) {
		try {
			if (name != null && ElementFound(element)) {
				element.clear();
				element.sendKeys(name.trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to enter text : " + e.getMessage());
		}
	}

	public void windowHandling() {
		/*
		 * if (ElementFound(element)) { element.click();
		 */
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			//}


		}

	}
	public void Actionclass(WebElement element) throws InterruptedException {
		try {
			if (ElementFound(element)) {

				Actions action = new Actions(driver);
				action.moveToElement(element).build().perform();

				element.click();
			}
		}

		catch (Exception e) {

			e.printStackTrace();
		}}

	public void ActionMovelement(WebElement element) throws InterruptedException {
		try {

				Actions action = new Actions(driver);
				action.moveToElement(element).perform();


		}

		catch (Exception e) {

			e.printStackTrace();
		}}

	public void clickbttn(WebElement element) throws InterruptedException {

		try {
			if (ElementFound(element)) {

				element.click();
				Thread.sleep(2000);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		}


	public void setprop(WebElement element, String name) throws IOException {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(ProjectPath + "/inputfile/config.properties");

		prop.load(ip);

		if (name != null && ElementFound(element)) {
			element.clear();
			element.sendKeys(prop.getProperty(name));

		}

	}


	public boolean ElementFound(WebElement element) {
		boolean b = false;

		try {
			b = element.isDisplayed();
		} catch (NoSuchElementException e) {

		}
		return b;

	}


}
