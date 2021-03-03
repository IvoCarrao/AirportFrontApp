package org.AirportFrontApp;

public class Airplane {
    private String id;
    private String brand;

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", yearMade=" + yearMade +
                ", isInTheAir=" + isInTheAir +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearMade() {
        return yearMade;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    public boolean isInTheAir() {
        return isInTheAir;
    }

    public void setInTheAir(boolean inTheAir) {
        isInTheAir = inTheAir;
    }

    private int yearMade;
    private boolean isInTheAir;
}
