package com.sample.car;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;

public class Car {
    private Engine engine;
    private Gearbox gearbox;
    private Paintjob paintjob;
    private Wheel wheel;
    private ArrayList<Accessory> accessories = new ArrayList<>();
    private UUID uuid;
    private String uuidString;

    public Car(Engine engine, Gearbox gearbox, Paintjob paintjob, Wheel wheel) {
        this.engine = engine;
        this.gearbox = gearbox;
        this.paintjob = paintjob;
        this.wheel = wheel;
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

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
    }

    public void addAccessories(ArrayList<Accessory> inputAccessories) {
        for (Accessory a : inputAccessories) {
            accessories.add(a);
        }
    }

    public void removeAccessory(Accessory inputAccessory) {
        for (Accessory a : accessories) {
            if( a == inputAccessory ) {
                removeAccessory(inputAccessory);
            }
        }
    }

    public void clearAccessories() {
        accessories.clear();
    }

    public ArrayList<Accessory> getAccessories() {
        return accessories;
    }

    public String formatAccessories() {
        String ut = "";

        if (accessories.isEmpty()) {
            ut = "Ingen Ekstrautstyr valgt";
            return ut;
        }

        else if (!accessories.isEmpty()) {

            for (Accessory a : accessories) {
                ut += a.toStringFormatted() + "\n";
            }

        }

        return ut;
    }

    public UUID getUUID() {
        return uuid;
    }

    public String getUUIDString() {
        return uuidString;
    }

    public int getPrice() {
        int price = 0;
        price += engine.getPrice() +
                gearbox.getPrice() +
                paintjob.getPrice() +
                wheel.getPrice();
        for (Accessory a : accessories) {
            price += a.getPrice();
        }
        return price;
    }

    public String getPriceFormatted() {
        Locale locale = new Locale("no", "NO");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(getPrice());
    }

    @Override
    public String toString() {
        String ut = "";
         ut += "Bil:" + "\n" +
                "Total pris: " + getPriceFormatted() + "\n" +
                "---Motor---" + "\n" + engine.toStringFormatted() + "\n" +
                "---Girboks---" + "\n" + gearbox.toStringFormatted() + "\n" +
                "---Maling---" + "\n" + paintjob.toStringFormatted() + "\n" +
                "---Hjul---" + "\n" + wheel.toStringFormatted() + "\n" +
                "---Accessories---" + "\n" + formatAccessories();

         return ut;
    }
}
