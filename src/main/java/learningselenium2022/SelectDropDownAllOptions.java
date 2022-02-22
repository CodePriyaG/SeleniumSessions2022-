package learningselenium2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownAllOptions {


	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//html tag = select
		By country = By.id("Form_submitForm_Country");
		By state  = By.id("Form_submitForm_State");
		
		Select select = new Select (driver.findElement(country));
		
		List<WebElement>optionsList = select.getOptions();
		System.out.println(optionsList.size());
		//return type of getoption method is list of webelement
		
		
		int i=0;
		for(WebElement e : optionsList) {
			System.out.println(i+":"+e.getText());
			i++;
		}
		
	}		
//1:05 interview question		
//need to complete it 		
}		

	

