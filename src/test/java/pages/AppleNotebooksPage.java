package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    //private By comparisonList = By.id("comparison36588");
    private By comparisonElement = By.xpath(".//*[@class='list-compare']/div/div/ul/li/a[2]");
    private By inComparisonText = By.xpath(".//*[@class='incomparison']");

    //private String macBookProRetina = "Z0PU002JE";

    public boolean isOpened(){
        return webDriver.getCurrentUrl().equals(URL);
    }

    public void selectSortExpensive(){
        webDriver.findElement(dropLink).click();
        webDriver.findElement(expensiveDropDown).click();
    }

    public void isMacBookPresentAndSelectChecbox(String notebookName){
        List<WebElement> listofTitles = webDriver.findElements(allTitles);
        List<WebElement> listOfCheckboxes = webDriver.findElements(allCheckboxes);
        for (int i=0;i<listofTitles.size();i++){
            Log4Test.info(listofTitles.get(i).getText());
            if (listofTitles.get(i).getText().contains(notebookName)){
                Log4Test.info("Find!!!! Present on page");
                listOfCheckboxes.get(i).click();
                //ToDo: break
            }
        }

    }

    public boolean isComparisonListShown() throws InterruptedException {
        By comparisonList = By.xpath(".//*[@class='list-compare']");
        //ToDo: if not displayed Try Catch
        return webDriver.findElement(comparisonList).isDisplayed();
    }

    public boolean isMacBooksInComparisonList(String notebookName){
        List<WebElement> listofElements = webDriver.findElements(comparisonElement);
        for (int i=0;i<listofElements.size();i++){
            Log4Test.info(listofElements.get(i).getText());
            if (listofElements.get(i).getText().contains(notebookName)){
                Log4Test.info("FIND!!!!!!!!!!! Compariosn list");
                return true;
            }
        }
        return false;
    }

    public void clickCompare(){
        webDriver.findElement(inComparisonText).click();
    }
}
