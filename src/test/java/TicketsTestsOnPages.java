import model.ReservationInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.BaseFunc;
import pages.HomePage;
import pages.PassengerInfoPage;
import pages.SeatsPage;

public class TicketsTestsOnPages {
    private final String URL = "www.qaguru.lv:8089/tickets";
    private final String DEPARTURE_AIRPORT = "RIX";
    private final String ARRIVAL_AIRPORT = "MEL";
    private final String FIRST_NAME = "Aleksandrs";

    private int seatNr = 28;
    private ReservationInfo info = new ReservationInfo("Aleksandrs", "Kiselis", "37122289",
            3, 1, 2, "14-05-2018");

    @Test
    public void successTicketsBookCheck() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(URL);

        HomePage homePage = new HomePage(baseFunc);
        homePage.selectDepartureAirport(DEPARTURE_AIRPORT);
        homePage.selectArrivalAirport(ARRIVAL_AIRPORT);
        homePage.clickGoGoGoBtn();

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        infoPage.fillInPassengerInfo(info);
        infoPage.clickGetPrice();
        infoPage.clickBookBtn();

        Assertions.assertEquals(DEPARTURE_AIRPORT, infoPage.getDepartureAirport(), "Error");
        Assertions.assertEquals(ARRIVAL_AIRPORT, infoPage.getArrivalAirport(), "Wrong");
        Assertions.assertEquals(FIRST_NAME, infoPage.getName(), "Wrong Name!");

        baseFunc.checkTextPresenceOnPage("4540");

        SeatsPage seatsPage = new SeatsPage(baseFunc);
        seatsPage.selectSeat(seatNr);
        seatsPage.clickBookButton();





    }
}
