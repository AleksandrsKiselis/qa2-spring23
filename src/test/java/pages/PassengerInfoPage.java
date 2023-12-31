package pages;


import model.tickets.Flight;
import model.tickets.Passenger;
import org.openqa.selenium.By;




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


    public void  fillInPassengerInfo(Flight flight, Passenger passenger) {
        baseFunc.type(FIRST_NAME, passenger.getFirstName());
        baseFunc.type(LAST_NAME, passenger.getLastName());
        baseFunc.type(DISCOUNT, flight.getDiscount());
        baseFunc.type(ADULTS, flight.getPassengersCont());
        baseFunc.type(CHILDREN, flight.getChildCont());
        baseFunc.type(BAG, flight.getLuggageCount());
        baseFunc.selectByText(FLIGHT, flight.getFlightDate());
    }

    public String getDepartureAirport() {
        return baseFunc.waitForNumbersOfElementsToBe(FLIGHT_INFO, 2).get(0).getText();
    }


    public String getArrivalAirport() {
        return baseFunc.waitForNumbersOfElementsToBe(FLIGHT_INFO, 2).get(1).getText();
    }

    public String getName() {
        return baseFunc.waitForNumbersOfElementsToBe(FLIGHT_INFO, 5).get(2).getText();
    }

    public void clickGetPrice() {baseFunc.click(GET_PRICE_LINK);}
    public void clickBookBtn() {baseFunc.click(BOOK_BTN);}


    public void fillInPassengerInfo(String firstName, String lastName, String discount, int passengersCount, int childCount, int luggageCount, String flightDate, int seatNr) {
    }
}
