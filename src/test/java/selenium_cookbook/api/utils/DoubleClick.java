package selenium_cookbook.api.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class DoubleClick {

    WebDriver driver = new FirefoxDriver();

    @BeforeMethod
    public void setUp() {

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.get("http://dl.dropboxusercontent.com/u/55228056/DoubleClickDemo.html");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testDoubleClick() throws Exception {

        WebElement message = driver.findElement(By.id("message"));

        //Verify color is Blue
        assertEquals("rgba(0, 0, 255, 1)", message.getCssValue("background-color").toString());

        System.out.print(message.getAttribute("align"));

        Actions builder = new Actions(driver);

        builder.doubleClick(message).build().perform();


        try {

//              driver = new Augmenter().augment(driver);

            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(srcFile, new File("c:\\tmp\\practice2.png"));

        } catch (Exception e) {
            e.printStackTrace();

            System.out.print(message.getAttribute("namespaceURI"));

            //Verify Color is Yellow

            assertEquals("rgba(255, 255, 0, 1)", message.getCssValue("background-color").toString());

            driver.close();
        }
    }
}
