package model;

public class Transport {
    //--------------ATTRIBUTES-------------
    private String modeOfTransport;
    private double fuelUsage;
    private int fuelUsage2;
    private int speed;

    public String getModeOfTransport() {
        return modeOfTransport;
    }

    public void setModeOfTransport(String modeOfTransport) {
        this.modeOfTransport = modeOfTransport;
    }

    public double getFuelUsage() {
        return fuelUsage;
    }

    public void setFuelUsage(double fuelUsage) {
        this.fuelUsage = fuelUsage;
    }

    public int getFuelUsage2() {
        return fuelUsage2;
    }

    public void setFuelUsage2(int fuelUsage2) {
        this.fuelUsage2 = fuelUsage2;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //-----------------GETTERS/SETTERS-----------------

}
