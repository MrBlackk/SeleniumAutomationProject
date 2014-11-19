package pages;

import org.openqa.selenium.By;
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


    public void selectSortExpensive(int elem){
        //Log4Test.test("selectSortExpensive");
        Log4Test.info("Click 'Выводить: от дорогих к дешевым'");
        elementIsLocated(getLocator("sortDropDown")).click();
        Log4Test.info("Click \"" + elementIsLocated(By.xpath(String.format(ELEMENT_IN_SORT_DROP_DOWN + "/a", elem))).getText() + "\" in Sort drop-down"); //add "/a" to get element text
        elementIsLocated(By.xpath(String.format(ELEMENT_IN_SORT_DROP_DOWN, elem))).click();
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

    public boolean isNumberOfElementsInComparisonListCorrect(int expected){
        //Log4Test.test("numberOfElementsInComparisonList");
        //ToDo: re-implement a little bit
        WebElement actual = elementIsLocated(By.xpath(String.format(ELEMENT_IN_COMPAR_LIST, expected)));
        Log4Test.info("Comparison list is shown. Number of elements in the list: " + expected);
        return actual.isDisplayed();
    }

    public boolean isMacBooksInComparisonList(String notebookName) throws InterruptedException {
        Log4Test.info("Find Mac Book in list " + notebookName);
        List<WebElement> listOfElements = elementsAreLocated(getLocator("comparisonListElements"));

        for (int i=0;i<listOfElements.size();i++){
            Log4Test.test(listOfElements.get(i).getText());
            //Log4Test.test("Size:" + listOfElements.size() + " and i element: " + notebookName);
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
