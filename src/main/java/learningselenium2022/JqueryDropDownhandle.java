package learningselenium2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownhandle {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justanInputbox")).click();
		
		List<WebElement> choiceList =
				driver.findElements(By.xpath("//span[@class='comboTreeitemTitle']"));

		for(WebElement e : choiceList) {
			String text = e.getText();
			System.out.println(text);
		}
	}

}
