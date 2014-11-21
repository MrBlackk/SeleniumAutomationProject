package pages;

import core.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Log4Test;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import static org.testng.AssertJUnit.assertFalse;


/**
 * Created by chv on 16.11.2014.
 * test
 */
public class GeneralPage extends TestBase {

    public void open(String URL){

        webDriver.get(URL);
        Log4Test.info("Open URL " + URL);
    }

    public boolean isOpened(String URL){
        return webDriver.getCurrentUrl().equals(URL);
    }

    public WebElement elementIsLocated(By element){

        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(element));
        }
        catch (StaleElementReferenceException se){
            return wait.until(ExpectedConditions.presenceOfElementLocated(element));
        }
        catch (NoSuchElementException nse){
            return wait.until(ExpectedConditions.presenceOfElementLocated(element));
        }
    }

    public List<WebElement> elementsAreLocated(By elements){

        try {
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elements));
        }
        catch (StaleElementReferenceException se){
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elements));
        }
        catch (NoSuchElementException nse){
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elements));
        }
    }

    public By getLocator(String logicalElementName){

        Properties properties = new Properties();

        try {
            properties.load(GeneralPage.class.getResourceAsStream("/object.map.properties"));
        }
        catch (IOException e){
            e.printStackTrace();
        }

        String locator = properties.getProperty(logicalElementName);

        String locatorType = locator.split(">")[0];

        String locatorValue = locator.split(">")[1];

        if (locatorType.toLowerCase().equals("id")){
            return By.id(locatorValue);
        }
        else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class"))){
            return By.className(locatorValue);
        }
        else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css"))){
            return By.cssSelector(locatorValue);
        }
        else if (locatorType.toLowerCase().equals("xpath")){
            return By.xpath(locatorValue);
        }
        else if (locatorType.toLowerCase().equals("name")){
            return By.name(locatorValue);
        }

        else {
            try {
                throw new Exception("Locator type '" + locatorType + "' not defined!");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        return null;
    }

    public void logOut(){
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", elementIsLocated(getLocator("exitButton")));
    }

    public void javaScriptClick(String element){
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", elementIsLocated(getLocator(element)));
    }

    //public void waitForPageLoaded(WebDriver driver){
    public void waitForPageLoaded(){

        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");
                    }
                };

        try {
            wait.until(expectation);
        }
        catch (Throwable error){
            assertFalse("Timeout waiting for Page Load Request to complete.", true);
        }
    }

}
