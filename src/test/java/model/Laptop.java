package model;

import java.math.BigDecimal;

public class Laptop {
    //----------------ATTRIBUTES------------
    private String model = "Acer Aspire";
    private float screenSize = 15.6f;
    private String ramType = "DDR4";
    private float weight = 1.78f;
    private String onboardOs = null;
    private int productId = 945191;
    private BigDecimal price = BigDecimal.valueOf(871.99);

    //------------------GETTERS/SETTERS------------------------

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(float screenSize) {
        this.screenSize = screenSize;
    }

    public String getRamType() {
        return ramType;
    }

    public void setRamType(String ramType) {
        this.ramType = ramType;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getOnboardOs() {
        return onboardOs;
    }

    public void setOnboardOs(String onboardOs) {
        this.onboardOs = onboardOs;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //-------------------CUSTOM METHODS----------------------
}
