package tests;

import infra.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CalcPage;


/**
 * tests of web calculator
 */
public class WebCalcTests {

    private static WebDriver WEB_DRIVER;
    private CalcPage calc;

    @Parameters({"browser"})
    @BeforeMethod
    public void startBrowser(String browser) {
        WEB_DRIVER = DriverUtils.getDriver(browser);
        calc = new CalcPage(WEB_DRIVER);
    }

    @Test(testName = "Sum Formula Test")  // priority =
    public void testSumPlus() {
        String sumDigitsFormula = "2+3";
        calc.setFormula(sumDigitsFormula);
        String resultFormula = "5";
        Assert.assertTrue(calc.validateFormulaHistory(resultFormula), "Sum Formula Test Failed");
    }

    @Test(testName = "Minus Formula Test")
    public void testSumMinus() {
        String minusDigitsFormula = "10-2";
        calc.setFormula(minusDigitsFormula);
        String resultFormula = "8";
        Assert.assertTrue(calc.validateFormulaHistory(resultFormula), "Minus Formula Test Failed");

    }

    @Test(testName = "Order Action Formula Test")
    public void testOrderDigitsFormula() {
        String minusDigitsFormula = "(10 - 2) * 2";
        calc.setFormula(minusDigitsFormula);
        String resultFormula = "!=20";
        Assert.assertTrue(calc.validateFormulaHistory(resultFormula), "Order Action Formula Test Failed");

    }

    @Test(testName = "Sinus Formula Test")
    public void testSinusFormula() {
        String minusDigitsFormula = "sin(30)";
        calc.setFormula(minusDigitsFormula);
        String resultFormula = "0.5";
        Assert.assertTrue(calc.validateFormulaHistory(resultFormula), "Sinus Formula Test Failed");

    }

    @AfterMethod
    public void closeBrowser() {
        WEB_DRIVER.quit();

    }


}
