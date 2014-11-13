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
public class AppleNotebooksPage extends TestBase{

    private String URL = "http://rozetka.com.ua/notebooks/apple/c80004/v069/";
    private By dropLink = By.name("drop_link");
    private By expensiveDropDown = By.xpath(".//*[@id='sort_view']/div/div/ul/li[2]");

    private By allTitles = By.xpath(".//*[@id='block_with_goods']//*[@class='gtile-i-title']/a");
    private By allCheckboxes = By.xpath(".//*[@id='block_with_goods']//*[@class='g-tools-to-compare-check']");

    //private By comparisonElement = By.xpath(".//*[@class='list-compare']/div/div/ul/li/a[2]");
    private By inComparisonText = By.xpath(".//*[@class='incomparison']");

    //private String macBookProRetina = "Z0PU002JE";

    public boolean isOpened(){
        return webDriver.getCurrentUrl().equals(URL);
    }

    public void selectSortExpensive(){
        Log4Test.info("Click Выводить: от дорогих к дешевым");
        webDriver.findElement(dropLink).click();
        webDriver.findElement(expensiveDropDown).click();
    }

    public void isMacBookPresentAndSelectChecbox(String notebookName) throws InterruptedException {
        Log4Test.info("Find Mac Book and click boolean check \"К сравнению\" " + notebookName);
        List<WebElement> listofTitles = webDriver.findElements(allTitles);
        List<WebElement> listOfCheckboxes = webDriver.findElements(allCheckboxes);

        for (int i=0;i<listofTitles.size();i++){
            //Log4Test.info(listofTitles.get(i).getText());
            //Log4Test.info(listOfCheckboxes.get(i).toString());
            if (listofTitles.get(i).getText().contains(notebookName)){
                Log4Test.info("FIND!!!!!!!!!!!!!!!!!!!!!!!!! " + notebookName);
                listOfCheckboxes.get(i).click();
            }
        }
    }

    public boolean isComparisonListShown() throws InterruptedException {
        By comparisonList = By.xpath(".//*[@class='list-compare']");
        return webDriver.findElement(comparisonList).isDisplayed();
    }

    public boolean isMacBooksInComparisonList(String notebookName){
        Log4Test.info("Find Mac Book in list " + notebookName);
        By comparisonElement = By.xpath(".//*[@class='list-compare']/div/div/ul/li/a[2]");
        List<WebElement> listofElements = webDriver.findElements(comparisonElement);
        for (int i=0;i<listofElements.size();i++){
            Log4Test.info(listofElements.get(i).getText());
            if (listofElements.get(i).getText().contains(notebookName)){
                Log4Test.info("Find in list " + notebookName);
                return true;
            }
        }
        return false;
    }

    public void clickCompare(){
        Log4Test.info("Click \"В сравнении\" from one of the product's name above");
        webDriver.findElement(inComparisonText).click();
    }
}
