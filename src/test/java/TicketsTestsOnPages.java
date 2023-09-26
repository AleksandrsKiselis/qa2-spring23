
import model.tickets.Flight;
import model.tickets.Passenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.BaseFunc;
import pages.HomePage;
import pages.PassengerInfoPage;
import pages.SeatsPage;

public class TicketsTestsOnPages {
    private final String URL = "www.qaguru.lv:8089/tickets";
    private Passenger passenger = new Passenger("Aleksandrs", "Kiselis");
    private Flight flight = new Flight("RIX", "MEL", "37122289", 3, 1,
            2, "14-05-2018", 28);

    @Test
    public void successTicketsBookCheck() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(URL);

        HomePage homePage = new HomePage(baseFunc);
        homePage.selectDepartureAirport(flight.getDeparture());
        homePage.selectArrivalAirport(flight.getArrival());
        homePage.clickGoGoGoBtn();

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        infoPage.fillInPassengerInfo(flight, passenger);
        infoPage.clickGetPrice();
        infoPage.clickBookBtn();

        Assertions.assertEquals(flight.getDeparture(), infoPage.getDepartureAirport(), "Error");
        Assertions.assertEquals(flight.getArrival(), infoPage.getArrivalAirport(), "Wrong");
        Assertions.assertEquals(passenger.getFirstName(), infoPage.getName(), "Wrong Name!");

        baseFunc.checkTextPresenceOnPage("4540");

        SeatsPage seatsPage = new SeatsPage(baseFunc);
        seatsPage.selectSeat(flight.getSeatNr());
        seatsPage.clickBookButton();





    }
}
