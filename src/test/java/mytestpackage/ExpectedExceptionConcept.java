package mytestpackage;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	
 @Test	(expectedExceptions = {NullPointerException.class,ArithmeticException.class})
	public void searchtest() {
	System.out.println("search test");
	int i = 9/0;
	
	
	//if  you expecting an exception then you can write the exception to handle the exception and test case will pass
	// you can write multiple exceptions too 
	
	
	
	
 }
}
	
	
	
	
	


