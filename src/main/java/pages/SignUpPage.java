package pages;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "fname")
	private WebElement firstNameTextbox;

	@FindBy(id = "lname")
	private WebElement lastNameTextbox;

	@FindBy(id = "email")
	private WebElement emailTextbox;

	@FindBy(id = "password")
	private WebElement passwordTextbox;

	@FindBy(id = "re-password")
	private WebElement confirmPasswordTextbox;

	@FindBy(xpath = "//button[contains(text(),'BACK')]")
	private WebElement goBackButton;

	@FindBy(xpath = "//span[text()='Sign Up']")
	private WebElement signUpButton;

	// Otp Page elements
	@FindBy(xpath = "//div[contains(text(),'Verify OTP')]")
	private WebElement verifyOtpText;

	@FindBy(id = "otp_input")
	private WebElement otpTextbox;

	@FindBy(partialLinkText = "Resend OTP")
	private WebElement resendOtpButton;

	@FindBy(xpath = "//span[contains(text(),'We have just sent you One')]")
	private WebElement otpSentText;

	@FindBy(xpath = "//span[text()='Verify']")
	private WebElement verifyOtpButton;

	public void enterFirstName(String name) {
		firstNameTextbox.clear();
		firstNameTextbox.sendKeys(name);
	}

	public void enterLastName(String name) {
		lastNameTextbox.clear();
		lastNameTextbox.sendKeys(name);
	}

	public void enterEmail(String email) {
		emailTextbox.clear();
		emailTextbox.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordTextbox.clear();
		passwordTextbox.sendKeys(password);
	}

	public void enterConfirmPassword(String password) {
		confirmPasswordTextbox.clear();
		confirmPasswordTextbox.sendKeys(password);
	}

	public MainPage clickBack() {
		goBackButton.click();

		return new MainPage(driver);
	}

	public void clickSignup() {

		signUpButton.click();

	}

	public void signUp(String fname, String lname, String password, String confirmpassword) {

		enterFirstName(fname);
		enterLastName(lname);

		enterPassword(password);
		enterConfirmPassword(confirmpassword);
		clickSignup();
	}

	public RoleDetailsPage verfiyOtp() {
		wait.until(ExpectedConditions.visibilityOf(otpSentText));
		otpTextbox.clear();

		System.out.print("Enter otp :");
		String otp = new Scanner(System.in).next();

		otpTextbox.sendKeys(otp);

		verifyOtpButton.click();

		return new RoleDetailsPage(driver);

	}
	

	public boolean isDetailPageisDisplayed() {
		try {
			return firstNameTextbox.isDisplayed();
		} catch (Exception e) {
			return firstNameTextbox.isDisplayed();
		}
	}

	
	public boolean isOnSignupPage() {
		try {
			firstNameTextbox.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	

	public boolean isVerifyOtpPageLoaded() {

		try {
			return verifyOtpText.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	
	public boolean isOtpSent() {
		try {
			return otpSentText.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

}
