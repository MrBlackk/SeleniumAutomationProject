package pages;

import core.TestBase;
import org.openqa.selenium.By;

/**
 * Created by chv on 12.11.2014.
 */
public class AppleNotebooksPage extends TestBase{

    private String URL = "http://rozetka.com.ua/notebooks/apple/c80004/v069/";
    private By dropLink = By.name("drop_link");
    private By expensiveDropDown = By.xpath(".//*[@id='sort_view']/div/div/ul/li[2]");

    //private String macBookProRetina = ""

    public boolean isOpened(){
        return webDriver.getCurrentUrl().equals(URL);
    }

    public void selectSortExpensive(){
        webDriver.findElement(dropLink).click();
        webDriver.findElement(expensiveDropDown).click();
    }

    public void isMacBookPresent(String notebookName){

    }

    public void selectCompareCheckbox(String notebookName){

    }

    public void isComparisonListShown(){

    }

    public void isMacBooksInComparisonList(String notebookName){

    }

    public void clickCompare(){

    }
}
