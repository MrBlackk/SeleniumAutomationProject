package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Log4Test;

/**
 * Created by chv on 12.11.2014.
 */
public class RozetkaWelcomePage extends GeneralPage {

    public void openNotebooksPage(){
        //Log4Test.test("openNotebooksPage");
        Log4Test.info("Click Ноутбуки under Ноутбуки, планшеты и компьютеры");
        waitForPageLoaded();
        elementIsLocated(getLocator("notebookPage")).click();
    }
}
