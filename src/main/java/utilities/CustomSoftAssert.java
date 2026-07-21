package utilities;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
/**
 * Custom SoftAssert for clear Valdiation Message and logging
 */
public class CustomSoftAssert {

	
	SoftAssert softAssert = new SoftAssert();
	
	public void assertEquals( Object actual , Object expected , String message) {
		
		
		try {
			softAssert.assertEquals(actual, expected);
			
			ListenerImplementation.test.log(Status.PASS,"PASS: " + message);
		}
		catch (AssertionError e) {
			ListenerImplementation.test.log(Status.FAIL,"FAIL: " + message +
					"<br> Expected: " + expected + "<br> Actual: " + actual);
			softAssert.fail();
		}
		
		
	}
	
	
	public void assertTrue(boolean condition , String message) {
		

		try {
			softAssert.assertTrue(condition);
			
			ListenerImplementation.test.log(Status.PASS,"PASS: " + message);
		}
		
		catch (AssertionError e) {
			ListenerImplementation.test.log(Status.FAIL,"FAIL: " + message );
			
			softAssert.fail();
		}
		
	}
	public void assertAll() {
		softAssert.assertAll();
	}
	
}
