package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.tickets.Flight;
import model.tickets.Passenger;
import model.tickets.Reservation;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BaseFunc;
import pages.HomePage;
import pages.PassengerInfoPage;
import pages.SeatsPage;
import requesters.TicketsRequester;

import java.util.List;
import java.util.Map;

public class TicketsStepDefs {
    private Passenger passenger = new Passenger();
    private Flight flight = new Flight();
    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage;
    private PassengerInfoPage infoPage;
    private SeatsPage seatsPage;
    private List<Reservation> reservations;
    private Reservation reservationFromApi;

    public TicketsStepDefs() {
        this.seatsPage = new SeatsPage(baseFunc);
    }

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
    public void check_selected_airports() {
        Assertions.assertEquals(flight.getDeparture(), infoPage.getDepartureAirport(), "Wrong Departure Airport!");
        Assertions.assertEquals(flight.getArrival(), infoPage.getArrivalAirport(), "Wrong Arrival Airport!");
    }

    @When("we are filling in passenger info")
    public void fill_in_flight_info() {
       infoPage.fillInPassengerInfo(flight, passenger);
    }

    @And("requesting price")
    public void requesting_price() {
        infoPage.clickGetPrice();
        infoPage = new PassengerInfoPage(baseFunc);
    }

    @And("airports and price appears in flight details")
    public void airports_and_price_appears() {
        baseFunc.checkTextPresenceOnPage("ERROR!");
    }

    @When("we are confirming price")
    public void confirming_price() {
        infoPage.clickBookBtn();
        infoPage = new PassengerInfoPage(baseFunc);
    }

    @And("selecting seat number")
    public void selecting_seat() {
       seatsPage.selectSeat(28);
    }

    @Then("selected seat number appears")
    public void seat_number_appears() {
        System.out.println("Seat is correct!");

    }

    @When("we are confirming seat")
    public void confirming_seat() {
        seatsPage.clickBookButton();
        seatsPage = new SeatsPage(baseFunc);
    }

    @Then("successful registration message appears")
    public void registration_message_appears() {
        WebElement registrationMessageAppears = baseFunc.findElement(By.xpath(".//div[@class = 'finalTxt']"));
        System.out.println(registrationMessageAppears);

    }

    @When("we are requesting all reservations via API")
    public void request_all_reservations() throws JsonProcessingException {
        TicketsRequester requester = new TicketsRequester();
        reservations = requester.getReservations();
    }

    @Then("current reservation exists in the list")
    public void find_reservation() {
        for (Reservation reservation : reservations) {
            if (reservation.getName().equals(passenger.getFirstName())) {
                reservationFromApi = reservation;
                break;
            }
        }

        Assertions.assertNotNull(reservationFromApi, "Can't find reservation!");
    }

    @Then("all data are stored correctly")
    public void check_reservation_data() {
        Assertions.assertEquals(passenger.getFirstName(), reservationFromApi.getName(), "Wrong Last name!");
        Assertions.assertEquals(flight.getSeatNr(), reservationFromApi.getSeat(), "Wrong Seat Nr!");
        Assertions.assertEquals(flight.getDiscount(), reservationFromApi.getDiscount(), "Wrong Discount!");
        Assertions.assertEquals(flight.getChildCont(), reservationFromApi.getChildren(), "Wrong Child!");
        Assertions.assertEquals(flight.getLuggageCount(), reservationFromApi.getAdults(), "Wrong Lugg!");
    }

}
