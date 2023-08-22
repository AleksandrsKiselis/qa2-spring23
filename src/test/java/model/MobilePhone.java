package model;

import java.math.BigDecimal;

public class MobilePhone {
    //----------------ATTRIBUTES---------------
    private String brand = "Samsung";
    private float screenSize = 6.6f;
    private int memory = 512;
    private int ram = 8;
    private String type = "touchscreen";
    private float weight = 0.196f;
    private BigDecimal price = BigDecimal.valueOf(899.99);

    //------------------GETTERS/SETTERS------------------------

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(float screenSize) {
        this.screenSize = screenSize;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //-------------------CUSTOM METHODS----------------------
}
