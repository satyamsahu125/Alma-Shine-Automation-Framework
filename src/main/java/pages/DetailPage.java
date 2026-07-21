package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.FileUtility;
import utilities.WaitUtility;

public class DetailPage {
	WebDriverWait wait;
	WebDriver driver;
	public DetailPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@id='current_city']//input")
	private WebElement cityTextBox;

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement mobileNumberTextbox;

	@FindBy(xpath = "//span[text()='Next step']")
	private WebElement nextButton;

	@FindBy(xpath = "//input[@type='file']")
	private WebElement addPicture;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement saveImageButton;

	@FindBy(xpath = "//span[text()='Save changes']")
	private WebElement saveChangesButton;

	@FindBy(xpath = "(//span[contains(text(),'Thank You')]/../..//button)[2]")
	private WebElement gotoProfileButton;
	
	
	public void addDetails(String city, String mobileNumber, String path) {
		cityTextBox.clear();

		cityTextBox.sendKeys(city);
		
		WaitUtility.waitForSeconds(1);
		
		cityTextBox.sendKeys(Keys.ARROW_DOWN);
		cityTextBox.sendKeys(Keys.ENTER);
		
		

		mobileNumberTextbox.sendKeys(mobileNumber);

		nextButton.click();
		String image = FileUtility.getImagePath(path);
		addPicture.sendKeys(image);

		wait.until(ExpectedConditions.visibilityOf(saveImageButton)).click();
		

		WaitUtility.waitForSeconds(1);
		wait.until(ExpectedConditions.visibilityOf(saveChangesButton)).click();
		
		wait.until(ExpectedConditions.visibilityOf(gotoProfileButton)).click();
		

		
	}
	
}
