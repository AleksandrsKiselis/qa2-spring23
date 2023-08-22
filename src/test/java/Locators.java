import org.openqa.selenium.By;

import java.util.Locale;

public class Locators {
    private final String URL = "https://www.booking.com/";
    private final By BOOKING_LOGO_BTN = By.xpath(".//*[local-name()='svg'][@fill='none']");
    private final By CURRENCY_BTN = By.xpath(".//span[@class='e57ffa4eb5']");
    private final By NOTIFICATIONS_BTN = By.xpath("(.//button[@aria-expanded='false'])[3]");
    private final By AIRPORT_TAXIS = By.id("airport_taxis");
    private final By GENIUS_LEVEL = By.xpath(".//span[@class='d8eab2cf7f a2552429ab']");
    private final By CHECK_DATE = By.xpath(".//div[@class='d606c76c5a']");
    private final By SEARCH_BTN = By.xpath(".//button[@class='fc63351294 a822bdf511 d4b6b7a9e7 cfb238afa1 c938084447 f4605622ad aa11d0d5cd']");
    private final By CHECKBOX_TRAVELING_FOR_WORK = By.xpath(".//label[@class='efeda70352'][@for=':Ri:']");
    private final By CORONAVIRUS_SUPPORT_INFO = By.xpath(".//div[@data-testid='web-shell-global-alert']");
    private final By RECENT_SEARCHES_TITLE_TEXT = By.xpath(".//span[@class='bui-title__text']");

    private final String GOOGLE = "https://www.google.lv/";
    private final By SEARCH_TOOLBAR = By.xpath(".//div[@class='RNNXgb']");
    private final By MENU_BTN_MOR = By.id("ow23");
    private final By TOOLS = By.id("hdtb-tls");
    private final By RESULTS_STRING = By.id("result-stats");
    private final By THREE_DOT_RESULT_BTN = By.xpath("(.//span[@jsname='Bil8Ae'])[1]");
    private final By QUICK_SETTINGS_BTN = By.id("_3YlXZKmSKaenkdUPvMGpmAQ_9");
    private final By ACCOUNT_LOGO_MENU = By.xpath(".//img[@class='gb_j gbii']");
    private final By RIGHT_COLUMN_SEARCH_RESULT = By.xpath("_wpNXZLXiOtD7rgSuxrzoAg_51");

    private final String AMAZON = "https://www.amazon.de/";
    private final By AMAZON_LOGO_BTN = By.id("nav-logo-sprites");
    private final By SEARCH_BAR = By.id("nav-search-bar-form");
    private final By ACCOUNT_LIST_MENU_BTN = By.id("mkszvz-r0qxd2-v6gsxu-3bow8n");
    private final By SHOPPING_BASKET = By.cssSelector("a[href='https://www.amazon.de/-/en/gp/cart/view.html?ref_=nav_cart']");
    private final By ALL_MENU_BTN = By.id("HamburgerMenuDesktop");
    private final By SECTION_TOP_DEALS = By.id("deal-of-the-day_desktop-gateway-atf_7");

    private final String SHOPPING_URL = "https://www.1a.lv/";
    private final By SECTION_LEFT_MENU_BUSINESS_OFFERS = By.cssSelector("a[href='https://www.1a.lv/kp/piedavajums-biznesam/fn'");
    private final By SECTION_RIGHT_MENU_STORES = By.cssSelector("a[href='https://www.1a.lv/stores'");
    private final By CHANGE_RU_LANGUAGE = By.cssSelector("a[href='https://www.1a.lv/ru/'");
    private final By CHANGE_LV_LANGUAGE = By.cssSelector("a[href='https://www.1a.lv/'");
    private final By MAIN_LOGO_BTN = By.xpath(".//a[@class='main-logo']");
    private final By SEARCH_WEBSITE_BTN = By.xpath(".//button[@type='submit']");
    private final By SHOPPING_CART_BTN = By.xpath(".//a[@class='cart-block__handle']");
    private final By SMART_NET_LOGO = By.xpath(".//img[@class='smart-net-banner__logo']");
    private final By GIFT_BTN_ICON = By.xpath(".//img[@src='/assets/smart_net/banner-icon-gift-a5f4be14455f68215791cf2fca3f688264cd5286c14ddb485388185484dbc715.svg']");
    private final By MAIM_MENU_HANDLE_ICON = By.xpath(".//i[@class='main-menu__handle-icon icon-svg']");


}
