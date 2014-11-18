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

/**
 * Created with IntelliJ IDEA.
 * User: Walker
 * Date: 8/12/13
 * Time: 1:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class PromtAlertBox {

    static {
        System.setProperty("webdriver.chrome.driver", WebDriverFactory.class.getClassLoader().getResource("drivers/windows/chromedriver.exe").getPath());
    }
    WebDriver driver = new ChromeDriver();
    //WebDriver driver = new FirefoxDriver();

    @BeforeMethod
    public void startUp() {

        driver.get("http://www.quackit.com/javascript/codes/javascript_prompt.cfm");
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

        WebElement alertBoxButton = driver.findElement(By.cssSelector(".result>form>input"));

        WebElement advertisment = driver.findElement(By.xpath(".//*[@id='at4m-dock-toggle']"));

        if (advertisment.isDisplayed()){
            System.out.println("advertisment clicked");
            advertisment.click();
            Thread.sleep(3000);
        }


        alertBoxButton.click();

        Alert alert = driver.switchTo().alert();

        alert.sendKeys("Sergii");

        alert.accept();

        Alert alert2 = driver.switchTo().alert();

        assertTrue(alert2.getText().contains("Sergii"));
    }
}
