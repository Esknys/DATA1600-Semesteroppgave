package com.sample.car;

public class Paintjob extends Part {

    private String color;
    private String type;

    public Paintjob(String name, int price, String color, String type) {
        super(name, price);
        this.color = color;
        this.type = type;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
                "Color: " + getColor() + "\n" +
                "Type: " + getType();
    }
}
