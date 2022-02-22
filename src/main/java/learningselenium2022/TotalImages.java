package learningselenium2022;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {

	static WebDriver driver;

	public static void main(String[] args) {

		// total images
		// how to find out total no. of images on a page
		// html tag for images is img

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
//		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		// System.out.println("total images:" + imagesList.size());
	
		// capture alt value and src value

//		for(WebElement e : imageList) {
//			String altVal =e.getAttribute("alt");
		// String srcVal =e.getAttribute("src");
		// System.out.println(altVal + ":" + srcVal);

//	}

//}
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


public static  List<WebElement> getElements(By locator) {
	return driver.findElements(locator);

}
         
	public static int getElementCount(By locator) {
		return getElements(locator).size();

	}
	

//generic method for print the text

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


	public static void printElementsText(By locator) {
		List<WebElement> eleList = getElements(locator);
		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
			
			
		}
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
