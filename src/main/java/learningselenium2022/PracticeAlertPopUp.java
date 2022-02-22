package learningselenium2022;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeAlertPopUp {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	    WebDriver driver  = new ChromeDriver();
	    
	    driver.get("https://mail.rediff.com/cgi-bin/login.cgi");		
		
		//click on go button
		driver.findElement(By.name("proceed")).click();
		
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert();
		
		//to get the text of the alert
		// alert class will work on java script pop up
		String Text = alert.getText();
		System.out.println(Text);
		
		
		if(Text.equals("Please enter a valid user name")) {
			System.out.println("correct error messg...");
		}
		else {
			System.out.println("in correct error messg...");
		}
      alert.accept();// click on Ok button
      alert.dismiss();//click on cancle //press the escape 
		
		
	}

}
