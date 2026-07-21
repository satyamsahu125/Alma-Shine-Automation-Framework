package aTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DetailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;
import pages.RoleDetailsPage;
import pages.SignUpPage;
import utilities.CustomSoftAssert;

@Listeners(utilities.ListenerImplementation.class)
public class SignupTest extends BaseClass {

	
	
	@Test(dataProvider = "testData" )
	public void signupWithValidCredentials(String email, String firstName, String lastName, String password,
			String confirmPassword, String yearOfJoining, String yearOfGraduation, String city, String mobileNumber,
			String imageName) {

		MainPage hp = new MainPage(driver);

		hp.clickSignupButton();

		hp.enterEmail(email);
		hp.submit();

		SignUpPage sp = new SignUpPage(driver);

		sp.signUp(firstName, lastName, password, confirmPassword);
		
		Assert.assertTrue(sp.isVerifyOtpPageLoaded());

		RoleDetailsPage role = sp.verfiyOtp();

		role.joinAlumni(1, yearOfJoining, yearOfGraduation);

		DetailPage dp = new DetailPage(driver);

		dp.addDetails(city,mobileNumber, imageName);
		
		HomePage home = new HomePage(driver);
		
		Assert.assertTrue(home.isOnHomePage());

	}
	
	
	
	@Test(dataProvider = "testData")
	public void validateInvalidPassword(String email, String firstName, String lastName, String password,
			String confirmPassword) {


		CustomSoftAssert softAssert = new CustomSoftAssert();
		
		MainPage hp = new MainPage(driver);

		hp.clickSignupButton();

		hp.enterEmail(email);
		hp.submit();

		
		SignUpPage signupPage = new SignUpPage(driver);

		signupPage.signUp(firstName, lastName, password, confirmPassword);
		
		softAssert.assertTrue(
			    signupPage.isOnSignupPage(),
			    "User should remain on the signup page for an invalid name."
			);


	}
	
	
	@Test(dataProvider = "testData")
	public void validateExistingEmail(String email) {

		CustomSoftAssert softAssert = new CustomSoftAssert();
		MainPage home = new MainPage(driver);

		home.clickSignupButton();

		home.enterEmail(email);
		
		home.submit();
		
		LoginPage loginPage = new LoginPage(driver);
		
		softAssert.assertTrue(
			    loginPage.isOnLoginPage(),
			    "Login page should be displayed."
			);
		
		
		

	}
	@Test(dataProvider = "testData")
	public void validateInvalidName(String email, String firstName, String lastName, String password,
			String confirmPassword) {
		

		CustomSoftAssert softAssert = new CustomSoftAssert();
		MainPage hp = new MainPage(driver);

		hp.clickSignupButton();

		hp.enterEmail("dasdasdasdsa@gmail.com");
		hp.submit();

		SignUpPage signupPage = new SignUpPage(driver);

		signupPage.signUp(firstName, lastName, password, confirmPassword);
		
		softAssert.assertTrue(
			    signupPage.isOnSignupPage(),
			    "User should remain on the signup page for an invalid name."
			);
		
		
	}

}
