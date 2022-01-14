package infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class DriverUtils {
    private static WebDriver driver;
    private static final String path = System.getProperty("user.dir") + File.separator + "drivers" + File.separator;

    public static WebDriver getDriver(String browser) {
        driver = setBrowser(browser);
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver setBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.out.println("Starting " + browser + " Browser");
            System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", path + "geckodriver.exe");
            driver = new FirefoxDriver();
        }

        return driver;
    }
}
