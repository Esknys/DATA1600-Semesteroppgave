package com.sample.car;

public class Engine extends Part{

    private String fuel;
    private int horsepower;

    public Engine(String name, String fuel, int horsepower, int price) {
        super(name, price);

        this.fuel = fuel;
        this.horsepower = horsepower;
    }

    public String getName() {
        return fuel;
    }

    public int getHorsepower() {
        return horsepower;
    }


    @Override
    public String toString() {
        return "UUID: " + getUUIDString() + "\n" +
                "Fuel: " + getName() + "\n" +
                "Horsepower: " + getHorsepower() +  "HP " + "\n" +
                "Price: " + getPrice();
    }

    @Override
    public String toStringFormatted() {
        return "Name: " + getName() + "\n" +
                "Price: " + getPriceFormatted() + "\n" +
                "Fuel: " + getName() + "\n" +
                "Horsepower: " + getHorsepower() +  "HP ";
    }


}
