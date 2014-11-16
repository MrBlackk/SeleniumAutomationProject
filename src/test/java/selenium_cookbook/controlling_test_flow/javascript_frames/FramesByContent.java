package selenium_cookbook.controlling_test_flow.javascript_frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Walker
 * Date: 8/12/13
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class FramesByContent {

    WebDriver driver = new FirefoxDriver();

    @BeforeMethod
    public void setUp() {

        driver.get("http://www.quackit.com/html/templates/frames/frames_example_1.html");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {

        driver.close();

    }

    @Test
    public void testFramesByIndex() {

        List<WebElement> frames = driver.findElements(By.tagName("frame2"));

        System.out.println(frames.size());

        for (WebElement frame : frames) {

            driver.switchTo().frame(frame);

            if (driver.getPageSource().contains("Content")) {

                assertTrue(true);

            } else {

                driver.switchTo().defaultContent();
            }
        }

        driver.switchTo().defaultContent();

    }
}


