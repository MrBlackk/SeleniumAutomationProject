package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui_tests.TestData;
import utilities.Log4Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chv on 12.11.2014.
 */
public class NotebooksPage extends GeneralPage{

    private String URL = "http://rozetka.com.ua/notebooks/c80004/";
    private By notebooksTabActive = By.xpath(".//*[@id='computers-notebooks']/div[@class='m-main-i active']");
    private String manufacturer = ".//*[@name='menu_categories_left']/li[2]/ul/li/a";

    /*public boolean isOpened(){
        return webDriver.getCurrentUrl().equals(URL);
    }*/

    public boolean isTabActive(){
        return webDriver.findElement(notebooksTabActive).isDisplayed();
    }

    public boolean verifyManufacturers(){
        Log4Test.info("Verify that all 9 manufactures are present");
        List<WebElement> listOfManufacturers =  webDriver.findElements(By.xpath(manufacturer));
        List<String> listString = TestData.MANUFACTURERS_LIST;

        for (int i=0;i<listOfManufacturers.size();i++){
            if (!listOfManufacturers.get(i).getText().equals(listString.get(i))){
                return false;
            }
        }
        return true;
    }

    public void findAppleManufacturerAndClick(){
        Log4Test.info("Find and click Apple manufacturer");
        List<WebElement> listOfManufacturers =  webDriver.findElements(By.xpath(manufacturer));

        for (int i=0;i<listOfManufacturers.size();i++){
            if (listOfManufacturers.get(i).getText().equals("Apple")){
                listOfManufacturers.get(i).click();
                break;
            }
        }
    }

}
