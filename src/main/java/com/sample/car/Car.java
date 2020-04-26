package com.sample.car;

public class Car {
    public Engine engine;
    public Gearbox gearbox;
    public Paintjob paintjob;


    public Car(Engine engine, Gearbox gearbox, Paintjob paintjob) {
        this.engine = engine;
        this.gearbox = gearbox;
        this.paintjob = paintjob;
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

    public int getPrice() {
        return engine.getPrice() +
                gearbox.getPrice() +
                paintjob.getPrice();

    }

    @Override
    public String toString() {
        return "Car:" + "\n" +
                "Total price: " + getPrice() + "\n" +
                "---Engine---" + "\n" + engine + "\n" +
                "---Gearbox---" + "\n" + gearbox + "\n" +
                "---Paintjob---" + "\n" + paintjob + "\n";
    }
}
