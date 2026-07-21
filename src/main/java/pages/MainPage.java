package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	WebDriver driver;
	public MainPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(xpath = "(//a[contains(.,'Join / Login')])[1]")
	private WebElement signupButton;
	
	
	@FindBy(id = "email")
	private WebElement emailTextBox;
	
	
	@FindBy(className = "icon-send")
	private WebElement sendIcon;
	
	
	
	public  void enterEmail(String email) {
		emailTextBox.sendKeys(email);
	}
	
	public void submit() {
		sendIcon.click();
	}
	
	public void clickSignupButton() {
		signupButton.click();
		
	}
	
}
