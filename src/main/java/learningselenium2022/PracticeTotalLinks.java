package learningselenium2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeTotalLinks {

	public static void main(String[] args) {
	

	WebDriverManager.chromedriver().setup();
    WebDriver driver  = new ChromeDriver();
    
    driver.get("https://www.amazon.com");
    
    
    List<WebElement> linkList = driver.findElements(By.tagName("a"));
    
    //to print the total no. of links
    System.out.println("total links:" + linkList.size());
    
    //to iterate the links, print all the links
    
    for(WebElement e: linkList) {
    	String Text = e.getText();
    	System.out.println(Text);
    }
		
	//how to captur footer links
    
    List<WebElement> FooterList = driver.findElements(By.xpath("//div[class='navFooterLine']//a"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
