package com.geelani.day_02_p1_listview;


import java.io.Serializable;

public class Crop implements Serializable{
    public String name;
    public String desc;
    public String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}