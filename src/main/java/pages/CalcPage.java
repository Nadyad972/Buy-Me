package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CalcPage extends BasePage {
    private final static String url = "https://web2.0calc.com/";
    private final static String title = "Web 2.0 scientific calculator";


    public CalcPage(WebDriver driver) {
        super(driver, url, title);
        navigate();
        validateTitle();
    }

    public void setFormula(String formula) {
        sendKeys(CalcPageLocators.CALC_INPUT, formula);
        click(CalcPageLocators.CALC_BTN);


    }

    private void openFormulaHistory() {
        if (!isDisplay(CalcPageLocators.CNT_HISTORY_FRAME)) {
            click(CalcPageLocators.OPEN_HISTORY_FORMULA_FRAME);
        }


    }

    public boolean validateFormulaHistory(String expectedFormula) {
        openFormulaHistory();
        List<WebElement> formulaHistory = getWebElements(CalcPageLocators.HISTORY_FORMULA_DATA, 30);
        for (int i = 0; i < formulaHistory.size(); i++) {
            String formula_text = getTexts(CalcPageLocators.HISTORY_FORMULA_DATA, i);
            if (formula_text.contains(expectedFormula)) {
                return true;
            }
        }
        return false;


    }
}
