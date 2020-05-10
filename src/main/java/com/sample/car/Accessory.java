package com.sample.car;

import java.io.Serializable;

public class Accessory extends Part implements Serializable {
    private String description;

    public Accessory(String name, String description, int price) {
        super(name, price);

        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UUID: " + getUUIDString() + "\n" +
                "Description: " + getDescription() + "\n" +
                "Price: " + getPrice();
    }

    @Override
    public String toStringFormatted() {
        return "Navn: " + getName() + "\n" +
                "Pris: " + getPriceFormatted() + "\n" +
                "Beskrivelse: " + getDescription();
    }


}
