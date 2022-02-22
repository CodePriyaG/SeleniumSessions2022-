package learningselenium2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopUp {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

		//html tag: file = type
		driver.findElement(By.name("upfile")).sendKeys("/Users/naveenautomationlabs/Downloads/1.jpeg");
		
		
	}

}
