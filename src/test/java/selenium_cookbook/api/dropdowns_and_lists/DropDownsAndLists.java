package selenium_cookbook.api.dropdowns_and_lists;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;

public class DropDownsAndLists {
    WebDriver driver = new FirefoxDriver();

    @BeforeMethod
    public void setUp() {

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testDropdown() {


        WebElement iFrame = driver.findElement(By.id("iframeResult"));

        driver.switchTo().frame(iFrame);

        //Get the Dropdown as a Select using its name attribute
        Select make = new Select(driver.findElement(By.xpath("html/body/select")));

        System.out.printf("%s ", make.getOptions().size());

        for (WebElement m : make.getOptions()) {
            System.out.print(m.getText());
        }

        //Verify Dropdown does not support multiple selection
        assertFalse(make.isMultiple());

        Assert.assertEquals(4, make.getOptions().size());

        make.selectByVisibleText("Volvo");

        Assert.assertEquals("Volvo", make.getFirstSelectedOption().getText());
//
        make.selectByValue("opel");

        Assert.assertEquals("Opel", make.getFirstSelectedOption().getText());
//
        make.selectByIndex(2);
        Assert.assertEquals("Opel", make.getFirstSelectedOption().getText());

    }
}
