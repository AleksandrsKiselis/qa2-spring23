package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.tickets.Flight;
import model.tickets.Passenger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BaseFunc;
import pages.HomePage;
import pages.PassengerInfoPage;
import pages.SeatsPage;

import java.util.Map;

public class TicketsStepDefs {
    private Passenger passenger = new Passenger();
    private Flight flight = new Flight();
    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage;
    private PassengerInfoPage infoPage;
    private SeatsPage seatsPage;

    @Given("airports:")
    public void set_airports(Map<String, String> params) {
        flight.setDeparture(params.get("from"));
        flight.setArrival(params.get("to"));
    }

    @Given("passenger info is:")
    public void  set_passenger_info(Map<String, String> params) {
        passenger.setFirstName(params.get("first_name"));
        passenger.setLastName(params.get("last_name"));
    }

    @Given("flight info is:")
    public void set_flight_info(Map<String, String> params) {
        flight.setDiscount(params.get("discount"));
        flight.setPassengersCont(Integer.parseInt(params.get("passengers_count")));
        flight.setChildCont(Integer.parseInt(params.get("child_count")));
        flight.setLuggageCount(Integer.parseInt(params.get("luggage_count")));
        flight.setFlightDate(params.get("flight_date"));
        flight.setSeatNr(Integer.parseInt(params.get("seat_nr")));
    }

    @Given("home page is opened")
    public void open_home_page() {
        baseFunc.openUrl("www.qaguru.lv:8089/tickets");
        homePage = new HomePage(baseFunc);
    }

    @When("we are selecting airports")
    public void select_airports() {
        homePage.selectDepartureAirport(flight.getDeparture());
        homePage.selectArrivalAirport(flight.getArrival());
        homePage.clickGoGoGoBtn();
        infoPage = new PassengerInfoPage(baseFunc);
    }

    @Then("selected airports appears on the passenger info page")
    public void airports_appears() {
        Assertions.assertEquals(infoPage.getDepartureAirport(), "DEPARTURE WRONG!");
        Assertions.assertEquals(infoPage.getArrivalAirport(), "ARRIVAL WRONG!");
        infoPage = new PassengerInfoPage(baseFunc);
    }

    @When("we are filling in passenger info")
    public void passenger_info(Map<String, String> params) {
        passenger.setFirstName(params.get("first_name"));
        passenger.setLastName(params.get("last_name"));
        flight.setDiscount(params.get("discount"));
        flight.setPassengersCont(Integer.parseInt(params.get("passengers_count")));
        flight.setChildCont(Integer.parseInt(params.get("child_count")));
        flight.setLuggageCount(Integer.parseInt(params.get("luggage_count")));
        flight.setFlightDate(params.get("flight_date"));
        flight.setSeatNr(Integer.parseInt(params.get("seat_nr")));
        infoPage = new PassengerInfoPage(baseFunc);
    }

    @And("requesting price")
    public void requesting_price() {
        infoPage.clickGetPrice();
        infoPage = new PassengerInfoPage(baseFunc);
    }

    @And("airports and price appears in flight details")
    public void airports_and_price_appears() {
        Assertions.assertEquals(infoPage.getArrivalAirport(), "Wrong!");
        Assertions.assertEquals(infoPage.getDepartureAirport(), "Error!");
        baseFunc.checkTextPresenceOnPage("");
    }

    @When("we are confirming price")
    public void confirming_price() {
        infoPage.clickBookBtn();
        infoPage = new PassengerInfoPage(baseFunc);
    }

    @And("selecting seat number")
    public void selecting_seat(Map<String, String> params) {
        seatsPage.selectSeat(Integer.parseInt(params.get("seat_nr")));
        seatsPage = new SeatsPage(baseFunc);
    }

    @Then("selected seat number appears")
    public void seat_number_appears(Map<String, String> params) {
        String expectedSeatNumber = params.get("seat_nr");
        Assertions.assertEquals(expectedSeatNumber, "Wrong Seat!");
        seatsPage = new SeatsPage(baseFunc);
    }

    @When("we are confirming seat")
    public void confirming_seat() {
        seatsPage.clickBookButton();
        seatsPage = new SeatsPage(baseFunc);
    }

    @Then("successful registration message appears")
    public void registration_message_appears() {
        WebElement registrationMessageAppears = baseFunc.findElement(By.xpath(".//div[@class = 'finalTxt']"));
        Assertions.assertEquals(registrationMessageAppears, "Wrong message!");

    }


}
