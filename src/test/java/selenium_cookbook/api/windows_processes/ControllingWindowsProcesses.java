package selenium_cookbook.api.windows_processes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ControllingWindowsProcesses {

    WebDriver driver;
    ControllingWindowsProcesses a;

    @BeforeMethod
    public void setUp() {

        driver = new FirefoxDriver();
        driver.get("http://www.nngroup.com/articles/checkboxes-vs-radio-buttons/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {


    }

    @Test
    public void testRadioButtons() {

        try {
            String osname = WindowsUtils.readStringRegistryValue("HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft");

            System.out.printf("%s ", osname);
            System.out.printf("%s ", osname);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



