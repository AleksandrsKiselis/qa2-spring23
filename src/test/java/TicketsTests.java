import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TicketsTests {
    private final By FROM = By.id("afrom");
    private final By TO = By.id("bfrom");
    private final By GO_BTN = By.xpath(".//span[@class = 'gogogo']");
    private final By GET_PRICE_LINK = By.xpath(".//span[@onclick='setLang();']");
    private final By BOOK_BTN = By.id("book2");
    private final By SELECT_SEAT = By.xpath(".//div[@onclick='seat(1)']");

   // private final By SELECTED_AIRPORT = By.xpath(".//span[@class = 'bTxt']");
    private final By NAME_INPUT = By.id("name");
    private final By SURNAME_INPUT = By.id("surname");
    private final By DISCOUNT_CODE_INPUT = By.id("discount");
    private final By PEOPLE_COUNT_INPUT = By.id("adults");
    private final By CHILDREN_COUNT_INPUT = By.id("children");
    private final By LUGGAGE_COUNT_INPUT = By.id("bugs");
    private final By NEXT_FLIGHT = By.id("flight");
    private final By FLIGHT_INFO = By.xpath(".//span[@class = 'bTxt']");

    private final String URL = "http://www.qaguru.lv:8089/tickets";
    private final String DEPARTURE_AIRPORT = "RIX";
    private final String ARRIVAL_AIRPORT = "MEL";
    private final String FLIGHT_DATE = "14";

    private final String NAME = "Aleksandrs";
    private final String SURNAME = "Kiselis";
    private final String DISCOUNT_CODE = "37122289";
    private final String PEOPLE = "3";
    private final String CHILDREN = "1";
    private final String LUGGAGE = "2";

    @Test
    public void successTicketsBookCheck() {
        //Open browser
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();

        //Open Home Page
        browser.get(URL);

        //Select Departure airport
        WebElement fromDropdown = browser.findElement(FROM);
        Select fromSelect = new Select(fromDropdown);
        fromSelect.selectByValue(DEPARTURE_AIRPORT);

        //Select Arrival airport
        WebElement toDropdown = browser.findElement(TO);
        Select toSelect = new Select(toDropdown);
        toSelect.selectByValue(ARRIVAL_AIRPORT);

        //Press GoGoGo btn
        browser.findElement(GO_BTN).click();

        //Check if selected airport appears
        //List<WebElement> selectedAirports = browser.findElements(SELECTED_AIRPORT);
        //System.out.println("First airport" + selectedAirports.get(0).getText());
        //System.out.println("Second airport" + selectedAirports.get(1).getText());

        //Fill in passenger personal info
        WebElement nameInputField = browser.findElement(NAME_INPUT);
        nameInputField.clear();
        nameInputField.sendKeys(NAME);
        WebElement surnameInputField = browser.findElement(SURNAME_INPUT);
        surnameInputField.clear();
        surnameInputField.sendKeys(SURNAME);
        WebElement discountCodeInputField = browser.findElement(DISCOUNT_CODE_INPUT);
        discountCodeInputField.clear();
        discountCodeInputField.sendKeys(DISCOUNT_CODE);
        WebElement peopleCountInputField = browser.findElement(PEOPLE_COUNT_INPUT);
        peopleCountInputField.clear();
        peopleCountInputField.sendKeys(PEOPLE);
        WebElement childrenCountInputField = browser.findElement(CHILDREN_COUNT_INPUT);
        childrenCountInputField.clear();
        childrenCountInputField.sendKeys(CHILDREN);
        WebElement luggageCountInputField = browser.findElement(LUGGAGE_COUNT_INPUT);
        luggageCountInputField.clear();
        luggageCountInputField.sendKeys(LUGGAGE);

        //Select next flight
        WebElement flightDropdown = browser.findElement(NEXT_FLIGHT);
        Select flightSelect = new Select(flightDropdown);
        flightSelect.selectByValue(FLIGHT_DATE);

        //Press Get Price link
        browser.findElement(GET_PRICE_LINK).click();

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBe(FLIGHT_INFO, 5));

        List<WebElement> flightInfo = browser.findElements(FLIGHT_INFO);
        Assertions.assertEquals(DEPARTURE_AIRPORT, flightInfo.get(0).getText(), "Wrong Departure Airport!");
        Assertions.assertEquals(ARRIVAL_AIRPORT, flightInfo.get(1).getText(), "Wrong Arrival Airport!");

        String name = flightInfo.get(2).getText();
        Assertions.assertEquals(NAME, name.substring(0, name.length() - 1), "Wrong Name!");

        Assertions.assertEquals(DEPARTURE_AIRPORT, flightInfo.get(3).getText(), "Wrong Departure Airport!");
        Assertions.assertEquals(ARRIVAL_AIRPORT, flightInfo.get(4).getText(), "Wrong Arrival Airport!");

        String pageSource = browser.getPageSource();
        String expectedText = "4540";
        if (pageSource.contains(expectedText)) {
            System.out.println("Price found on page");
        } else {
            System.out.println("Price not found on page");
        }


        //Press Book btn
        browser.findElement(BOOK_BTN).click();

        //Select seat Nr
        browser.findElement(SELECT_SEAT).click();


        //Press Book btn
        browser.findElement(By.id("book3")).click();


        //Check if successful message appears


    }

}
