package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepoPage extends BasePage {

	/* Get all sidebar values */

	@FindBy(xpath = "//*[@id='js-pjax-container']/div/div[1]/div[1]/nav/a[1]")
	private WebElement navRepo;

	@FindBy(xpath = "//*[@id='js-pjax-container']/div/div[1]/div[1]/nav/a[2]")
	private WebElement navCode;

	@FindBy(xpath = "//*[@id='js-pjax-container']/div/div[1]/div[1]/nav/a[3]")
	private WebElement navCommits;

	@FindBy(xpath = "//*[@id='js-pjax-container']/div/div[1]/div[1]/nav/a[4]")
	private WebElement navIssues;

	@FindBy(xpath = "//*[@id='js-pjax-container']/div/div[1]/div[1]/nav/a[5]")
	private WebElement navTopics;

	@FindBy(xpath = "//*[@id='js-pjax-container']/div/div[1]/div[1]/nav/a[6]")
	private WebElement navWikis;

	@FindBy(xpath = "//*[@id='js-pjax-container']/div/div[1]/div[1]/nav/a[7]")
	private WebElement navUsers;

	/* Get page title */
	@FindBy(xpath = "//*[@id='js-pjax-container']/div/div[1]/div[2]/div/div[1]/h3")
	private WebElement repoTitle;

	/* Get profile avatar */
	@FindBy(xpath = "//*[@id='user-links']/li[3]/details/summary/span")
	private WebElement avatar;

	public RepoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/* Getter for page title */
	public String getRepoTitle() {
		return repoTitle.getText().trim();
	}

	/* Logout and go back to main page */
	public MainPage logOut() {
		avatar.click();
		driver.findElement(By.xpath("//*[@id='user-links']/li[3]/details/ul/li[9]/form/button")).click();
		return new MainPage(driver);
	}

}
