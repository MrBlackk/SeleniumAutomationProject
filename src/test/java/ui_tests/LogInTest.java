package ui_tests;

import core.TestBase;
import org.testng.annotations.Test;
import pages.MyUserPreferencesPage;
import pages.RozetkaWelcomePage;

import static org.testng.Assert.assertTrue;

/**
 * Created by c267 on 21.11.2014.
 */
public class LogInTest extends TestBase{

    RozetkaWelcomePage page = new RozetkaWelcomePage();
    MyUserPreferencesPage myPreferencesPage = new MyUserPreferencesPage();

    @Test
    public void setUpPreconditions(){
        page.open(TestData.ROZETKA_URL);
        assertTrue(page.isOpened(TestData.ROZETKA_URL));
    }

    @Test(dependsOnMethods = {"setUpPreconditions"})
    public void LogInViaFacebook() throws InterruptedException {
        page.clickLogInAndChooseFacebook();
        page.enterLoginAndPassInFacebookTab(TestData.FACEBOOK_EMAIL,TestData.FACEBOOK_PASS);
        assertTrue(page.isCorrectUserLoggedIn(TestData.FACEBOOK_NAME));
    }

    @Test(dependsOnMethods = {"LogInViaFacebook"})
    public void openMyPreferencesPageAndVerify(){
        page.openMyPreferencesPage();
        assertTrue(myPreferencesPage.isOpened(TestData.MY_PREFERENCES_PAGE_URL));
        assertTrue(myPreferencesPage.isPageContainsCorrectEmailAndName(TestData.MY_PREFS_EMAIL, TestData.FACEBOOK_NAME));
    }


}
