package com.geo.example.materialsample;

public class Flower {
    public String name;
    private int imageId;

    public Flower(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }


}
