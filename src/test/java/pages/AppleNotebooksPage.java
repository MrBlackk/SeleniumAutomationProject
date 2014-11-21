package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import sun.rmi.runtime.Log;
import utilities.Log4Test;

import java.util.List;

/**
 * Created by chv on 12.11.2014.
 */
public class AppleNotebooksPage extends GeneralPage{

    private static final String ELEMENT_IN_COMPAR_LIST = ".//*[@class='list-compare']/div/div/ul/li[%s]/a[2]";// String.format
    private static final String ELEMENT_IN_SORT_DROP_DOWN = ".//*[@id='sort_view']/div/div/ul/li[%s]"; //String.format

    //Select element from "Sort By" drop-down(1-от дешевых к дорогим; 2-от дорогих к дешевым; 3-популярные; 4-новинки; 5-акции; 6-последние добавленные)
    public void selectElementFromSortDropDown(int elem){
        elementIsLocated(getLocator("sortDropDown")).click();
        Log4Test.info("Click \"" + elementIsLocated(By.xpath(String.format(ELEMENT_IN_SORT_DROP_DOWN + "/a", elem))).getText() + "\" in \"Выводить:\" drop-down"); //add "/a" to get element text
        elementIsLocated(By.xpath(String.format(ELEMENT_IN_SORT_DROP_DOWN, elem))).click();
    }

    //Get list of titles on the page and when find correct notebook(get "i" element), create list of checkboxes and select "i"-checkbox
    public void isMacBookPresentAndSelectChecbox(String notebookName) throws InterruptedException {
        List<WebElement> listOfTitles = elementsAreLocated(getLocator("allAppleNotebooksTitles"));

        for (int i=0;i<listOfTitles.size();i++){
            if (listOfTitles.get(i).getText().contains(notebookName)){
                List<WebElement> listOfCheckboxes = elementsAreLocated(getLocator("allAppleNotebooksCheckboxes"));
                ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", listOfCheckboxes.get(i));  //Firefox & Chrome
                //listOfCheckboxes.get(i).click();  //Chrome
                Log4Test.info("Find Mac Book " + notebookName + " and select boolean check \"К сравнению\"");
                break;
            }
        }
    }

    //Verify that comparison list is present and "expected" element(1, 2, 3,  etc...) is present in comparison list.
    public boolean isNumberOfElementsInComparisonListCorrect(int expected){
        WebElement actual = elementIsLocated(By.xpath(String.format(ELEMENT_IN_COMPAR_LIST, expected)));
        Log4Test.info("Comparison list is shown. Number of elements in the list: " + expected);
        return actual.isDisplayed();
    }

   //Verify that a MacBook is present in comparison list
    public boolean isMacBooksInComparisonList(String notebookName) throws InterruptedException {
        List<WebElement> listOfElements = elementsAreLocated(getLocator("comparisonListElements"));

        for (int i=0;i<listOfElements.size();i++){
            if (listOfElements.get(i).getText().contains(notebookName)){
                Log4Test.info("Find " + listOfElements.get(i).getText() + " in comparison list");
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
