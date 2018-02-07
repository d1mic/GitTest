package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage {

	/* Get navigation bar */
	@FindBy(xpath = "//*[@id='dashboard']/div[1]/div[1]/nav/a[1]")
	private WebElement browseActivity;

	@FindBy(xpath = "//*[@id='dashboard']/div[1]/div[1]/nav/a[2]")
	private WebElement discoverRepos;

	/* Get personalized button */
	@FindBy(xpath = "//*[@id='dashboard']/div[1]/details/summary/span")
	private WebElement usrButton;

	/* Get search bar */
	@FindBy(name = "q")
	private WebElement searchBar;

	public ProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/* Check navigation bar values */
	public Boolean navbarTextCorrect() {
		if (browseActivity.getText().toLowerCase().trim().equals("browse activity")
				&& discoverRepos.getText().toLowerCase().trim().equals("discover repositories")) {
			return true;
		}
		return false;
	}

	/* Get personalized button */
	public String getButtonUsername() {
		return usrButton.getText();
	}

	/* Fill in search bar */
	public RepoPage search(String query) {
		searchBar.sendKeys(query);
		searchBar.sendKeys(Keys.ENTER);
		return new RepoPage(driver);
	}

}
