package page.object;

import org.openqa.selenium.By;

public class SenderReceiverLocators {
    //     Buttons
    public static final By BTN_OF_CONTINUE = By.cssSelector("[gtm='המשך']");
    public static final By BTN_PASSOVER_EVENT = By.xpath("//*[contains(text(), 'חג פסח')]");
    public static final By BTN_OF_CONTINUE_PAY = By.cssSelector("[gtm='המשך לתשלום']");


    //     Text
    public static final By TXT_SUMMARY_HEADER_KEYS = By.cssSelector("span[class^='PartnerDetailsItem-local__key__']");


    //    Table
    public static final String TBL_SELECTED_ACCOUNT = "selectedAccountsDataTable";


    //    Inputs
    public static final By TXTBX_OF_FRIEND_NAME = By.cssSelector("#friendName input");
    public static final By TXTBX_OF_BLESS = By.cssSelector("[data-parsley-group='main']");
    public static final By TXTBX_OF_SEND_EMAIL = By.cssSelector("input[name='email']");
    public static final By TXTBX_OF_SEND_SMS = By.cssSelector("input[name='sms']");
    public static final By TXTBX_OF_UPLOAD_PIC_VID = By.cssSelector(".bm-media-upload input");


    //    Checkbox
    public static final By CHBOX_ACCOUNTS_CHECKBOX = By.className("checkboxSearch");


    //    Tabs
    public static final By TAB_CONFIGURE_ORDER = By.id("initial-step-container");


    //    Radio button
    public static final By RBT_GATEWAY_TOTAL_THROUGHPUT = By.cssSelector("#gatewayThroughputRadio svg");


    //     Dropdown List
    public static final By DDL_OF_EVENT = By.className("selected-name");
    public static final By DDL_SELECT_PARTNER = By.id("select-partner");


    //    Popup
    public static final By POPUP_SESSION_LOCATION_ERR = By.className("errorButtonHeader");


    //    Chips
    public static final By CHIP_FILTER_BY_ALL_CHIPS = By.cssSelector("[id^='filter-by-']");


    //    Icons
    public static final By ICON_EMAIL = By.cssSelector("[gtm='method-email']");
    public static final By ICON_SMS = By.cssSelector("[gtm='method-sms']");


    //    Form
    public static final By FORM_LOGIN = By.id("login_form");
}
