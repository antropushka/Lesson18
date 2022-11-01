package by.epam.lesson18.bean.device;


import java.io.Serializable;
import java.util.Objects;

public class VacuumCleaner extends ElectronicDevice implements Serializable {

    private static final long serialVersionUID = 1L;
    private String construction;
    private Double dustContainerVolume;

    public VacuumCleaner() {
    }

    public VacuumCleaner(String brand, Double price, String construction, Double dustContainerVolume) {
        super(brand, price);
        this.construction = construction;
        this.dustContainerVolume = dustContainerVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VacuumCleaner)) return false;
        if (!super.equals(o)) return false;
        VacuumCleaner that = (VacuumCleaner) o;
        return Objects.equals(construction, that.construction) && Objects.equals(dustContainerVolume, that.dustContainerVolume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), construction, dustContainerVolume);
    }

    @Override
    public String toString() {
        return "VacuumCleaner :" +
                " brand=" + this.getBrand() +
                ", price=" + this.getPrice() +
                ", construction=" + construction +
                ", dustContainerVolume=" + dustContainerVolume;
    }
}