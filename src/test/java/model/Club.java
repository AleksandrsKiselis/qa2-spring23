package model;

import java.math.BigDecimal;

public class Club {
    //-------------ATTRIBUTES-----------
    private String title = "Big7";
    private int area = 300;
    private float height = 3.2f;
    private int passengerCapacity = 120;
    private char clubSymbol = '7';
    private String coverage = null;
    private BigDecimal rent = BigDecimal.valueOf(2.500);

    //------------------GETTERS/SETTERS------------------------

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public char getClubSymbol() {
        return clubSymbol;
    }

    public void setClubSymbol(char clubSymbol) {
        this.clubSymbol = clubSymbol;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    //-------------------CUSTOM METHODS----------------------
}
