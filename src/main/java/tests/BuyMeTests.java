package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import page.object.*;
import reports.ExtentReport;

import java.util.List;

/**
 * tests of buy me app
 */
public class BuyMeTests {
    private WebDriver driver;
    private String url;
    private ExtentReports extentReports;
    public BasePage basePage = new BasePage();

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browser, String url) {
        this.driver = basePage.getDriver(browser);
        this.url = basePage.getUrl(url);
        this.extentReports = ExtentReport.getReportInstance();

    }

    @Test(priority = 1)
    public void testNewRegistration() throws InterruptedException {
        ExtentTest test = extentReports.createTest("testNewRegistration", "Test Description");
        test.log(Status.INFO, "Test New Registration Start");
        basePage.navigate();
        test.log(Status.INFO, "The Navigate To " + url + " Success");
        basePage.click(RegistrationLocators.BTN_SIGN_IN_REGISTRATION);
        basePage.click(RegistrationLocators.BTN_FOR_REGISTRATION);
        basePage.sendKeys(RegistrationLocators.TXT_FIRST_NAME, "Nadya");
        basePage.sendKeys(RegistrationLocators.TXTBX_EMAIL_FIELD_IN_SIGN_IN, "nadyad972@gmail.com");
        basePage.sendKeys(RegistrationLocators.TXTBX_PASSWORD_IN_SIGN_IN, "Nadyad123!");
        basePage.sendKeys(RegistrationLocators.TXT_VERIFY_PASSWORD, "Nadyad123!");
        List<WebElement> registrationFields = basePage.getWebElements(
                RegistrationLocators.TXT_VERIFY_REGISTRATION_FIELD, 10);
        Assert.assertEquals(registrationFields.size(), 4);
        basePage.click(RegistrationLocators.BTN_REGISTER_TO_BUY_ME);
        Assert.assertTrue(basePage.waitForElementPresence(RegistrationLocators.BTN_SIGN_IN_REGISTRATION, 10), "The Registration Failed");
        test.log(Status.PASS, "The Test New Registration Pass");
    }

    @Test(priority = 2)
    public void testHomeScreen() {
        ExtentTest test = extentReports.createTest("testHomeScreen", "Test Description");
        test.log(Status.INFO, "Test Home Screen Start");
        basePage.navigate();
        basePage.click(RegistrationLocators.BTN_SIGN_IN_REGISTRATION);
        basePage.sendKeys(RegistrationLocators.TXTBX_EMAIL_FIELD_IN_SIGN_IN, "nadyad972@gmail.com");
        basePage.sendKeys(RegistrationLocators.TXTBX_PASSWORD_IN_SIGN_IN, "Nadyad123!");
        basePage.click(RegistrationLocators.BTN_ENTER_TO_BUY_ME);
        basePage.click(HomeLocators.DDL_MY_AMOUNT);
        basePage.click(HomeLocators.BTN_PRICE_UNTIL_99);
        basePage.click(HomeLocators.DDL_IN_AREA);
        basePage.click(HomeLocators.BTN_CENTER_AREA);
        basePage.click(HomeLocators.DDL_GIFT_CATEGORY);
        basePage.click(HomeLocators.BTN_GIFT_TO_HOME);
        basePage.click(HomeLocators.BTN_FIND_ME_GIFT);
        String expectedBusinessUrl = "https://buyme.co.il/search?budget=1&category=204&region=11";
        basePage.validateUrl(expectedBusinessUrl);
        test.log(Status.PASS, "The Test Home Screen Pass");

    }

    @Test(dependsOnMethods = "testHomeScreen")
    public void testPickBusiness() {
        ExtentTest test = extentReports.createTest("testPickBusiness", "Test Description");
        test.log(Status.INFO, "Test Pick Business Start");
        basePage.click(PickBusinessLocators.BTN_PICK_BUSINESS_BUY_ME_TO_DOOR);
        basePage.sendKeys(PickBusinessLocators.TXTBX_ENTER_AMOUNT_IN_CARD_BUSINESS, "50");
        basePage.click(PickBusinessLocators.BTN_CHOOSE);
        Assert.assertTrue(basePage.waitForElement(SenderReceiverLocators.TXTBX_OF_FRIEND_NAME, 10,
                ExpectedConditions.visibilityOfElementLocated(SenderReceiverLocators.TXTBX_OF_FRIEND_NAME)),
                "Failed To Choose Business");
        test.log(Status.PASS, "The Test Pick Business Pass");

    }

    @Test(dependsOnMethods = {"testHomeScreen", "testPickBusiness"})
    public void testSenderReceiver() {
        ExtentTest test = extentReports.createTest("testSenderReceiver", "Test Description");
        test.log(Status.INFO, "Test Sender Receiver Start");
        basePage.sendKeys(SenderReceiverLocators.TXTBX_OF_FRIEND_NAME, "Daniel");
        basePage.click(SenderReceiverLocators.DDL_OF_EVENT);
        basePage.click(SenderReceiverLocators.BTN_PASSOVER_EVENT);
        basePage.sendKeys(SenderReceiverLocators.TXTBX_OF_BLESS, "Happy Passover From The Best Automation Course");
        WebElement uploadPhoto = driver.findElement(SenderReceiverLocators.TXTBX_OF_UPLOAD_PIC_VID);
        uploadPhoto.sendKeys("C:\\Users\\neria\\Buy-Me\\src\\main\\java\\attachment\\happy_passover.png");
        basePage.click(SenderReceiverLocators.BTN_OF_CONTINUE);
        basePage.click(SenderReceiverLocators.ICON_EMAIL);
        basePage.sendKeys(SenderReceiverLocators.TXTBX_OF_SEND_EMAIL, "nadyad972@gmail.com");
        basePage.click(SenderReceiverLocators.BTN_OF_CONTINUE_PAY);
        test.log(Status.PASS, "The Test Sender Receiver Pass");

    }

    @AfterClass
    public void tearDown() {
        driver.close();
        extentReports.flush();
    }

}
