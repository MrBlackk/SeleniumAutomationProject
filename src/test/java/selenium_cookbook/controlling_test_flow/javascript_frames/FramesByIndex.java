package selenium_cookbook.controlling_test_flow.javascript_frames;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Walker
 * Date: 8/12/13
 * Time: 1:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class FramesByIndex {

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

        driver.switchTo().frame(0);

        WebElement whitePage = driver.findElement(By.linkText("White Page"));

        assertTrue(whitePage.getText().equals("White Page"));

        driver.switchTo().defaultContent();

        assertTrue(driver.getTitle().equals("Frameset Example Title (Replace this section with your own title)"));

    }
}