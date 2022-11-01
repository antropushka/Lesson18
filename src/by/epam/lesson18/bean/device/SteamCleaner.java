package by.epam.lesson18.bean.device;

import java.io.Serializable;
import java.util.Objects;

public class SteamCleaner extends ElectronicDevice implements Serializable {

    private static final long serialVersionUID = 1L;
    private double waterHeatingTime;
    private double maxSteamPressure;

    public SteamCleaner() {

    }

    public SteamCleaner(String brand, Double price, double waterHeatingTime, double maxSteamPressure) {
        super(brand, price);
        this.waterHeatingTime = waterHeatingTime;
        this.maxSteamPressure = maxSteamPressure;
    }


    public double getWaterHeatingTime() {
        return waterHeatingTime;
    }

    public void setWaterHeatingTime(double waterHeatingTime) {
        this.waterHeatingTime = waterHeatingTime;
    }

    public double getMaxSteamPressure() {
        return maxSteamPressure;
    }

    public void setMaxSteamPressure(double maxSteamPressure) {
        this.maxSteamPressure = maxSteamPressure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SteamCleaner)) return false;
        if (!super.equals(o)) return false;
        SteamCleaner that = (SteamCleaner) o;
        return Double.compare(that.getWaterHeatingTime(), getWaterHeatingTime()) == 0 && Double.compare(that.getMaxSteamPressure(), getMaxSteamPressure()) == 0;
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWaterHeatingTime(), getMaxSteamPressure());
    }

    @Override
    public String toString() {
        return "SteamCleaner : " +
                " brand=" + this.getBrand() +
                ", price=" + this.getPrice() +
                ", waterHeatingTime=" + waterHeatingTime +
                ", maxSteamPressure=" + maxSteamPressure;
    }

}