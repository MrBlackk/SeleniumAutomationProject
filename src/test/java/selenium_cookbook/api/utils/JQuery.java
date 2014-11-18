package selenium_cookbook.api.utils;

import core.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class JQuery {

    static {
        try {
            //System.setProperty("webdriver.ie.driver", WebDriverFactory.class.getClassLoader().getResource("iedriver.exe").getPath());
            System.setProperty("webdriver.chrome.driver", WebDriverFactory.class.getClassLoader().getResource("drivers/windows/chromedriver.exe").getPath());
        }
        catch (Exception e){
            System.out.println("Cannot launch Firefox or Chrome driver \n" + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testCheckBoxesContent() {


        WebDriver driver = new ChromeDriver();
        // WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        driver.get("http://dl.dropbox.com/u/55228056/Locators.html");

        List<String> checked = Arrays.asList("user128_admin", "user220_browser");
        //List<String> checked = Arrays.asList(new String[]{"user128_admin", "user220_browser"});

        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> elements = (List<WebElement>) js.executeScript("return jQuery.find(':checked')");

        for (WebElement element : elements) {
            System.out.println(element.getAttribute("id"));
            assertTrue(checked.contains(element.getAttribute("id")));
        }

        WebElement check = driver.findElement(By.id("user128_cm"));
        check.click();

        List<WebElement> elements2 = (List<WebElement>) js.executeScript("return jQuery.find(':checked')");
        List<String> checked2 = Arrays.asList("user128_admin", "user220_browser","user128_cm");

        for (WebElement element : elements2) {
            System.out.println(element.getAttribute("id"));
            assertTrue(checked2.contains(element.getAttribute("id")));
        }


    }


}
