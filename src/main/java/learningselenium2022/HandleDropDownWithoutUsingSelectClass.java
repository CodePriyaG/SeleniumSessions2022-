package learningselenium2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDownWithoutUsingSelectClass {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By Country = By.xpath("//select[@id='Form_submitForm_Country']/option");
		
				List<WebElement>CountryList = driver.findElements(Country);
				
		for (WebElement e : CountryList) {
			String text = e.getText();
			if (text.equals("india")) {
				e.click();
				break;
				// select the dropdown,select the xpath,create a list,
				//iterate,match,click,break
			}
		}
		
		
		
	}

}
