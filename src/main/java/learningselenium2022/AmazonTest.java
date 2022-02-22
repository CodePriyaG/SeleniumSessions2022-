package learningselenium2022;

public class AmazonTest {

	public static void main(String[] args) {
		String browser = "chrome";
	BrowserUtil br= new BrowserUtil();	
		
		br.launchBrowser(browser);
		br.enterUrl("https://www.amazon.com");
		String pageTitle = br.getPageTitle();
		
		if(pageTitle.contains("amazon")) {
			System.out.println("tile is correct");
		}
		
		if(br.getPageUrl().contains("amazon")) {
			System.out.println("url is correct");
			
		}
		br.quitBrowser();
		}
		
		
	}


