package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Log4Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chv on 12.11.2014.
 */
public class NotebooksPage extends TestBase{

    private String URL = "http://rozetka.com.ua/notebooks/c80004/";
    private By notebooksTabActive = By.xpath(".//*[@id='computers-notebooks']/div[@class='m-main-i active']");
    private String manufacturer = ".//*[@name='menu_categories_left']/li[2]/ul/li/a";

    public boolean isOpened(){
        return webDriver.getCurrentUrl().equals(URL);
    }

    public boolean isTabActive(){
        return webDriver.findElement(notebooksTabActive).isDisplayed();
    }

    public boolean verifyManufacturers(){
        List<WebElement> listOfManufacturers =  webDriver.findElements(By.xpath(manufacturer));
        //ToDo: move to TestData
        List<String> listString = Arrays.asList("Acer", "Apple", "Asus", "Dell", "Fujitsu", "HP (Hewlett Packard)", "Lenovo", "MSI", "Sony");

        for (int i=0;i<listOfManufacturers.size();i++){
            Log4Test.info(listOfManufacturers.get(i).getText());
            Log4Test.info(listString.get(i));
            if (!listOfManufacturers.get(i).getText().equals(listString.get(i))){
                Log4Test.info("false");
                return false;
            }
        }
        Log4Test.info("true");
        return true;
    }

    public void findAppleManufacturerAndClick(){
        List<WebElement> listOfManufacturers =  webDriver.findElements(By.xpath(manufacturer));
        String apple = "Apple";

        for (int i=0;i<listOfManufacturers.size();i++){
            Log4Test.info(listOfManufacturers.get(i).getText());
            Log4Test.info(apple);
            if (listOfManufacturers.get(i).getText().equals(apple)){
                Log4Test.info("FIND!!!!!!!!!!!");
                listOfManufacturers.get(i).click();
                break;
            }
        }
    }

}
