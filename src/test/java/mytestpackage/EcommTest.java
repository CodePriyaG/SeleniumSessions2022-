package mytestpackage;


	import org.testng.annotations.Test;

	public class EcommTest {
		
		//whenever you write any ant test case for testing you should 
		//write Test like-loginTest
		//you can priorities the test case, you can give 0 priority
		// -ve priority also can be given
		//if no priority or same priority the it will execute alphabetically

		@Test(priority = 1)
		public void loginTest() {
			System.out.println("login test");
		}

		@Test(priority = 2)
		public void homeTest() {
			System.out.println("home test");
		}

		@Test(priority = 4)
		public void cartTest() {
			System.out.println("cart test");
		}

		@Test(priority = 3)
		public void searchTest() {
			System.out.println("search test");
		}
		
		@Test(priority = 0)
		public void m3Test() {
			System.out.println("m3 test");
		}

		@Test()
		public void m1Test() {
			System.out.println("m1 test");
		}

		@Test()
		public void m2Test() {
			System.out.println("m2 test");
		}

	}	
	
	
	
	
	
	
	
	
	
	
	
	


