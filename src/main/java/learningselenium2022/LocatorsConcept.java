package learningselenium2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		// create a web element
		// WE= By Locator
		// create Web Element +action (Click, sendKeys,isDispalyed...)
		// id is a static method
		driver.findElement(By.id("input-email")).sendKeys("priya@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("23456");

		// 2.
		// return type of find element method is webElement

		WebElement emailId = driver.findElement(By.id("input-email"));
		WebElement password = driver.findElement(By.id("input-password"));

		emailId.sendKeys("priya@gmail.com");
		password.sendKeys("23456");

		// 3.by locators:
		By emailId1 = By.id("input-email");
		By password1 = By.id("input-password");

		WebElement emailID = driver.findElement(emailId1);
		WebElement pwd = driver.findElement(password1);

		emailID.sendKeys("priya@gmail.com");
		pwd.sendKeys("23456");

		// 4. by locator with generic method
		By emailId2 = By.id("input-email");
		By password2 = By.id("input-password");

		getElement(emailId2).sendKeys("priya@gmail.com");
		getElement(password2).sendKeys("23456");

		// 5.by locator with getElement and action generic method

		By emailId3 = By.id("input-email");
		By password3 = By.id("input-password");

		doSendKeys(emailId3, "priya@gmail.com");
		doSendKeys(password3, "23456");

		// 6. by locator with getElement and actions generic method in util class

		By emailId4 = By.id("input-email");
		By password4 = By.id("input-password");

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(emailId4, "priya@gmail.com");
		eleUtil.doSendKeys(password4, "23456");

		// 7. string locator with by, get Element and actions generic method in Util
		// class
		String eId1 = "input-email";
		String pwd1 = "input-password";

		doSendKeys("id", eId1, "priya@gmail.com");
		doSendKeys("id", pwd1, "23456");
		
		//8.
		ElementUtil eleUtil1 = new ElementUtil(driver);
		
	
		eleUtil1.doSendKeys("id", eId1, "priya@gmail.com");
		eleUtil1.doSendKeys("id", pwd1, "23456");
	}

	public static By getBy(String locatorType, String locatorvalue) {
		By locator = null;

		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorvalue);
			break;

		default:
			break;
		}
		return locator;

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public static void doSendKeys(String locatorType, String locatorValue, String value) {
		getElement(getBy(locatorType, locatorValue)).sendKeys(value);

	}
}