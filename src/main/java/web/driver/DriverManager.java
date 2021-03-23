package web.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static WebDriver driver;
    private static WebDriverWait wait;
    public static WebDriver getDriverInstance(String browser){
        if(browser.equalsIgnoreCase("chrome")) {
            System.out.println("You have selected " + browser);
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\neria\\Buy-Me\\src\\main\\java\\web\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        }
        else {
            System.out.println("You have not selected chrome, FireFox Please Wakeup");
        }

        return driver;
    }
}
