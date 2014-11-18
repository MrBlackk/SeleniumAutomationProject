package selenium_cookbook.controlling_test_flow.javascript_alert;

import core.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: Walker
 * Date: 8/12/13
 * Time: 1:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class ConfirmAlertBox {
    static {
        System.setProperty("webdriver.chrome.driver", WebDriverFactory.class.getClassLoader().getResource("drivers/windows/chromedriver.exe").getPath());
    }
    WebDriver driver = new ChromeDriver();
    //WebDriver driver = new FirefoxDriver();

    @BeforeMethod
    public void startUp() {

        driver.get("http://www.quackit.com/javascript/codes/javascript_confirm.cfm");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//
//    }


    @Test
    public void testWindowPopupUsingTitle() throws InterruptedException {

        WebElement alertBoxButton = driver.findElement(By.cssSelector(".result>input"));
        WebElement advertisment = driver.findElement(By.xpath(".//*[@id='at4m-dock-toggle']"));

        if (advertisment.isDisplayed()){
            System.out.println("advertisment clicked");
            advertisment.click();
            Thread.sleep(3000);
        }
        alertBoxButton.click();

        Alert alert = driver.switchTo().alert();


        if (alert.getText().equals("Did you really mean to click the button?")) {
            //alert.dismiss();
            assertTrue(true);
        } else {
            fail("No, this is not you want");
        }


    }

}

