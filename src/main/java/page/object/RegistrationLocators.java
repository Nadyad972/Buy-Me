package page.object;

import org.openqa.selenium.By;

public class RegistrationLocators {
    //     Buttons
    public static final By BTN_SIGN_IN_REGISTRATION = By.className("seperator-link");
    public static final By BTN_FOR_REGISTRATION = By.className("text-link");
    public static final By BTN_ENTER_TO_BUY_ME = By.cssSelector("[gtm='כניסה ל-BUYME']");
    public static final By BTN_REGISTER_TO_BUY_ME = By.cssSelector("[gtm='הרשמה ל-BUYME']");


    //     Text
    public static final By TXT_VERIFY_REGISTRATION_FIELD = By.className("filled");
    public static final By TXT_FIRST_NAME = By.cssSelector("[placeholder='שם פרטי']");
    public static final By TXT_VERIFY_PASSWORD = By.cssSelector("[placeholder='אימות סיסמה']");


    //    Table
//    public static final String TBL_SELECTED_ACCOUNT = "selectedAccountsDataTable";


    //    Inputs
    public static final By TXTBX_EMAIL_FIELD_IN_SIGN_IN = By.cssSelector("input[type='email']");
    public static final By TXTBX_PASSWORD_IN_SIGN_IN = By.cssSelector("input[type='password']");


    //    Checkbox
//    public static final By CHBOX_ACCOUNTS_CHECKBOX = By.className("checkboxSearch");


    //    Tabs
//    public static final By TAB_CONFIGURE_ORDER = By.id("initial-step-container");


    //    Radio button
//    public static final By RBT_GATEWAY_TOTAL_THROUGHPUT = By.cssSelector("#gatewayThroughputRadio svg");


    //     Dropdown List
//    public static final By DDL_MY_ACCOUNT = By.xpath("//*[contains(text(), 'החשבון שלי')]");


    //    Popup
//    public static final By POPUP_SESSION_LOCATION_ERR = By.className("errorButtonHeader");


    //    Chips
//    public static final By CHIP_FILTER_BY_ALL_CHIPS = By.cssSelector("[id^='filter-by-']");


    //    Icons
//    public static final By ICON_STATUS_COMMENT = By.id("order-status-text");


    //    Form
//    public static final By FORM_LOGIN= By.id("login_form");
}
