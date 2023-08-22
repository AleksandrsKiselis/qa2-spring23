package model;

import java.math.BigDecimal;

public class Motherboard {
    //---------------ATTRIBUTES---------
    private String brand = "Asus";
    private int memorySlots = 4;
    private float weight = 0.433f;
    private Integer expansionSlots = null;
    private String cpu = "Intel";
    private int maximumMemory = 128;
    private BigDecimal price = BigDecimal.valueOf(173.95);

    //------------------GETTERS/SETTERS------------------------


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMemorySlots() {
        return memorySlots;
    }

    public void setMemorySlots(int memorySlots) {
        this.memorySlots = memorySlots;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Integer getExpansionSlots() {
        return expansionSlots;
    }

    public void setExpansionSlots(Integer expansionSlots) {
        this.expansionSlots = expansionSlots;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getMaximumMemory() {
        return maximumMemory;
    }

    public void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //-------------------CUSTOM METHODS----------------------
}
