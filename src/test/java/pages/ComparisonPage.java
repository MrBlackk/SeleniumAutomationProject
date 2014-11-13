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
        return webDriver.findElement(comparisonTitle).getText().equals("Сравнение товаров");
    }

    public boolean isMacBooksPresent(String notebookName){
        List<WebElement> listOfCompared = webDriver.findElements(comparisonList);
        for (int i=0;i<listOfCompared.size();i++){
            Log4Test.info(listOfCompared.get(i).getText());
            if (listOfCompared.get(i).getText().contains(notebookName)){
                Log4Test.info("FIND!!!!!!!!!!! COMPARE PAGE");
                return true;
            }
        }
        return false;
    }

}
