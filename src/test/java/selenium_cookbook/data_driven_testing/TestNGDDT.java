package selenium_cookbook.data_driven_testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class TestNGDDT {

    private static StringBuffer verificationErrors = new StringBuffer();
    WebDriver driver = new FirefoxDriver();

    private WebElement heightCMS, weightKg, Calculate, bmi, bmi_category;

    @BeforeTest
    public void setUp() {

        driver.get("http://dl.dropboxusercontent.com/u/55228056/bmicalculator.html");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);

    }

    @AfterTest
    public void tearDown() {

        driver.close();

    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                new Object[]{"160", "45", "17.6", "Underweight"},
                new Object[]{"168", "70", "24.8", "Normal"},
                new Object[]{"181", "89", "27.2", "Overweight"},
                new Object[]{"178", "100", "31.6", "Obesity"},
        };
    }

    @Test(dataProvider = "testData")
    public void testBMICalculator(String height, String weight, String bmiResult, String bmiCategory) {

        heightCMS.clear();
        heightCMS.sendKeys(height);

        weightKg.clear();
        weightKg.sendKeys(weight);

        Calculate.click();

        try {
            //Get the Bmi element and verify its value using parameterised
            //bmi variable

            assertEquals(bmiResult, bmi.getAttribute("value"));

            //Get the Bmi Category element and verify its value using
            //parameterised bmiCategory variable

            assertEquals(bmiCategory, bmi_category.getAttribute("value"));

        } catch (Error e) {

            //Capture and append Exceptions/Errors
            verificationErrors.append(e.toString());

            System.err.print("Asserts failed" + verificationErrors.toString());
        }
    }
}

