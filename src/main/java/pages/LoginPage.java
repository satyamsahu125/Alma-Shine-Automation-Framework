package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//form[@ng-submit='loginNow()']/div[1]")
	private WebElement loginPageText;
	
	public boolean isOnLoginPage() {
		try {
			loginPageText.isDisplayed();
			return true;
		}
		catch (NoSuchElementException e) {
			return false;
		}
	}
}
