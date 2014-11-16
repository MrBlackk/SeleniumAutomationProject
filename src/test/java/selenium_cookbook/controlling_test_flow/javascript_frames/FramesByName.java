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
 * Time: 12:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class FramesByName {
    WebDriver driver = new FirefoxDriver();

    @BeforeMethod
    public void startUp() {

        driver.get("http://www.quackit.com/html/templates/frames/frames_example_1.html");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

    @Test
    public void testFramesUsingIdOrName() {

        driver.switchTo().frame("menu");

        WebElement whitePage = driver.findElement(By.linkText("White Page"));
        assertTrue(whitePage.getText().equals("White Page"));

        driver.switchTo().defaultContent();

        driver.switchTo().frame("content");

        WebElement content = driver.findElement(By.cssSelector("h1"));
        assertTrue(content.getText().equals("Content"));

        driver.switchTo().defaultContent();
    }
}
