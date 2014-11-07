package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by c267 on 07.11.2014.
 */
public class GoogleSearchTest {
    WebDriver driver;

    //Preconditions
    @BeforeClass
    public void setUp(){
        //initializes browser
        driver = new FirefoxDriver();

        //driver = new ChromeDriver(); //Path

        //sets implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Maximizes a window size
        driver.manage().window().maximize();

        //opens an url
        driver.get("https://www.google.com.ua");
    }

    @Test
    public void searchTest(){
        //finds an element by name
        WebElement searchField = driver.findElement(By.id("gbqfq"));

        //sends "selenium" text into input field
        searchField.sendKeys("selenium");

        //sends Enter key


        //finds first link with specified result
        WebElement seleniumLink = driver.findElement(By.xpath(".//*[@id='rso']/div[2]/li[1]/div/h3/a"));

        //verify result
        Assert.assertEquals(seleniumLink.getText().toString().contains("Selenium"), true);//getText returns: Selenium - Web Browser Automation
    }

    @AfterClass
    public void tearDown(){
        //closes a browser
        driver.quit();
    }


}
