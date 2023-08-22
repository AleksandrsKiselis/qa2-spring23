package model;

import java.math.BigDecimal;

public class FramePool {
    //-----------------ATTRIBUTES-------------
    private String brand = "BeastPool";
    private int productId = 86777754;
    private float height = 1.20f;
    private float width = 2.05f;
    private int volume = 9860;
    private float length = 4.10f;
    private BigDecimal price = BigDecimal.valueOf(438.99);

    //------------------GETTERS/SETTERS------------------------

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //-------------------CUSTOM METHODS----------------------

    public void printFullArea() {
        System.out.println(width * length);
    }
}
