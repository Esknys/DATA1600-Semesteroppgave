package com.sample.car;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Engine extends Part implements Serializable {

    public String fuel;
    public int horsepower;

    public Engine(String name, String fuel, int horsepower, int price) {
        super(name, price);

        this.fuel = fuel;
        this.horsepower = horsepower;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) { this.horsepower = horsepower; }


    @Override
    public String toString() {
        return "UUID: " + getUUIDString() + "\n" +
                "Fuel: " + getName() + "\n" +
                "Horsepower: " + getHorsepower() +  "HP " + "\n" +
                "Price: " + getPrice();
    }

    @Override
    public String toStringFormatted() {
        return "Navn: " + getName() + "\n" +
                "Pris: " + getPriceFormatted() + "\n" +
                "Drivstoff: " + getName() + "\n" +
                "Hestekrefter: " + getHorsepower() +  " HK ";
    }


}
