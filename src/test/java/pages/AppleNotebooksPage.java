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

    private By allTitles = By.xpath(".//*[@id='block_with_goods']//*[@class='gtile-i-title']/a");
    private By allCheckboxes = By.xpath(".//*[@id='block_with_goods']//*[@class='g-tools-to-compare-check']");

    //private By comparisonElement = By.xpath(".//*[@class='list-compare']/div/div/ul/li/a[2]");
    private By inComparisonText = By.xpath(".//*[@class='incomparison']");



    public void selectSortExpensive(){
        Log4Test.test("selectSortExpensive");
        Log4Test.info("Click Выводить: от дорогих к дешевым");
        elementIsLocated(getLocator("sortDropDown")).click();
        elementIsLocated(getLocator("sortDropDownExpensive")).click();
    }

    public void isMacBookPresentAndSelectChecbox(String notebookName) throws InterruptedException {
        Log4Test.info("Find Mac Book and click boolean check \"К сравнению\" " + notebookName);
        List<WebElement> listofTitles = webDriver.findElements(allTitles);
        List<WebElement> listOfCheckboxes = webDriver.findElements(allCheckboxes);

        for (int i=0;i<listofTitles.size();i++){
            if (listofTitles.get(i).getText().contains(notebookName)){
                //listOfCheckboxes.get(i).click();

                //--------StaleElementReferenceException workaround---------
                try{
                    listOfCheckboxes.get(i).click();
                }
                catch (org.openqa.selenium.StaleElementReferenceException ex){
                    List<WebElement> listOfCheckboxes2 = webDriver.findElements(allCheckboxes);
                    //webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    listOfCheckboxes2.get(i).click();
                }
                break;
            }
        }
    }

    public boolean isComparisonListShown() throws InterruptedException {
        By comparisonList = By.xpath(".//*[@class='list-compare']");
        //return webDriver.findElement(comparisonList).isDisplayed();

        //--------StaleElementReferenceException workaround---------
        try{
            return webDriver.findElement(comparisonList).isDisplayed();
        }
        catch (org.openqa.selenium.StaleElementReferenceException ex){
            By comparisonList2 = By.xpath(".//*[@class='list-compare']");
            return webDriver.findElement(comparisonList2).isDisplayed();
        }




    }

    public boolean isMacBooksInComparisonList(String notebookName){
        By comparisonElement = By.xpath(".//*[@class='list-compare']/div/div/ul/li/a[2]"); //To fix re-creating elements issue
        Log4Test.info("Find Mac Book in list " + notebookName);
        List<WebElement> listOfElements = webDriver.findElements(comparisonElement);
        for (int i=0;i<listOfElements.size();i++){
            if (listOfElements.get(i).getText().contains(notebookName)){
                Log4Test.info("Find in list " + notebookName);
                return true;
            }
            // Workaround: sometimes test fails
            else{
                By comparisonElement2 = By.xpath(".//*[@class='list-compare']/div/div/ul/li/a[2]");
                List<WebElement> listOfElements2 = webDriver.findElements(comparisonElement2);
                for (int j=0;j<listOfElements2.size();j++) {
                    if (listOfElements2.get(j).getText().contains(notebookName)) {
                        Log4Test.info("Find in list#2 " + notebookName);
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public void clickCompare(){
        Log4Test.info("Click \"В сравнении\" from one of the product's name above");
        webDriver.findElement(inComparisonText).click();
    }
}
