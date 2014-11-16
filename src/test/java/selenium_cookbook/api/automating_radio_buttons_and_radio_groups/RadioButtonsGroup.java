package selenium_cookbook.api.automating_radio_buttons_and_radio_groups;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class RadioButtonsGroup {

    WebDriver driver = new FirefoxDriver();

    @BeforeMethod
    public void setUp() throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        System.out.print(driver.manage().window().getPosition());

        driver.get("http://www.nngroup.com/articles/checkboxes-vs-radio-buttons/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,1600)", "");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testRadioButtonsGroup() {


        List<WebElement> rdbtns = driver.findElements(By.cssSelector("form>input"));

        for (WebElement type : rdbtns) {

            if (type.getAttribute("id").equals("Seven")) {

                if (!type.isSelected()) {
                    type.click();

                    assertTrue(type.isSelected());
                }
            }
        }

    }
}
