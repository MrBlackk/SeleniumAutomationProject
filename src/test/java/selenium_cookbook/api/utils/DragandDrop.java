package selenium_cookbook.api.utils;

import core.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class DragandDrop {


    static {
        try {
            //System.setProperty("webdriver.ie.driver", WebDriverFactory.class.getClassLoader().getResource("iedriver.exe").getPath());
            System.setProperty("webdriver.chrome.driver", WebDriverFactory.class.getClassLoader().getResource("drivers/windows/chromedriver.exe").getPath());
        }
        catch (Exception e){
            System.out.println("Cannot launch Firefox or Chrome driver \n" + e.getMessage());
        }
    }
    WebDriver driver = new ChromeDriver();
    // WebDriver driver = new FirefoxDriver();

    @BeforeMethod
    public void setUp() {

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.get("http://dl.dropboxusercontent.com/u/55228056/DragDropDemo.html");
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void testDragDrop() {

        WebElement draggable = driver.findElement(By.id("draggable"));

        WebElement droppable = driver.findElement(By.id("droppable"));

        //Actions builder = new Actions(driver);

        //builder.dragAndDrop(draggable, droppable).build().perform();
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable,droppable).build().perform();

        assertEquals("Dropped!", droppable.getText());
    }
}

