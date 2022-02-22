package mytestpackage;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	
	
	@Test
	public void loginTest() {
		System.out.println("login to app");
		int i = 9/ 0;
	}
	
	@Test (dependsOnMethods = "loginTest")
	public void homeTest() {
		System.out.println("home test");	
	
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void searchTest() {
		System.out.println("search test");
	}
	
//Test cases should be independent...try to avoid depends on methods, you should
	// create dependency 
	//try to avoid priority
	//always define the assertion--act vs- expected results-- validation point/checkpoint
	
	

}
