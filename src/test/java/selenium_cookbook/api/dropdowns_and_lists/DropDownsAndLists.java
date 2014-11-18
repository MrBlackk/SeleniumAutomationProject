package selenium_cookbook.api.dropdowns_and_lists;

import core.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;

public class DropDownsAndLists {
    static {
        try {
            //System.setProperty("webdriver.ie.driver", WebDriverFactory.class.getClassLoader().getResource("iedriver.exe").getPath());
            System.setProperty("webdriver.chrome.driver", WebDriverFactory.class.getClassLoader().getResource("drivers/windows/chromedriver.exe").getPath());
        }
        catch (Exception e){
            System.out.println("Cannot launch Firefox or Chrome driver \n" + e.getMessage());
        }
    }
    WebDriver driver = new ChromeDriver();


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
        Select dropDown = new Select(driver.findElement(By.xpath("html/body/select")));

        System.out.printf("Drop down size: %s ", dropDown.getOptions().size());

        System.out.println();
        System.out.println("Elements: ");
        for (WebElement m : dropDown.getOptions()) {
            System.out.print(m.getText() + " ");
        }

        //Verify Dropdown does not support multiple selection
        assertFalse(dropDown.isMultiple());

        Assert.assertEquals(4, dropDown.getOptions().size());

        dropDown.selectByVisibleText("Saab");

        Assert.assertEquals("Saab", dropDown.getFirstSelectedOption().getText());

        /*//test
        dropDown.selectByValue("opel");
        Assert.assertEquals("Opel", dropDown.getFirstSelectedOption().getText());

        dropDown.selectByIndex(3);
        //test*/
//
        dropDown.selectByValue("opel");

        Assert.assertEquals("Opel", dropDown.getFirstSelectedOption().getText());
//
        dropDown.selectByIndex(2);
        Assert.assertEquals("Opel", dropDown.getFirstSelectedOption().getText());

    }
}
