package by.epam.lesson18.bean.device;

import java.util.Objects;

public abstract class ElectronicDevice {

   private String brand;
   private Double price;

    public ElectronicDevice() {
    }

    public ElectronicDevice(String brand, Double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectronicDevice)) return false;
        ElectronicDevice that = (ElectronicDevice) o;
        return Objects.equals(getBrand(), that.getBrand()) && Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getPrice());
    }

    @Override
    public String toString() {
        return "ElectronicDevice " +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

}
