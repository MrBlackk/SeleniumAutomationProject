package selenium_cookbook.api.windows_processes;

import com.sun.deploy.util.WinRegistry;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import core.WebDriverFactory;

public class ControllingWindowsProcesses {
    static {
        try {
            System.setProperty("webdriver.chrome.driver", WebDriverFactory.class.getClassLoader().getResource("drivers/windows/chromedriver.exe").getPath());
        }
        catch (Exception e){
            System.out.println("Cannot launch Firefox or Chrome driver \n" + e.getMessage());
        }
    }

    WebDriver driver;
    ControllingWindowsProcesses a;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("http://www.nngroup.com/articles/checkboxes-vs-radio-buttons/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {


    }

    @Test
    public void testRadioButtons() {

        try {
            String osname = WindowsUtils.readStringRegistryValue("HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion");

//            String value = WinRegistry.readString(
//                    WinRegistry.HKEY_LOCAL_MACHINE,                             //HKEY
//                    "SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion",           //Key
//                    "ProductName");                                              //ValueName
//            System.out.println("Windows Distribution = " + value);

            System.out.printf("%s ", osname);
            System.out.printf("%s ", osname);
        } catch (Exception e) {
            System.out.println("catch");
            e.printStackTrace();
        }
    }
}



