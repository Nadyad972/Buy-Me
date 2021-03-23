package page.object;

import org.openqa.selenium.By;

public class HomeLocators {
    //     Buttons
    public static final By BTN_PRICE_UNTIL_99 = By.cssSelector("li[data-option-array-index='1']");
    public static final By BTN_CENTER_AREA = By.cssSelector("li[data-option-array-index='2']");
    public static final By BTN_GIFT_TO_HOME = By.cssSelector("li[data-option-array-index='1']");
    public static final By BTN_FIND_ME_GIFT = By.className("search");


    //     Text
    public static final By TXT_SUMMARY_HEADER_KEYS = By.cssSelector("span[class^='PartnerDetailsItem-local__key__']");
    public static final By TXT_SUMMARY_HEADER_VALUES = By.cssSelector("div[class^='PartnerDetailsItem-local__value__']");


    //    Table
    public static final String TBL_SELECTED_ACCOUNT = "selectedAccountsDataTable";


    //    Inputs
    public static final By TXTBX_SEARCH_SALES_FORCE = By.cssSelector("[placeholder='Search Salesforce']");


    //    Checkbox
    public static final By CHBOX_ACCOUNTS_CHECKBOX = By.className("checkboxSearch");


    //    Tabs
    public static final By TAB_CONFIGURE_ORDER = By.id("initial-step-container");


    //    Radio button
    public static final By RBT_GATEWAY_TOTAL_THROUGHPUT = By.cssSelector("#gatewayThroughputRadio svg");


    //     Dropdown List
    public static final By DDL_MY_AMOUNT = By.xpath("//span[contains(text(), 'סכום')]");
    public static final By DDL_IN_AREA = By.xpath("//span[contains(text(), 'אזור')]");
    public static final By DDL_GIFT_CATEGORY = By.xpath("//span[contains(text(), 'קטגוריה')]");


    //    Popup
    public static final By POPUP_SESSION_LOCATION_ERR = By.className("errorButtonHeader");


    //    Chips
    public static final By CHIP_FILTER_BY_ALL_CHIPS = By.cssSelector("[id^='filter-by-']");


    //    Icons
    public static final By ICON_STATUS_COMMENT = By.id("order-status-text");


    //    Form
    public static final By FORM_LOGIN= By.id("login_form");
}
