package pages;

import com.google.common.base.Function;
import core.TestBase;
import core.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import utilities.Log4Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by chv on 12.11.2014.
 */
public class AppleNotebooksPage extends GeneralPage{

    public void selectSortExpensive(){
        //Log4Test.test("selectSortExpensive");
        Log4Test.info("Click Выводить: от дорогих к дешевым");
        elementIsLocated(getLocator("sortDropDown")).click();
        elementIsLocated(getLocator("sortDropDownExpensive")).click();
    }

    public void isMacBookPresentAndSelectChecbox(String notebookName) throws InterruptedException {
        //Log4Test.test("isMacBookPresentAndSelectChecbox");
        Log4Test.info("Find Mac Book and click boolean check \"К сравнению\" " + notebookName);
        List<WebElement> listOfTitles = elementsAreLocated(getLocator("allAppleNotebooksTitles"));

        for (int i=0;i<listOfTitles.size();i++){
            if (listOfTitles.get(i).getText().contains(notebookName)){
                List<WebElement> listOfCheckboxes = elementsAreLocated(getLocator("allAppleNotebooksCheckboxes"));
                listOfCheckboxes.get(i).click();
                break;
            }
        }
    }

    public boolean isComparisonListShown() throws InterruptedException {
        //Log4Test.test("isComparisonListShown");
        return elementIsLocated(getLocator("comparisonList")).isDisplayed();
    }

    public boolean isMacBooksInComparisonList(String notebookName) throws InterruptedException {
        Log4Test.info("Find Mac Book in list " + notebookName);
        waitForPageLoaded();
        //ToDo: re-implement
        Thread.sleep(1000);
        List<WebElement> listOfElements = elementsAreLocated(getLocator("comparisonListElements"));

        for (int i=0;i<listOfElements.size();i++){
            Log4Test.test(listOfElements.get(i).getText());
            Log4Test.test("Size:" + listOfElements.size() + " and i element: " + notebookName);
            if (listOfElements.get(i).getText().contains(notebookName)){
                Log4Test.info("Find in list " + notebookName);
                return true;
            }
        }
        return false;
    }

    public void clickCompare(){
        Log4Test.info("Click \"В сравнении\" from one of the product's name above");
        elementIsLocated(getLocator("inComparisonCheckboxText")).click();
    }
}
