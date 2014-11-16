package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Log4Test;

/**
 * Created by chv on 12.11.2014.
 */
public class RozetkaWelcomePage extends GeneralPage {

    private String URL = "http://rozetka.com.ua/";

    protected By notebooksPage = By.xpath(".//*[@id='head_banner_container']//a[@href='http://rozetka.com.ua/notebooks/c80004/']");


    /*public boolean isOpened(){
        return webDriver.getCurrentUrl().equals(URL);
    }*/


    public void openNotebooksPage(){

        Log4Test.info("Click Ноутбуки under Ноутбуки, планшеты и компьютеры");
        waitForPageLoaded();
        //elementIsLocated(notebooksPage).click();
        elementIsLocated(getLocator("notebookPage")).click(); //object.map.properties
    }
}
