package learningselenium2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchElementConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		driver.findElement(By.id("input-email11")).sendKeys("priya@gmail.com");
		
//when selenium is not able to find element   on the basis of given locator then you get
//NoSuchElementException: no such element : unable to locate element		
// how to resolve this--change the locator , or put some wait in it		
		
		
		
		
		
		
		
		

	}

}
