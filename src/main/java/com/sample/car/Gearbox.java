package com.sample.car;

public class Gearbox extends Part {

    private String type;

    public Gearbox(String name, int price, String type) {
        super(name, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UUID: " + getUUIDString() + "\n" +
                "Price: " + getPrice() + "\n" +
                "Type: " + getType();
    }

    @Override
    public String toStringFormatted() {
        return "Navn: " + getName() + "\n" +
                "Pris: " + getPriceFormatted() + "\n" +
                "Type: " + getType();
    }
}
