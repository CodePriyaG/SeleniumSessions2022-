package learningselenium2022;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;

	}

	public static By getBy(String locatorType, String locatorvalue) {
		By locator = null;

		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorvalue);
			break;
		case "name":
			locator = By.name(locatorvalue);
			break;
		case "classname":
			locator = By.className(locatorvalue);
			break;
		case "xpath":
			locator = By.xpath(locatorvalue);
			break;
		case "css":
			locator = By.cssSelector(locatorvalue);
			break;
		case "tagname":
			locator = By.tagName(locatorvalue);
			break;
		case "linktext":
			locator = By.linkText(locatorvalue);
			break;
			case "partiaLinkText":
				locator = By.partialLinkText(locatorvalue);
				break;


		default:
			break;
		}
		return locator;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public void doClick(String locatorType, String locatorValue) {
		getElement(getBy(locatorType, locatorValue)).click();

	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);

	}

	public void doSendKeys(String locatorType, String locatorValue, String value) {
		getElement(getBy(locatorType, locatorValue)).sendKeys(value);
	}
		public  String doGetText(By locator) {
			return getElement(locator).getText();
			
		}
			
			public  String doGetAttribute (By locator, String attrName ) {
				 return getElement (locator).getAttribute(attrName);
	}

			public  List<WebElement> getElements(By locator) {
				return driver.findElements(locator);
			}

			public  int getElementCount(By locator) {
				return getElements(locator).size();
			}

			public  void printElementsText(By locator) {
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
			public  List<String> getElementsTextList(By locator) {
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
			public  List<String> getElementsAttributeList(By locator, String attrName) {
				List<WebElement> eleList = getElements(locator);
				List<String> eleAttrList = new ArrayList<String>();
				for (WebElement e : eleList) {
					String attrVal = e.getAttribute(attrName);
					eleAttrList.add(attrVal);
				}
				return eleAttrList;
			}
			public void clickOnLink(By locator, String linkText) {
				List<WebElement> langList = getElements(locator);
				System.out.println(langList.size());
				for (WebElement e : langList) {
					String text = e.getText();
					System.out.println(text);
					if (text.contains(linkText)) {
						e.click();
						break;
					}
				}
			}

/******************************SelectDropDownUtil****************/
 
			public  void doSelectDropDownByIndex(By locator, int Index) {
				Select select = new Select(getElement(locator));
				select.selectByIndex(Index);
			}

			public  void doSelectDropDownByVisibleText(By locator, String visisbleText) {
				Select select = new Select(getElement(locator));
				select.selectByVisibleText(visisbleText);
			}
			public  void doSelectDropDownValueByValue(By locator, String Value) {
				Select select = new Select(getElement(locator));
				select.selectByValue(Value);
			}
			

			public int getDropDownOptionsCount(By locator) {
				Select select = new Select(getElement(locator));
				return select.getOptions().size();
			}

			public void selectValueFromDropDown(By locator, String value) {
				Select select = new Select(getElement(locator));
				List<WebElement> optionsList = select.getOptions();
				for (WebElement e : optionsList) {
					String text = e.getText();
					if (text.equals(value)) {
						e.click();
						break;
					}
				}
			}

			public List<String> getDropDownOptionsList(By locator) {
				Select select = new Select(getElement(locator));
				List<WebElement> optionsList = select.getOptions();
				List<String> optionsTextList = new ArrayList<String>();
				System.out.println(optionsList.size());

				for (WebElement e : optionsList) {
					String text = e.getText();
					optionsTextList.add(text);
				}
				return optionsTextList;
			}

			/******************* Actions methods **********************/

			public void doActionsSendKeys(By locator, String value) {
				Actions act = new Actions(driver);
				act.sendKeys(getElement(locator), value).perform();
			}

			/**
			 * Clicks in the middle of the given element. Equivalent to:
			 * Actions.moveToElement(onElement).click()
			 * 
			 * @param locator
			 */
			public void doActionsClick(By locator) {
				Actions act = new Actions(driver);
				act.click(getElement(locator)).perform();
			}

			/************************* WaitUtil **************************/

			/**
			 * An expectation for checking an element is visible and enabled such that you can click it.
			 * @param locator
			 * @param timeOut
			 */
			public void clickWhenReady(By locator, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				wait.until(ExpectedConditions.elementToBeClickable(locator));
			}

			/**
			 * An expectation for checking that an element is present on the DOM of a page.
			 * This does not necessarily mean that the element is visible.
			 * 
			 * @param locator
			 * @param timeOut
			 * @return
			 */
			public WebElement waitForElementPresence(By locator, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			}

			/**
			 * An expectation for checking that there is at least one element present on a
			 * web page.
			 * 
			 * @param locator
			 * @param timeOut
			 * @return
			 */
			public List<WebElement> waitForElementsPresence(By locator, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			}

			/**
			 * An expectation for checking that an element is present on the DOM of a page
			 * and visible. Visibility means that the element is not only displayed but also
			 * has a height and width that is greater than 0.
			 * default polling time = 500 ms
			 * @param locator
			 * @param timeOut
			 * @return
			 */
			public WebElement waitForElementVisible(By locator, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			}
			
			/**
			 * An expectation for checking that an element is present on the DOM of a page
			 * and visible. Visibility means that the element is not only displayed but also
			 * has a height and width that is greater than 0.
			 * default polling time = customized time
			 * @param locator
			 * @param timeOut
			 * @return
			 */
			public WebElement waitForElementVisible(By locator, int timeOut, int pollingTime) {
				WebDriverWait wait = new WebDriverWait(driver, 
							Duration.ofSeconds(timeOut), Duration.ofSeconds(pollingTime));
				return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			}

			/**
			 * An expectation for checking that all elements present on the web page that
			 * match the locator are visible. Visibility means that the elements are not
			 * only displayed but also have a height and width that is greater than 0.
			 * 
			 * @param locator
			 * @param timeOut
			 * @return
			 */
			public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

			}

			// non web elements: title, url, alert

			public boolean waitForPageTitle(String titleVal, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				return wait.until(ExpectedConditions.titleContains(titleVal));
			}

			public boolean waitForPageActTitle(String actTitle, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				return wait.until(ExpectedConditions.titleIs(actTitle));
			}

			public String doGetPageTitleContains(String titleVal, int timeOut) {
				if (waitForPageTitle(titleVal, timeOut)) {
					return driver.getTitle();
				}
				return null;
			}

			public String doGetPageTitleIs(String titleVal, int timeOut) {
				if (waitForPageActTitle(titleVal, timeOut)) {
					return driver.getTitle();
				}
				return null;
			}

			public String waitForUrlContains(String urlFraction, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

				try {
					if (wait.until(ExpectedConditions.urlContains(urlFraction))) {
						return driver.getCurrentUrl();
					}
				} catch (TimeoutException e) {
					return null;

				}
				return null;
			}

			public String waitForUrlToBe(String url, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

				try {
					if (wait.until(ExpectedConditions.urlToBe(url))) {
						return driver.getCurrentUrl();
					}
				} catch (TimeoutException e) {
					return null;

				}
				return null;
			}

			public Alert waitForAlert(int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				return wait.until(ExpectedConditions.alertIsPresent());
			}

			public String getAlertText(int timeOut) {
				return waitForAlert(timeOut).getText();
			}

			public void acceptAlert(int timeOut) {
				waitForAlert(timeOut).accept();
			}

			public void dismissAlert(int timeOut) {
				waitForAlert(timeOut).dismiss();
			}

			public WebDriver waitForFrameByIndex(int timeOut, int frameIndex) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
			}

			public WebDriver waitForFrameByLocator(int timeOut, By frameLocator) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
			}

			public WebDriver waitForFrameByElement(int timeOut, WebElement frameElement) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
			}
			
			public WebElement waitForElementPresenceWithFluentWait(By locator, int timeOut, int pollingTime) {
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(timeOut))
						.pollingEvery(Duration.ofSeconds(pollingTime))
						.ignoring(NoSuchElementException.class)
						.ignoring(StaleElementReferenceException.class)
						.withMessage(locator + " is not found within the given time......");
				return wait.until(ExpectedConditions.presenceOfElementLocated(locator));						
			}
			
			public WebElement waitForElementPresenceWithWait(By locator, int timeOut, int pollingTime) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				wait.pollingEvery(Duration.ofSeconds(pollingTime))
						.ignoring(NoSuchElementException.class)
						.ignoring(StaleElementReferenceException.class)
						.withMessage(locator + " is not found within the given time......");

				return wait.until(ExpectedConditions.presenceOfElementLocated(locator));						
				
				
			}

					
			
}
