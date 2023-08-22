package model;

import java.math.BigDecimal;

public class Rims {
    //---------------ATTRIBUTES------------
    private int diameter = 17;
    private int numberOfScrews = 5;
    private float distanceScrews = 114.3f;
    private float centreDiameter = 67.10f;
    private String colour = "black";
    private int offset = 45;
    private BigDecimal price = BigDecimal.valueOf(458.99);

    //------------------GETTERS/SETTERS------------------------


    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getNumberOfScrews() {
        return numberOfScrews;
    }

    public void setNumberOfScrews(int numberOfScrews) {
        this.numberOfScrews = numberOfScrews;
    }

    public float getDistanceScrews() {
        return distanceScrews;
    }

    public void setDistanceScrews(float distanceScrews) {
        this.distanceScrews = distanceScrews;
    }

    public float getCentreDiameter() {
        return centreDiameter;
    }

    public void setCentreDiameter(float centreDiameter) {
        this.centreDiameter = centreDiameter;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //-------------------CUSTOM METHODS----------------------


}
