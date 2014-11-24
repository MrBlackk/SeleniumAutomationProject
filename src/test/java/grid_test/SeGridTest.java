package grid_test;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created by c267 on 24.11.2014.
 */
public class SeGridTest {

    WebDriver driver = null;

    private StringBuffer verificationErrors = new StringBuffer();

    @Parameters({"platform","browser","version","url"})
    @BeforeTest(alwaysRun = true)
    public void setUp(String platform, String browser, String version, String url) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        //Platforms:
        if (platform.equalsIgnoreCase("Windows"))
            capabilities.setPlatform(Platform.WINDOWS);

//        if (platform.equalsIgnoreCase("MAC"))
//            capabilities.setPlatform(Platform.MAC);
//        if (platform.equalsIgnoreCase("ANDROID"))
//            capabilities.setPlatform(Platform.ANDROID);
//        if (platform.equalsIgnoreCase("Windows"))
//            capabilities.setPlatform(Platform.WINDOWS);

        if (browser.equalsIgnoreCase("Firefox"))
            capabilities = DesiredCapabilities.firefox();

//        if (browser.equalsIgnoreCase("Firefox"))
//            capabilities = DesiredCapabilities.firefox();

        capabilities.setVersion(version);

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);

        driver.get(url);
    }

    @Test(description="Test Bmi Calculator")
    public void testBmiCalculator() throws InterruptedException {

        WebElement height = driver.findElement(By.name("heightCMS"));
        height.sendKeys("181");
        WebElement weight = driver.findElement(By.name("weightKg"));
        weight.sendKeys("80");

        WebElement calculateButton = driver.findElement(By.id("Calculate"));
        calculateButton.click();
        try {
            WebElement bmi = driver.findElement(By.name("bmi"));
            assertEquals(bmi.getAttribute("value"),"24.4");
            WebElement bmi_category = driver.findElement(By.name("bmi_category"));
            assertEquals(bmi_category.getAttribute("value"),"Normal");
        } catch (Error e) {
//Capture and append Exceptions/Errors
            verificationErrors.append(e.toString());
        }
    }
    @AfterTest
    public void afterTest() {
//Close the browser
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }

    }
}
