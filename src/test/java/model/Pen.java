package model;

import java.math.BigDecimal;

public class Pen {
    //------------ATTRIBUTES-----------
    private String brand = "Zodiac";
    private float lineWidth = 0.5f;
    private String color = "blue";
    private int caseDiameter = 11;
    private float length = 10.8f;
    private String mechanism = null;
    private BigDecimal price = BigDecimal.valueOf(5.68);

    //------------------GETTERS/SETTERS------------------------

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCaseDiameter() {
        return caseDiameter;
    }

    public void setCaseDiameter(int caseDiameter) {
        this.caseDiameter = caseDiameter;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public String getMechanism() {
        return mechanism;
    }

    public void setMechanism(String mechanism) {
        this.mechanism = mechanism;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //-------------------CUSTOM METHODS----------------------
}
