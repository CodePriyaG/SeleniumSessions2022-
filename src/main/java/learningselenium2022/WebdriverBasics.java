package learningselenium2022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverBasics {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\subha\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("title is: " + title);

// verification point/checkpoint/actual vs expected results:

		if (title.equals("Google")) {
			System.out.println("correct title");
		} else {
			System.out.println("incorrect title");
		}
		// automation testing
		
		
		//System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		
		//if(driver.getPageSource().contains("Copyrigth the clouser Library Authors"))
        //System.out.println("is Present");
		driver.quit(); // close the browser
		
		
		
	}
}
