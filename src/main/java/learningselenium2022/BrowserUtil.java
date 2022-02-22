package learningselenium2022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	private WebDriver driver;

	/**
	 * This method is used to initialize the driver on the basis of browsername
	 * 
	 * @param browser
	 * @return This return webdriver
	 */

	public WebDriver launchBrowser(String browser) {

		System.out.println("browser name is:" + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver",
					//"C:\\Users\\subha\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
		} else {
			System.out.println("please pass the right browser...." + browser);
		}
		return driver;

	}
/**
 * 
 * @param url
 */
	public void enterUrl(String url) {
		System.out.println("url is:" + url);
		if(url.contains("http") || url.contains("https")) {
			driver.get(url);
		}
		else {
			System.out.println("incorrect url...");
			try {
			throw new Exception ("incorrect url missing http or https");
		}catch (Exception e) {
	}
			
		}
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
public void quitBrowser()	{
	driver.quit();
}
public void closeBrowser() {
	driver.close();
}

	
	
}
