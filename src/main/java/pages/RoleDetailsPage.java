package pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RoleDetailsPage {
	WebDriver driver;
	WebDriverWait wait;

	public RoleDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[contains(@ng-options,\"role.name\")]")
	private WebElement roleSelectDropdown;

	@FindBy(xpath = "//a[text()='Terms and Conditions']/../../span[4]")
	private WebElement termsAndConditionCheckbox;

	@FindBy(xpath = "//a[text()='Consent Form']/../../span[4]")
	private WebElement consentCheckBox;

	@FindBy(id = "btn3_sgnup")
	private WebElement joinAulmniButton;

	@FindBy(xpath = "//div[contains(text(),'Year of Joining')]/following-sibling::select")
	private WebElement yearOfJoiningDropdown;

	@FindBy(xpath = "//div[contains(text(),'Year of Graduation')]/following-sibling::select")
	private WebElement yearOfGraduationDropdown;

	public void selectRoleType(int index) {

		Select s = new Select(roleSelectDropdown);
		s.selectByIndex(index);

	}

	public void checkTermsAndCondition() {
		termsAndConditionCheckbox.click();
	}

	public void checkConsentForm() {
		consentCheckBox.click();
	}

	public void submit() {
		joinAulmniButton.click();
	}

	public void selectYearOfJoining(String year) {

		Select s = new Select(yearOfJoiningDropdown);
		s.selectByVisibleText(year);
		;

	}

	public void selectYearOfGraduation(String year) {

		Select s = new Select(yearOfGraduationDropdown);
		s.selectByVisibleText(year);
		;

	}

	public void joinAlumni(int index, String year, String year1) {
		selectRoleType(index);
		selectYearOfJoining(year);
		selectYearOfGraduation(year1);
		checkTermsAndCondition();
		checkConsentForm();
		submit();
	}

	public boolean isPageLoaded() {
		try {
			return roleSelectDropdown.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
