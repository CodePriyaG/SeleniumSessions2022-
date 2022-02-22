package learningselenium2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// 1.id- unique ( can not be duplicated)
		// 2. name- can be duplicated

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.findElement(By.name("email")).sendKeys("priya@gmail.com");

		// 3.class name- can be duplicated( can only be use only when unique in nature
		driver.findElement(By.className("form-control")).sendKeys("windows");

		// 4. xpath- is not an attribute
		// xpath is an address of the element in HTML DOM
		// absoulute xpath and relative xpath

		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("priya@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("23456");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();

		By emailId = By.xpath("//*[@id=\"input-email\"]");
		By pwd = By.xpath("//*[@id=\"input-password\"]");
		//By loginBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");

		doSendKeys(emailId, "priya@gmail.com");
		doSendKeys(pwd, "23456");
		//doClick(loginBtn);

		// 5. cssSelector- is not an attribute
		// CSS- Cascade Style Sheet
		By emailId1 = By.cssSelector("#input-email");
		By pwd1 = By.cssSelector("#input-password");
		//By loginBtn1 = By.cssSelector("#content > div > div:nth-child(2) > div > form > input");

		doSendKeys(emailId1, "priya@gmail.com");
		doSendKeys(pwd1, "23456");
		//doClick(loginBtn1);

		// 6. Linktext- only for links <a> ( aal the link are associated with a tag
		// anchor tag)
		driver.findElement(By.linkText("Rsister")).click();

		// 7. partialLinkText: only for links <a>
		// when long text is written then we use partial link text
		driver.findElement(By.partialLinkText("forgotten"));
		
		//8. tagname - means HTML tag
		String header = driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);
		
		By resister = By.linkText("Resister");
		By header1 = By.tagName("h2");
		
		System.out.println(doGetText(resister));
		System.out.println(doGetText(header1));
		
		
		
		

	}
 public static String doGetText ( By locator) {
	 return getElement(locator).getText();
 }
	public static void doClick(By locator) {
		getElement(locator).click();
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);

	}
}
