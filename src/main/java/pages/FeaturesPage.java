package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeaturesPage extends BasePage {

	/* Get page title */

	@FindBy(xpath = "html/body/div[4]/div[1]/div/h1")
	private WebElement titleFeatures;

	/* Get navigation bar data */

	@FindBy(xpath = "html/body/div[4]/div[2]/div/div/a[1]")
	private WebElement navCodeReview;
	@FindBy(xpath = "html/body/div[4]/div[2]/div/div/a[2]")
	private WebElement navProjectMng;
	@FindBy(xpath = "html/body/div[4]/div[2]/div/div/a[3]")
	private WebElement navIntegrations;
	@FindBy(xpath = "html/body/div[4]/div[2]/div/div/a[4]")
	private WebElement navTeamMng;
	@FindBy(xpath = "html/body/div[4]/div[2]/div/div/a[5]")
	private WebElement navSocialCoding;
	@FindBy(xpath = "html/body/div[4]/div[2]/div/div/a[6]")
	private WebElement navDocumentation;
	@FindBy(xpath = "html/body/div[4]/div[2]/div/div/a[7]")
	private WebElement navCodeHosting;

	/* Get navigation icon link */

	@FindBy(xpath = "//a[@href='https://github.com/']")
	private WebElement navIcon;

	public FeaturesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	/* Getter for page title */

	public String getTitleFeatures() {
		return titleFeatures.getText().trim();
	}

	/* Click on icon and go back to main page */

	public MainPage goBackHome() {
		navIcon.click();
		return new MainPage(driver);
	}

	/* Getters for navigation bar titles */

	public String getCodeReview() {
		return navCodeReview.getText().trim();
	}

	public String getCodeHosting() {
		return navCodeHosting.getText().trim();
	}

	public String getDocumentation() {
		return navDocumentation.getText().trim();
	}

	public String getIntegrations() {
		return navIntegrations.getText().trim();
	}

	public String getProjectMng() {
		return navProjectMng.getText().trim();
	}

	public String getSocialCoding() {
		return navSocialCoding.getText().trim();
	}

	public String getTeamMng() {
		return navTeamMng.getText().trim();
	}

	/* Click on each nav bar element */
	
	public void clickCodeReview() {
		navCodeReview.click();
	}

	public void clickCodeHosting() {
		navCodeHosting.click();
	}

	public void clickDocumentation() {
		navDocumentation.click();
	}

	public void clickIntegrations() {
		navIntegrations.click();
	}

	public void clickProjectMng() {
		navProjectMng.click();
	}

	public void clickSocialCoding() {
		navSocialCoding.click();
	}

	public void clickTeamMng() {
		navTeamMng.click();
	}

}
