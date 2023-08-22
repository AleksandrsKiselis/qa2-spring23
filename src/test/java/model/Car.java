package model;

import java.math.BigDecimal;

public class Car {
    //------------ATTRIBUTES--------
    private String make = "Audi";
    private String model = "A6";
    private int power = 130;
    private String gearbox = null;
    private float cubicCapacity = 1.968f;
    private long mileage = 3948576877L;
    private BigDecimal price = BigDecimal.valueOf(19.999);

    //------------------GETTERS/SETTERS------------------------

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public float getCubicCapacity() {
        return cubicCapacity;
    }

    public void setCubicCapacity(float cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }

    public long getMileage() {
        return mileage;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //-------------------CUSTOM METHODS----------------------
    public void printFullMake() {
        System.out.println(make + " " + model);
    }

}
