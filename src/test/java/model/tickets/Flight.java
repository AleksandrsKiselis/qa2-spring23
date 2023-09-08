package model.tickets;

public class Flight {
    private String departure;
    private String arrival;
    private String discount;
    private int passengersCont;
    private int childCont;
    private int luggageCount;
    private String flightDate;
    private int seatNr;

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getPassengersCont() {
        return passengersCont;
    }

    public void setPassengersCont(int passengersCont) {
        this.passengersCont = passengersCont;
    }

    public int getChildCont() {
        return childCont;
    }

    public void setChildCont(int childCont) {
        this.childCont = childCont;
    }

    public int getLuggageCount() {
        return luggageCount;
    }

    public void setLuggageCount(int luggageCount) {
        this.luggageCount = luggageCount;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public int getSeatNr() {
        return seatNr;
    }

    public void setSeatNr(int seatNr) {
        this.seatNr = seatNr;
    }
}
