package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.FeaturesPage;
import pages.MainPage;

public class FeaturesTest extends BaseTest {

	MainPage mainPage = null;
	FeaturesPage featuresPage = null;
	
	/* Test Case :
	 * 1. go to main page
	 * 2. go to feature page
	 * 3. check if all the navigation links on feature page are displayed
	 * 4. click everyone of them
	 */

	@Test
	public void testMain() {

		mainPage = new MainPage(driver);
		featuresPage = mainPage.goToFeatures();

		Assert.assertTrue(featuresPage.getTitleFeatures().toLowerCase().contains("how developers work"));

		Assert.assertTrue(featuresPage.getCodeReview().toLowerCase().contains("code review"));
		featuresPage.clickCodeReview();

		Assert.assertTrue(featuresPage.getProjectMng().toLowerCase().contains("project management"));

		featuresPage.clickProjectMng();

		Assert.assertTrue(featuresPage.getIntegrations().toLowerCase().contains("integrations"));

		featuresPage.clickIntegrations();

		Assert.assertTrue(featuresPage.getTeamMng().toLowerCase().contains("team management"));

		featuresPage.clickTeamMng();

		Assert.assertTrue(featuresPage.getTeamMng().toLowerCase().contains("team management"));

		featuresPage.clickTeamMng();

		Assert.assertTrue(featuresPage.getSocialCoding().toLowerCase().contains("social coding"));

		featuresPage.clickSocialCoding();

		Assert.assertTrue(featuresPage.getDocumentation().toLowerCase().contains("documentation"));

		featuresPage.clickDocumentation();

		Assert.assertTrue(featuresPage.getCodeHosting().toLowerCase().contains("code hosting"));
		featuresPage.clickCodeHosting();

		mainPage = featuresPage.goBackHome();

	}

}
