package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Log4Test;

import java.util.List;

/**
 * Created by chv on 12.11.2014.
 */
public class ComparisonPage extends TestBase{

    private String URL = "http://rozetka.com.ua/computers-notebooks/notebooks/comparison/";
    private By comparisonTitle = By.className("comparison-title");
    private By comparisonList = By.xpath(".//*[@class='comparison-t']/thead/tr[2]/td/div[2]/a");

    public boolean isOpened(){
        return webDriver.getCurrentUrl().contains(URL);
    }

    public boolean isCompareGoodsTextPresent(){
        Log4Test.info("Verify that the page contains Сравнение товаров");
        return webDriver.findElement(comparisonTitle).getText().equals("Сравнение товаров");
    }

    public boolean isMacBooksPresent(String notebookName){
        Log4Test.info("Verify that the page \"Добавить модель should contain Apple MacBook Pro Retina 15\" (Z0PU002JE) Официальная гарантия! and \n" +
                "Apple MacBook Air 11\" (MD712UA/A) Официальная гарантия!");
        List<WebElement> listOfCompared = webDriver.findElements(comparisonList);
        for (int i=0;i<listOfCompared.size();i++){
            if (listOfCompared.get(i).getText().contains(notebookName)){
                return true;
            }
        }
        return false;
    }

}
