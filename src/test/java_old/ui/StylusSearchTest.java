package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StylusSearchTest {
    WebDriver driver;
    private static final String SPEC_TABLE_TR_TD = ".//*[@id='col1_content']/div[4]/div[1]/div[5]/table/tbody/tr[%s]/td[%s]";

    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://stylus.com.ua/");
        Assert.assertEquals(driver.getCurrentUrl().contains("http://stylus.com.ua/"),true);
    }

    @Test
    public void searchSonyTest(){
        WebElement searchField = driver.findElement(By.id("search_text"));
        searchField.sendKeys("Sony Z2");

        WebElement findButton = driver.findElement(By.id("button"));
        findButton.click();
        //searchField.sendKeys(Keys.ENTER);

        WebElement firstElement = driver.findElement(By.xpath(".//*[@id='col1_content']/table[2]/tbody/tr[1]/td[1]/table/tbody/tr/td[2]/h4/a"));
        Assert.assertEquals(firstElement.getText().toString().contains("Sony Xperia Z2"), true);
        firstElement.click();

        //WebElement pageHeading = driver.findElement(By.xpath(".//*[@id='col1_content']/div[4]/h3/a/span"));
        WebElement pageHeading = driver.findElement(By.xpath(".//*[@itemprop='name']"));
        Assert.assertEquals(pageHeading.getText().contains("Sony Xperia Z2"), true);

        WebElement specificationTab = driver.findElement(By.xpath(".//*[@id='menulink']/ul/li[1]/a/span"));
        specificationTab.click();

        WebElement programFunctions = driver.findElement(By.xpath(String.format(SPEC_TABLE_TR_TD,21,1)));
        Assert.assertEquals(programFunctions.getText().toString().contains("Программные функции"), true);

        WebElement internetAccessPropertyName = driver.findElement(By.xpath(String.format(SPEC_TABLE_TR_TD,29,1)));
        Assert.assertEquals(internetAccessPropertyName.getText().toString().contains("Интернет-доступ"), true);

        WebElement internetAccessPropertyValue = driver.findElement(By.xpath(String.format(SPEC_TABLE_TR_TD,29,2)));
        Assert.assertEquals(internetAccessPropertyValue.getText().toString().contains("HTML, HTML5, Adobe Flash, RSS"), true);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
