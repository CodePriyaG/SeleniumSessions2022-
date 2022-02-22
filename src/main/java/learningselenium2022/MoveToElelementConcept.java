package learningselenium2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElelementConcept {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.ikea.com/us/en/search/products/?q=top%20seller");
		
		driver.findElement(By.xpath("//input[@name='q']")).click();

	}

}
