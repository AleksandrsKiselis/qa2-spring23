package model;

public class Moon {
    //----------------ATTRIBUTES-----------
    private float radius = 1737.4f;
    private int circumference = 10921;
    private float surfaceArea = 3.793e+7f;
    private long volume = 219580000000L;
    private double mass = 7.342e+39;
    private String natural = "Satellite";
    private float albedo = 0.136f;

    //------------------GETTERS/SETTERS------------------------


    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public int getCircumference() {
        return circumference;
    }

    public void setCircumference(int circumference) {
        this.circumference = circumference;
    }

    public float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public String getNatural() {
        return natural;
    }

    public void setNatural(String natural) {
        this.natural = natural;
    }

    public float getAlbedo() {
        return albedo;
    }

    public void setAlbedo(float albedo) {
        this.albedo = albedo;
    }

    //-------------------CUSTOM METHODS----------------------
}
