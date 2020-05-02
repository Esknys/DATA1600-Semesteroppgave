package com.sample.car;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.UUID;

public class Car {
    private Engine engine;
    private Gearbox gearbox;
    private Paintjob paintjob;
    private UUID uuid;
    private String uuidString;

    public Car(Engine engine, Gearbox gearbox, Paintjob paintjob) {
        this.engine = engine;
        this.gearbox = gearbox;
        this.paintjob = paintjob;
        uuid = UUID.randomUUID();
        uuidString = uuid.toString();
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public Paintjob getPaintjob() {
        return paintjob;
    }

    public void setPaintjob(Paintjob paintjob) {
        this.paintjob = paintjob;
    }

    public UUID getUUID() {
        return uuid;
    }

    public String getUUIDString() {
        return uuidString;
    }

    public int getPrice() {
        return engine.getPrice() +
                gearbox.getPrice() +
                paintjob.getPrice();
    }

    public String getPriceFormatted() {
        Locale locale = new Locale("no", "NO");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(getPrice());
    }

    @Override
    public String toString() {
        return "Car:" + "\n" +
                "Total price: " + getPriceFormatted() + "\n" +
                "---Engine---" + "\n" + engine.toStringFormatted() + "\n" +
                "---Gearbox---" + "\n" + gearbox.toStringFormatted() + "\n" +
                "---Paintjob---" + "\n" + paintjob.toStringFormatted() + "\n";
    }
}
