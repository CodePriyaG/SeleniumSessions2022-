package learningselenium2022;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeWindowPopUp {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver  = new ChromeDriver();
	    
	    driver.get("http://www.popuptest.com/goodpopups.html");
	    
	    driver.findElement(By.partialLinkText("Good PopUp #3")).click();
	    
	    
	    Set<String> handles = driver.getWindowHandles();
	    
	  //is used to work on those collection which does not maintain order
	    Iterator<String> it = handles.iterator();
	    
	    String parentWinowId = it.next();// it will move your  window 
	    System.out.println("parent window id is :"+ parentWinowId);
	    
	    String childWindowId = it.next();
	    System.out.println("child window id is :"+ childWindowId);
	    
	    driver.switchTo().window(childWindowId);
	    
	    System.out.println(driver.getTitle());
	    driver.close();
	    
	   //after closing the child window the driver is lost
	    // we have to come back to parent window
	    
	    driver.switchTo().window(parentWinowId);
	    
	    System.out.println(driver.getTitle());
	    driver.close();
	    
	    
	    

	}

}
