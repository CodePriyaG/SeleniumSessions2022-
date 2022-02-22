package AppTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver driver;
	
 
	@Parameters ({ "browser", "url" , "timeout"})
	@BeforeTest
	public void setUp(String browserName, String url, String timeout) {
		
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("safari")) {
			driver= new ChromeDriver();
		}
		
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(timeout)));
		driver.get(url);
	}
	
@AfterTest
public void tearDown()  {
	driver.quit();
}
	
	
	
	
	
	
	
	
	
	
	
	

}
