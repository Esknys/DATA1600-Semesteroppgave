package com.sample.car;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.UUID;

public abstract class Part {

    private String name;
    private int price;
    private UUID uuid;
    private String uuidString;

    public Part(String name, int price) {
        this.name = name;
        this.price = price;
        uuid = UUID.randomUUID();
        uuidString = uuid.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }


    //Formaterer pris til norsk format: 15000 -> kr 15 000,00
    public String getPriceFormatted() {
        Locale locale = new Locale("no", "NO");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(price);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public UUID getUUID() {
        return uuid;
    }

    public String getUUIDString() {
        return uuidString;
    }

    public String toStringFormatted() {
        return "Name: " + getName() + "\n" +
                "Price: " + getPriceFormatted();
    }
}
