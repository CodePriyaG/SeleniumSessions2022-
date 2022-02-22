package learningselenium2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LanguageLinks {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		List<WebElement> searchList = driver.findElements(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/div/div"));
		System.out.println(searchList.size());
		
		for (WebElement e : searchList) {
		String text = e.getText();
		System.out.println(text);
		
		
		
		
		
		}	
		

	}

}
