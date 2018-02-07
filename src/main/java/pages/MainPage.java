package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

	/* Get links from navbar */

	@FindBy(xpath = "//a[@href='/buisness']")
	WebElement buisnessButton;

	@FindBy(xpath = "//a[@href='/features']")
	WebElement featuresButton;

	@FindBy(xpath = "//a[@href='/explore']")
	WebElement exploreButton;

	@FindBy(xpath = "//a[@href='/marketplace']")
	WebElement marketButton;

	@FindBy(xpath = "//a[@href='/priceing']")
	WebElement pricingButton;

	@FindBy(xpath = "html/body/div[1]/header/div/div[2]/div/span/div/a[1]")
	WebElement signInButton;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/* Go to login Page */
	public LoginPage goToLoginPage() {
		signInButton.click();
		return new LoginPage(driver);
	}

	/* Go to features Page */
	public FeaturesPage goToFeatures() {
		featuresButton.click();
		return new FeaturesPage(driver);
	}

}
