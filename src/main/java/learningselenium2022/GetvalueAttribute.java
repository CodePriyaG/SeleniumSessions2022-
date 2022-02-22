package learningselenium2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetvalueAttribute {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By emailId = By.id("input-email");
		doSendkeys(emailId, "priya@gmail.com");
		
		String att = driver.findElement(emailId).getAttribute("value");
		System.out.println(att);
		
		String para = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/p[2]")).getText();
		System.out.println(para);
		
		// interview question-- when you want capture the text from webelement you use .gettext
		// when you want capture the text from the text field you by.get atrribute and paas the value
		//String text = doGetText(emailId);
		//System.out.println(text);
		
		System.out.println(doGetAttribute(emailId, "value"));

	}
	
	
	public static String doGetAttribute (By locator, String attrName ) {
		 return getElement (locator).getAttribute(attrName);
	}

	public static String doGetText(By locator) {
		return getElement(locator).getText();

	}

	public static void doClick(By locator) {
		getElement(locator).click();
	}

	public static void doSendkeys(By locator ,String value) {
		getElement(locator).sendKeys(value);

	}

public static WebElement getElement (By locator) {
	return driver.findElement(locator);
		
	}

}
