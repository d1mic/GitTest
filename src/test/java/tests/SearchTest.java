package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;
import pages.RepoPage;

public class SearchTest extends BaseTest {
	
	
	MainPage mainPage = null;
	LoginPage loginPage = null;
	ProfilePage profilePage = null;
	RepoPage repoPage = null;
	
	
	@BeforeMethod()
	public void setup() {
		
		if(driver ==  null){
			mainPage = new MainPage(driver);
			mainPage.goToLoginPage();
				
			loginPage = new LoginPage(driver);
			loginPage.loginToAccount(username, password);
			
		}
		
	}
	
	/* Test Case:
	 * 1. login 
	 * 2. click on search bar 
	 * 3. fill in data into search bar 
	 * 4. data should be the name of some repository
	 * 5. check if the sidebar is correctly displayed 
	 * 6. check if the result text is displayed
	 */
	@Test()
	public void searchPositiveTest() {
		
		profilePage = new ProfilePage(driver);
		
		repoPage = profilePage.search("GitTest");
		Assert.assertTrue(repoPage.getRepoTitle().toLowerCase().contains("repository results"));
		
		repoPage.logOut();
	}
	
	/* Test Case:
	 * 1. login 
	 * 2. click on search bar 
	 * 3. fill in data into search bar 
	 * 4. data shouldn't be the name of some repository
	 * 5. check if the sidebar is correctly displayed 
	 * 6. check if the error text is displayed
	 */
	@Test()
	public void searchNegativeTest() {
		
		profilePage = new ProfilePage(driver);
		profilePage.search("hfiouahsfoahfihasiufhaisufhaisuhfiaushfaiu");
		
		repoPage = new RepoPage(driver);
		Assert.assertTrue(repoPage.getRepoTitle().toLowerCase().contains("we couldn’t find any repositories matching"));
		repoPage.logOut();
		
	}
	
	
	
	
	
 

}
