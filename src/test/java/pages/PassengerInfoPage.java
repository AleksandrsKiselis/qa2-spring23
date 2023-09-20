package pages;

import model.ReservationInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PassengerInfoPage {
    private final By FIRST_NAME = By.id("name");
    private final By LAST_NAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By ADULTS = By.id("adults");
    private final By CHILDREN = By.id("children");
    private final By BAG = By.id("bugs");
    private final By FLIGHT = By.id("flight");

    private final By GET_PRICE_LINK = By.xpath(".//span[@onclick='setLang();']");
    private final By BOOK_BTN = By.id("book2");
    private final By FLIGHT_INFO = By.xpath(".//span[@class = 'bTxt']");





    private  BaseFunc baseFunc;

    public PassengerInfoPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }



    public void  fillInPassengerInfo(ReservationInfo reservationInfo) {
        baseFunc.type(FIRST_NAME, reservationInfo.getFirstName());
        baseFunc.type(LAST_NAME, reservationInfo.getLastName());
        baseFunc.type(DISCOUNT, reservationInfo.getDiscount());
        baseFunc.type(ADULTS, reservationInfo.getPassengerCount());
        baseFunc.type(CHILDREN, reservationInfo.getChildCount());
        baseFunc.type(BAG, reservationInfo.getBagsCount());
        baseFunc.selectByText(FLIGHT, reservationInfo.getFlightDate());
    }

    public String getDepartureAirport() {
        String airport = "RIX";
        //Finding element by locator
        baseFunc.findElements(FLIGHT_INFO).get(0);
        //Getting text
        baseFunc.getText(FLIGHT_INFO);
        return airport;
    }

    public String getArrivalAirport() {
        String airport = "MEL";
        baseFunc.findElements(FLIGHT_INFO).get(1);
        baseFunc.getText(FLIGHT_INFO);
        return airport;
    }

    public String getName() {
        String name = "Aleksandrs";
        baseFunc.findElements(FLIGHT_INFO).get(2);
        name.substring(0,name.length() - 1);
        baseFunc.getText(FLIGHT_INFO);
        return name;
    }

    public void clickGetPrice() {baseFunc.click(GET_PRICE_LINK);}
    public void clickBookBtn() {baseFunc.click(BOOK_BTN);}


    public void fillInPassengerInfo(String firstName, String lastName, String discount, int passengersCount, int childCount, int luggageCount, String flightDate, int seatNr) {
    }
}
