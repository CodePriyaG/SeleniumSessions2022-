package learningselenium2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownConcept {


	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//html tag = select
		By country = By.id("Form_submitForm_Country");
		By state  = By.id("Form_submitForm_State");
		//WebElement country_ele = driver.findElement(country);
		//WebElement state_ele = driver.findElement(state);
		
		
		//Select select = new Select (country_ele);
		
		//select.selectByIndex(5);// this can be used for values which constant 
		//( total no.of day,month,year)
		//select.selectByVisibleText ("India");
		//select.selectByValue ("Australia"); //only work with value
		//Thread.sleep(2000);
		
		//Select select1 = new Select(state_ele);
		//select1.selectByVisibleText("karnataka");
		
		doSelectDropDownByVisibleText(country,"India");
		Thread.sleep(2000);
		doSelectDropDownByVisibleText(state, "Karnataka");
	}	
		
public static WebElement getElement (By locator)	{
	return driver.findElement(locator);
		
				
}
public static void doSelectDropDownByIndex(By locator, int Index) {
	Select select = new Select(getElement(locator));
	select.selectByIndex(Index);
}

public static void doSelectDropDownByVisibleText(By locator, String visisbleText) {
	Select select = new Select(getElement(locator));
	select.selectByVisibleText(visisbleText);
}
public static void doSelectDropDownValueByValue(By locator, String Value) {
	Select select = new Select(getElement(locator));
	select.selectByValue(Value);
}
}