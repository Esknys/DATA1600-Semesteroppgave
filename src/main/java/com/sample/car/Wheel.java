package com.sample.car;

public class Wheel extends Part{
    private int size;
    private String type;

    public Wheel(String name, String type, int size, int price) {
        super(name, price);

        this.type = type;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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
                "Type: " + getType() + "\n" +
                "Size: " + getSize() +  " inches" + "\n" +
                "Price: " + getPrice();
    }

    @Override
    public String toStringFormatted() {
        return "Navn: " + getName() + "\n" +
                "Pris: " + getPriceFormatted() + "\n" +
                "Type: " + getType() + "\n" +
                "Størrelse: " + getSize() +  " Tommer";
    }


}
