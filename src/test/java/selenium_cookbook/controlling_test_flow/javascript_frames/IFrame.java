package selenium_cookbook.controlling_test_flow.javascript_frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Walker
 * Date: 8/12/13
 * Time: 2:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class IFrame {

    WebDriver driver = new FirefoxDriver();

    @BeforeMethod
    public void setUp() {

        driver.get("http://www.developphp.com/view_lesson.php?v=141");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {

        driver.close();

    }

    @Test
    public void testIFrame() {

        String originWindow = driver.getWindowHandle();

        WebElement iFrame = driver.findElement(By.name("myiframe"));

        driver.switchTo().frame(iFrame);

        String iFrameWindow = driver.getWindowHandle();

        WebElement developerNetWorkingButton = driver.findElement(By.id("icon_gear"));

        developerNetWorkingButton.click();

        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows)
            if (!allWindows.isEmpty()) {
                driver.switchTo().window(window);
                if (driver.getTitle().contains("Intersect")) {
                    System.out.println(driver.getCurrentUrl());
                    System.out.println(driver.getTitle());
                    System.out.println();
                    driver.close();
                }

            }

        driver.switchTo().window(iFrameWindow);

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());


        assertEquals(driver.getTitle(), "HTML iframe Element");


    }
}
