package com.geelani.day_02_p1_listview;


public class Car {
    private String name;
    private int iconID;

    public Car() {
    }

    public Car(String name, int iconID) {
        this.name = name;
        this.iconID = iconID;
    }

    public String getName() {
        return name;
    }

    public int getIconID() {
        return iconID;
    }
}