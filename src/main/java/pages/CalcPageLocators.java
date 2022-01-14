package pages;

import org.openqa.selenium.By;

public class CalcPageLocators {

    //    Button
    public static final By CALC_BTN = By.id("BtnCalc");
    public static final By SINUS_BTN = By.id("BtnSin");
    public static final By INPUT_HELPER_BTN = By.id("inputhelper");
    public static final By OPEN_HISTORY_FORMULA_FRAME = By.id("hist");
    public static final By BTN_CLEAR_HISTORY = By.id("clearhistory");

    //    Input
    public static final By CALC_INPUT = By.id("input");
    //    Label
    public static final By RESULT_LABEL = By.id("result");
    public static final By HISTORY_FORMULA_DATA = By.cssSelector("#histframe > ul > li");

    //    Container
    public static final By CNT_HISTORY_FRAME = By.xpath("//*[contains(@id, 'hist') and contains(@class, 'open')]");

}
