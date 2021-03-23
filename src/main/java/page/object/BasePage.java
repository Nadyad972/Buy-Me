package page.object;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import web.driver.DriverManager;


import java.io.IOException;
import java.util.List;

@Parameters({"browser", "url"})
public class BasePage {
    private WebDriver driver;
    private String url;

    public WebDriver getDriver(String browser) {
        this.driver = DriverManager.getDriverInstance(browser);
        return driver;

    }

    public String getUrl(String url) {
        this.url = url;
        return url;

    }

    public void navigate() {
        url = getUrl(url);
        driver.get(url);
        validateUrl(url);
    }

    public void validateUrl(String expectedUrl) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 40);
            wait.until(ExpectedConditions.urlToBe(expectedUrl));
        } catch (TimeoutException e) {
            Assert.fail(String.format("Url should be %s, But Actual %S", expectedUrl, driver.getCurrentUrl()), e);
        }
    }

    public void click(By loc) {
        WebElement element = getWebElement(loc, 40, ExpectedConditions.elementToBeClickable(loc));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        element.click();
    }

    public void sendKeys(By loc, String text) {
        WebElement element = getWebElement(loc, 25, ExpectedConditions.elementToBeClickable(loc));
        element.clear();
        element.sendKeys(text);
    }

    public String getTextByIndex(By loc, int index) {
        WebElement element = getWebElements(
                loc, 40).get(index);
        return element.getText();
    }

    public boolean isElementDisplay(By loc) {
        try {
            return driver.findElement(loc).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    void waitForLoader(By loc) {
        try {
            WebDriverWait element = new WebDriverWait(driver, 3);
            element.until(ExpectedConditions.visibilityOfElementLocated(loc));
            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loc));
        } catch (TimeoutException ignored) {

        }
    }

    private WebElement getWebElement(By loc, int timeOut, ExpectedCondition<WebElement> expectedCon) {
        try {
            waitForElement(loc, timeOut, expectedCon);
        } catch (Exception ex) {
            takeScreenShot(loc);
            Assert.fail("Element " + loc + " Not Found - Screenshot Taken");
        }
        return driver.findElement(loc);
    }

    private void takeScreenShot(By loc) {
        String[] locString = String.valueOf(loc).split(" ");
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("C:\\Users\\neria\\Buy-Me\\src\\main\\java\\screenshots\\" + locString[1] + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<WebElement> getWebElements(By loc, int timeOut) {
        waitForElement(loc, timeOut, ExpectedConditions.visibilityOfElementLocated(loc));
        return driver.findElements(loc);
    }

    public boolean waitForElementPresence(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element.isDisplayed();
    }

    public boolean waitForElement(By loc, int timeOut, ExpectedCondition<WebElement> expectedCon) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(expectedCon);
            return true;
        } catch (TimeoutException e) {
            String locString = String.valueOf(loc);
            System.out.println("Element Not Found " + locString);
            takeScreenShot(loc);
            return false;
        }
    }

}

