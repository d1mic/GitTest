package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	/* Get login and password field */

	@FindBy(id = "login_field")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement passWord;

	/* Get page title */

	@FindBy(xpath = "//*[@id='login']/form/div[2]/h1")
	private WebElement titleText;

	/* Get login buton */

	@FindBy(name = "commit")
	private WebElement login;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/* Getter for login title */
	public String getLoginTitle() {
		return titleText.getText();
	}

	/* Set credentials and clik on login button */
	public void setUsername(String usr) {
		userName.sendKeys(usr);
	}

	public void setPassword(String pass) {
		passWord.sendKeys(pass);
	}

	public void clickLogin() {
		login.click();
	}

	/* Login to account using username and password */

	public ProfilePage loginToAccount(String usr, String pass) {
		this.setUsername(usr);
		this.setPassword(pass);
		this.clickLogin();
		return new ProfilePage(driver);

	}

}
