package org.AirportFrontApp.model;

public class Airplane {
    private Integer id;
    private String brand;
    private Integer yearMade;
    private boolean isInTheAir;

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", yearMade=" + yearMade +
                ", isInTheAir=" + isInTheAir +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
