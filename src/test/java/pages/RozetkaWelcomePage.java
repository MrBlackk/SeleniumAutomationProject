package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.Log4Test;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by chv on 12.11.2014.
 */
public class RozetkaWelcomePage extends GeneralPage {

    public void openNotebooksPage(){
        Log4Test.info("Click \"Ноутбуки\" under \"Ноутбуки, планшеты и компьютеры\"");
        waitForPageLoaded();
        elementIsLocated(getLocator("notebookPage")).click();
    }

    public void clickLogInAndChooseFacebook() throws InterruptedException {
        Log4Test.info("Click \"Вход в интернет магазин\"");
        try{
            elementIsLocated(getLocator("logInButton")).click();
        }
        catch (org.openqa.selenium.StaleElementReferenceException e){
            System.out.println("catch in clickLogInAndChooseFacebook");
            elementIsLocated(getLocator("logInButton")).click();
        }
        Log4Test.info("Click  \"Войти как пользователь Facebook\"");
        elementIsLocated(getLocator("logInFacebook")).click();
    }

    public void enterLoginAndPassInFacebookTab(String email, String pass){
        Log4Test.info("Login using your credentials");
        ArrayList<String> allWindows = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(allWindows.get(1));

        elementIsLocated(getLocator("emailFacebook")).clear();
        elementIsLocated(getLocator("emailFacebook")).sendKeys(email);

        elementIsLocated(getLocator("passFacebook")).clear();
        elementIsLocated(getLocator("passFacebook")).sendKeys(pass);

        elementIsLocated(getLocator("enterButtonFacebook")).click();
        webDriver.switchTo().window(allWindows.get(0));
    }

    public boolean isCorrectUserLoggedIn(String userName){
        Log4Test.info("Verify that your First and Last Name appeared on the top right corner");
        return elementIsLocated(getLocator("userName")).getText().contains(userName);
    }

    public void openMyPreferencesPage(){
        Log4Test.info("Click your First and Last Name");
        elementIsLocated(getLocator("userName")).click();
    }
}
