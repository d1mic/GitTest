package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

public class LoginTest extends BaseTest {

	MainPage mainPage = null;
	LoginPage loginPage = null;
	ProfilePage profilePage = null;

	/*
	 * Test case: 
	 * 1. go to Main page 
	 * 2. Click on SignIn 
	 * 3. Check if the page is displayed 
	 * 4. Enter good credentials 
	 * 5. Click on login 
	 * 6. Check on Profile page if elements are displayed correctly
	 */
	@BeforeMethod()
	public void setupTest() {
		mainPage = new MainPage(driver);
	}
	
	@Test()
	public void testLogin() {

		loginPage = mainPage.goToLoginPage();
		Assert.assertEquals(loginPage.getLoginTitle().toLowerCase().trim(), "sign in to github");

		profilePage = loginPage.loginToAccount(username, password);
		Assert.assertTrue(profilePage.navbarTextCorrect());
		Assert.assertEquals(profilePage.getButtonUsername(), account);
	}

}
