package learningselenium2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchSuggestion {


	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www2.hm.com/en_us/index.html");
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		driver.findElement(By.id("main-search")).sendKeys("dress");
		
		Thread.sleep(4000);
		selectSuggestion("dress pants");
		//driver.findElement(By.xpath("//div[@class='autosuggestsearch parbase']//li[contains(text(),'shirt')]")).click();
	}
public static void selectSuggestion(String suggestion) {		
		WebElement ele = driver.findElement(By.xpath("//div[@class='autosuggestsearch parbase']//li[contains(text(),'shirt')]"));
			//driver.findElement(By.xpath("//div[@class='autosuggestsearch parbase']//li[contains(text(),'"+suggestion+"')]"));
		ele.click();
		//div[@class='autosuggestsearch parbase']//li[@id='ui-id-15')]
		//div[@class='autosuggestsearch parbase']//li[contains(text(),'shirt')]"
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
