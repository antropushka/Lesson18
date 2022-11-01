package by.epam.lesson18.bean.device;

import java.io.Serializable;
import java.util.Objects;

public class WashingMachine extends ElectronicDevice implements Serializable {

    private static final long serialVersionUID = 1L;
    private Double maximumLoad;
    private Double maximumSpinSpeed;
    private Integer numOfPrograms;

    public WashingMachine() {
    }
    public WashingMachine(String brand, Double price, Double maximumLoad, Double maximumSpinSpeed, Integer numOfPrograms) {
        super(brand, price);
        this.maximumLoad = maximumLoad;
        this.maximumSpinSpeed = maximumSpinSpeed;
        this.numOfPrograms = numOfPrograms;
    }

    public Double getMaximumLoad() {
        return maximumLoad;
    }

    public void setMaximumLoad(Double maximumLoad) {
        this.maximumLoad = maximumLoad;
    }

    public Double getMaximumSpinSpeed() {
        return maximumSpinSpeed;
    }

    public void setMaximumSpinSpeed(Double maximumSpinSpeed) {
        this.maximumSpinSpeed = maximumSpinSpeed;
    }

    public Integer getNumOfPrograms() {
        return numOfPrograms;
    }

    public void setNumOfPrograms(Integer numOfPrograms) {
        this.numOfPrograms = numOfPrograms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WashingMachine)) return false;
        if (!super.equals(o)) return false;
        WashingMachine that = (WashingMachine) o;
        return Objects.equals(getMaximumLoad(), that.getMaximumLoad()) && Objects.equals(getMaximumSpinSpeed(), that.getMaximumSpinSpeed()) && Objects.equals(getNumOfPrograms(), that.getNumOfPrograms());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMaximumLoad(), getMaximumSpinSpeed(), getNumOfPrograms());
    }

    @Override
    public String toString() {
        return "WashingMachine : " +
                " brand=" + this.getBrand() +
                ", price=" + this.getPrice() +
                ", maximumLoad=" + maximumLoad +
                ", maximumSpinSpeed=" + maximumSpinSpeed +
                ", numOfPrograms=" + numOfPrograms;
    }

}
