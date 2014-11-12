package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ui_tests.TestData;

import java.util.concurrent.TimeUnit;

/**
 * Created by chv on 12.11.2014.
 */
public class TestBase {
    protected static WebDriver webDriver;
    protected static WebDriverWait wait;

    @BeforeSuite
    public static void setUp(){

        webDriver = WebDriverFactory.getWebDriver(TestData.BROWSER_NAME);
        wait = new WebDriverWait(webDriver, 30);

        webDriver.manage().window().maximize();

        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown(){

        webDriver.quit();
    }

}
