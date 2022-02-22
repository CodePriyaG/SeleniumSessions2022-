package learningselenium2022;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {
           static WebDriver driver;

	public static void main(String[] args) {

		// WAP
		// 1. total linlks
		// 2. print the text of each link
		// 3. print the href value of each link

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		System.out.println("total links:" + linksList.size());
		
	//list is index based 
		// how to iterate the list 
	int c=0; //to get the index of the list 	
	for(WebElement e : linksList) {
		String text = e.getText();
		if(!text.isEmpty()) {//to ignore the blank/empty text
		System.out.println(c+":"+text);
		
		//print the herf value
		String hrefVal = e.getAttribute("href");
		System.out.println(hrefVal);
		
	}
		//for loop for getting index of the list from a webpage
		for(int i=0; i<linksList.size(); i++){
			String text1 = linksList.get(i).getText();
			if(!text1.isEmpty()) {
				System.out.println(i+":"+ text);
			}
		}
	}
	

	By links = By.tagName("a");
	By images = By.tagName("img");

	System.out.println(getElementCount(links));
	System.out.println(getElementCount(images));

	if (getElementsTextList(links).contains("Registry")) {
		System.out.println("Registry is present");
	}

	System.out.println(getElementsAttributeList(images, "src"));
	System.out.println(getElementsAttributeList(images, "alt"));
	System.out.println(getElementsAttributeList(links, "href"));


}

public static List<WebElement> getElements(By locator) {
	return driver.findElements(locator);
}

public static int getElementCount(By locator) {
	return getElements(locator).size();
}

public static void printElementsText(By locator) {
	List<WebElement> eleList = getElements(locator);
	for (WebElement e : eleList) {
		String text = e.getText();
		System.out.println(text);
	}
}

/**
 * This method will return the list of element's text
 * 
 * @param locator
 * @return
 */
public static List<String> getElementsTextList(By locator) {
	List<WebElement> eleList = getElements(locator);
	List<String> eleTextList = new ArrayList<String>();
	for (WebElement e : eleList) {
		String text = e.getText();
		if (!text.isEmpty()) {
			eleTextList.add(text);
		}
	}
	return eleTextList;
}

/**
 * This method will return the list of element's attribute value
 * @param locator
 * @param attrName
 * @return
 */
public static List<String> getElementsAttributeList(By locator, String attrName) {
	List<WebElement> eleList = getElements(locator);
	List<String> eleAttrList = new ArrayList<String>();
	for (WebElement e : eleList) {
		String attrVal = e.getAttribute(attrName);
		eleAttrList.add(attrVal);
	}
	return eleAttrList;
}

}