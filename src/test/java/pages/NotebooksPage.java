package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Log4Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chv on 12.11.2014.
 */
public class NotebooksPage extends TestBase{

    private String URL = "http://rozetka.com.ua/notebooks/c80004/";
    private By notebooksTabActive = By.xpath(".//*[@id='computers-notebooks']/div[@class='m-main-i active']");
    private String manufacturer = ".//*[@name='menu_categories_left']/li[2]/ul/li[%s]";

    public boolean isOpened(){
        return webDriver.getCurrentUrl().equals(URL);
    }

    public boolean isTabActive(){
        return webDriver.findElement(notebooksTabActive).isDisplayed();
    }

    public void verifyManufacturers(){
        List<WebElement> listOfManufacturers =  webDriver.findElements(By.xpath(String.format(manufacturer,1)));
        System.out.println(listOfManufacturers);
        Log4Test.info(listOfManufacturers.toString());
               /* new ArrayList<WebElement>();
        listOfManufacturers.add(webDriver.findElement(By.xpath(manufacturer)));
        WebElement web = webDriver.findElements(By.xpath(manufacturer));

        WebElement www = webDriver.findElement(By.id("1"));*/
        //System.out.println(listOfManufacturers);
    }

    public void findAppleManufacturer(){

    }

    public void openAppleNotebooksPage(){

    }
}
